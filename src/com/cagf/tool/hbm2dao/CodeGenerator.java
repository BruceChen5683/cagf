package com.cagf.tool.hbm2dao;

public class CodeGenerator {
	private static String outPutPath="";
	
	public static void main(String[] args){
		int count = 0;
		
		System.out.println("开始生成　*.DAO ...");
		
		for(String tmp : args){
			
			System.out.println("tmp:"+tmp);
			
			if(tmp.startsWith("--output")){
				System.out.println("output ...");
				outPutPath = tmp.substring(9);
			}else if(tmp.startsWith("--rootpath")){
				System.out.println("rootpath ...");
				Configer.getInstance().setDaoTemplatePath(tmp.substring(11));
			}else{
				System.out.println("generate *.Dao");
				Helper.getInstance().generaDao(tmp, outPutPath);
				++count;
			}
		}
		
		System.out.println("共生成　　"+ count + "个Dao");
	
	}
}
