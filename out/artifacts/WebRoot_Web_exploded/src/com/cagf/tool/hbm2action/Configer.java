package com.cagf.tool.hbm2action;

public class Configer
{
	private String addActionPath = "/add_action_template.java";
	
	private String listActionPath = "/list_action_template.java";
	
	private String updatePActionPath = "/updatep_action_template.java";
	
	private String updateActionPath = "/update_action_template.java";
	
	private String deleteActionPath = "/delete_action_template.java";
	
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

	public String getAddActionPath()
	{
		return rootPath + addActionPath;
	}

	public String getListActionPath()
	{
		return rootPath + listActionPath;
	}
	
	public String getUpdatePActionPath()
	{
		return rootPath + updatePActionPath;
	}

	public String getUpdateActionPath()
	{
		return rootPath + updateActionPath;
	}

	public String getDeleteActionPath()
	{
		return rootPath + deleteActionPath;
	}
}
