package com.cagf.tool.hbm2jsp;

public class Configer
{
	private String addJspPath = "/add_jsp_template.jsp";
	
	private String listJspPath = "/list_jsp_template.jsp";
	
	private String updateJspPath = "/update_jsp_template.jsp";
	
	private static Configer configer = new Configer();
	
	private String rootPath;
	
	private Configer()
	{
		
	}
	
	public static Configer getInstance()
	{
		return configer;
	}

	public String getRootPath()
	{
		return rootPath;
	}

	public void setRootPath(String rootPath)
	{
		this.rootPath = rootPath;
	}

	public String getAddJspPath()
	{
		return rootPath + addJspPath;
	}

	public String getListJspPath()
	{
		return rootPath + listJspPath;
	}

	public String getUpdateJspPath()
	{
		return rootPath + updateJspPath;
	}
}