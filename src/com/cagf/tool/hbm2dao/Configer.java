package com.cagf.tool.hbm2dao;

public class Configer {
	private String extPath = "/dao_template.java";
	
	
	private String daoTemplatePath;
		
	private static Configer configer = new Configer();
	
	private Configer(){}
	
	public static Configer getInstance(){
		return configer;
	}

	public String getDaoTemplatePath() {
		return daoTemplatePath+extPath;
	}

	public void setDaoTemplatePath(String daoTemplatePath) {
		this.daoTemplatePath = daoTemplatePath;
	}
}
