package com.cagf.tool.hbm2serviceimpl;

public class Configer
{
	private String extPath = "/service_impl_template.java";
	
	private static Configer configer = new Configer();
	
	private String serviceImplTemplatePath;
	
	private Configer()
	{
		
	}
	
	public static Configer getInstance()
	{
		return configer;
	}

	public String getServiceImplTemplatePath()
	{
		return serviceImplTemplatePath;
	}

	public void setServiceImplTemplatePath(String serviceImplTemplatePath)
	{
		this.serviceImplTemplatePath = serviceImplTemplatePath + extPath;
	}

	
}
