package com.cagf.tool.hbm2daoimpl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Helper {
	private static Helper helper = new Helper();
	
	private Helper(){		
	
	}
	
	public static Helper getInstance(){
		return helper;
	}
	
	private String getFileData(String fileName) {
		FileReader in = null;
		try{
			File inFil = new File(fileName);
			
			System.out.println("inFile "+inFil.getAbsolutePath());
			in = new FileReader(inFil);
			char[] fileData = new char[(int)inFil.length()];
			in.read(fileData);
			return String.copyValueOf(fileData);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}finally {
			try{
				in.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private String getTemplateDAO(){
		return this.getFileData(Configer.getInstance().getDaoTemplatePath());
	}
	
	private String getHBM(String strSource){
		int pos1 = strSource.indexOf("name");
		int pos2 = strSource.indexOf("\"",pos1);
		int pos3 = strSource.indexOf("\"",pos2+1);
		String hbmClassName = strSource.substring(pos2+1,pos3);
		return hbmClassName;
	}
	
	private String getPackageName(String hbm){
		return hbm.substring(0,hbm.lastIndexOf(".",hbm.lastIndexOf(".")-1))+".impl";
	}
	
	private String getImportName(String hbm){
		return hbm.substring(0, hbm.lastIndexOf("."))+".*";
	}
	
	private String getImporeInterfaceName(String hbm){
		return hbm.substring(0,hbm.lastIndexOf(".",hbm.lastIndexOf(".")-1))+".dao.*";
	}
	
	private String getClassName(String hbm){
		return hbm.substring(hbm.lastIndexOf(".")+1,hbm.length());
	}
	
	private String getPathName(String hbm){
		String result = "";
		String tmp = this.getPackageName(hbm);
		StringTokenizer st = new StringTokenizer(tmp,".");
		
		while(st.hasMoreTokens()){
			result += st.nextToken();
			result += "/";
		}
		return result;
	}
	
	private String getDaoFileName(String hbm){
		return this.getClassName(hbm)+"DaoImpl.java";
	}
	
	private String doReplace(String templateContent,String packageData,String importData,String className,String date,String imporeInterface){
		templateContent = templateContent.replaceAll("@PACKAGE@", packageData);
		templateContent = templateContent.replace("@IMPORTBEANS@", importData);
		templateContent = templateContent.replaceAll("@IMPORTDAOINTERFACE@", imporeInterface);
		templateContent = templateContent.replaceAll("@CLASSNAME@", className);
		templateContent = templateContent.replaceAll("@DATE@", date);
		return templateContent;
	}
	
	private boolean mkDir(String filePath){
		File dir = new File(filePath);
		return dir.mkdirs();
	}
	
	private void bornFile(String filePath,String daoFileName,String fileContent){
		this.mkDir(filePath);
		
		File outFile = new File(filePath+daoFileName);
		FileWriter out = null;
		
		try{
			out = new FileWriter(outFile);
			out.write(fileContent.toCharArray());
		}catch(Exception e){
			e.printStackTrace();	
		}finally {
			try{
				out.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getDateNow(Date dateDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
	
	public void generaDaoImpl(String fileName,String outputPath){
		String hbmFileContent = this.getFileData(fileName);// 　获取hbm文件内容
		String templateContent = this.getTemplateDAO();//获取模板文件内容
		String hbm = this.getHBM(hbmFileContent);//获取hbm文件中定义的类的全名
		String packageData = this.getPackageName(hbm);//获取bean设定dao类的包名
		String importData = this.getImportName(hbm);//获取导入的bean
		String imporeInterface = this.getImporeInterfaceName(hbm);
		String className = this.getClassName(hbm);//获取类的名字
		String filePath = this.getPathName(hbm);//获取全路径
		String daoFileName = this.getDaoFileName(hbm);//获取Dao类的名字
		String date = this.getDateNow(new Date());
		//获取模板文件内容并替换相应的模板
		String daoFileContent = this.doReplace(templateContent, packageData, importData, className,date,imporeInterface);
		//dao写入文件
		this.bornFile(outputPath+"/"+filePath, daoFileName, daoFileContent);
	}
}
