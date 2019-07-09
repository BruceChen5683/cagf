package com.cagf.tool.hbm2service;

public class Configer
{
	private String extPath = "/service_template.java";
	
	private static Configer configer = new Configer();
	
	private String serviceTemplatePath;
	
	private Configer()
	{
		
	}
	
	public static Configer getInstance()
	{
		return configer;
	}

	public String getServiceTemplatePath()
	{
		return serviceTemplatePath;
	}

	public void setServiceTemplatePath(String serviceTemplatePath)
	{
		this.serviceTemplatePath = serviceTemplatePath + extPath;
	}

	
}
