package com.cagf.tool.hbm2daoimpl;

public class CodeGenerator {
	private static String outPutPath="";
	
	private static final String OUT_PUT_PATH_KEY = "--output=";
	
	public static void main(String[] args){
		int count = 0;
		
		System.out.println("开始生成　*.DAOImpl ...");
		
		for(String tmp : args){
			
			System.out.println("tmp:"+tmp);
			
			if(tmp.startsWith(OUT_PUT_PATH_KEY)){
				System.out.println("output ...");
				outPutPath = tmp.substring(OUT_PUT_PATH_KEY.length());
			}else if(tmp.startsWith("--rootpath=")){
				System.out.println("rootpath ...");
				Configer.getInstance().setDaoTemplatePath(tmp.substring(11));
			}else{
				System.out.println("generate *.Dao");
				Helper.getInstance().generaDaoImpl(tmp, outPutPath);
				++count;
			}
		}
		
		System.out.println("共生成　　"+ count + "个DaoImpl");
	
	}
}
