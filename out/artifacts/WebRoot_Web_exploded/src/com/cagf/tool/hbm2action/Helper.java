package com.cagf.tool.hbm2action;

import com.cagf.tool.util.*;

public class Helper
{
	private static Helper helper = new Helper();

	private String outputPath;

	private String hbmFilePath;

	private HbmUtil hbmUtil;

	private Helper()
	{

	}

	public static Helper getInstance()
	{
		return helper;
	}

	public void generateActions(String hbmFilePath, String outputPath)
	{
		this.hbmFilePath = hbmFilePath;
		this.outputPath = outputPath;
		this.hbmUtil = new HbmUtil(hbmFilePath);

		// 完成CRUD Action生成
		this.generateAddAction();
		this.generateListAction();
		this.generateUpdatePAction();
		this.generateUpdateAction();
		this.generateDeleteAction();
	}

	private void generateAddAction()
	{
		// 完成.java与struts.xml的生成
		this.generateAddActionFile();
	}

	private void generateListAction()
	{
		this.generateListActionFile();
	}

	private void generateUpdatePAction()
	{
		this.generateUpdatePActionFile();
	}

	private void generateUpdateAction()
	{
		this.generateUpdateActionFile();
	}
	
	private void generateDeleteAction()
	{
		this.generateDeleteActionFile();
	}

	private void generateAddActionFile()
	{
		String addActionTemplate = FileUtil.getFileData(Configer.getInstance()
				.getAddActionPath());

		addActionTemplate = addActionTemplate.replaceAll("@ACTIONPACKAGENAME@",
				hbmUtil.getActionPackageName());
		addActionTemplate = addActionTemplate.replaceAll("@BEANPACKAGENAME@",
				hbmUtil.getBeanPackageName() + ".*");
		addActionTemplate = addActionTemplate.replaceAll(
				"@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
		addActionTemplate = addActionTemplate.replaceAll("@CLASSNAME@", hbmUtil
				.getClassName());
		addActionTemplate = addActionTemplate.replaceAll("@ADDBEAN@", this
				.getAddActionFieldData());
		addActionTemplate = addActionTemplate.replaceAll("@SETPROPERTY@", this
				.getSetPropertyData());

		String fileName = this.outputPath + "/" + hbmUtil.getActionPathName()
				+ "/Add" + hbmUtil.getClassName() + ".java";
		
		
		System.out.println("fileName ------------"+fileName);

		FileUtil.setFileData(fileName, addActionTemplate);
	}

	private String getAddActionFieldData()
	{
		String[][] fields = ClassUtil.getFields(hbmFilePath);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];
			String type = fields[i][1]
					.substring(fields[i][1].lastIndexOf(".") + 1); // 去掉包名

			sb.append("\tprivate ").append(type).append(" ").append(name)
					.append(";\n\n");
		}

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];
			String type = fields[i][1]
					.substring(fields[i][1].lastIndexOf(".") + 1); // 去掉包名

			String getMethodName = StringUtil.obtainGetMethodName(name);

			sb.append("\n\tpublic ").append(type).append(" ").append(
					getMethodName).append("()\n\t{\n\t\treturn ").append(name)
					.append(";\n\t}");

			String setMethodName = StringUtil.obtainSetMethodName(name);

			sb.append("\n\tpublic void ").append(setMethodName).append("(")
					.append(type).append(" ").append(name).append(
							")\n\t{\n\t\t").append("this.").append(name)
					.append(" = ").append(name).append(";\n\t}");
		}

		return sb.toString();
	}

	private String getUpdateActionFieldData()
	{
		String[][] fields = ClassUtil.getFields(hbmFilePath);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];
			String type = fields[i][1]
					.substring(fields[i][1].lastIndexOf(".") + 1); // 去掉包名

			sb.append("\tprivate ").append(type).append(" ").append(name)
					.append(";\n\n");
		}

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];
			String type = fields[i][1]
					.substring(fields[i][1].lastIndexOf(".") + 1); // 去掉包名

			String getMethodName = StringUtil.obtainGetMethodName(name);

			sb.append("\n\tpublic ").append(type).append(" ").append(
					getMethodName).append("()\n\t{\n\t\treturn ").append(name)
					.append(";\n\t}");

			String setMethodName = StringUtil.obtainSetMethodName(name);

			sb.append("\n\tpublic void ").append(setMethodName).append("(")
					.append(type).append(" ").append(name).append(
							")\n\t{\n\t\t").append("this.").append(name)
					.append(" = ").append(name).append(";\n\t}");
		}

		return sb.toString();
	}

	private String getSetPropertyData()
	{
		String[][] fields = ClassUtil.getFields(hbmFilePath);

		StringBuffer sb = new StringBuffer();

		sb.append("\t\t").append(hbmUtil.getClassName()).append(" bean = new ")
				.append(hbmUtil.getClassName()).append("();\n\n\t\t");

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			String setMethodName = StringUtil.obtainSetMethodName(name);

			sb.append("bean.").append(setMethodName).append("(").append(name)
					.append(");\n\t\t");

		}

		sb.append("\n\t\tthis.service.save").append(hbmUtil.getClassName())
				.append("(bean);");

		return sb.toString();

	}

	private String getUpdatePropertyData()
	{
		String[][] fields = ClassUtil.getFields(hbmFilePath);

		StringBuffer sb = new StringBuffer();
		sb.append("\t\t");

		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			String setMethodName = StringUtil.obtainSetMethodName(name);

			sb.append("bean.").append(setMethodName).append("(").append(name)
					.append(");\n\t\t");

		}

		return sb.toString();
	}

	private void generateListActionFile()
	{
		String listActionTemplate = FileUtil.getFileData(Configer.getInstance()
				.getListActionPath());

		listActionTemplate = listActionTemplate.replaceAll(
				"@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
		listActionTemplate = listActionTemplate.replaceAll("@BEANPACKAGENAME@",
				hbmUtil.getBeanPackageName() + ".*");
		listActionTemplate = listActionTemplate.replaceAll(
				"@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
		listActionTemplate = listActionTemplate.replaceAll("@CLASSNAME@",
				hbmUtil.getClassName());

		String fileName = this.outputPath + "/" + hbmUtil.getActionPathName()
				+ "/List" + hbmUtil.getClassName() + ".java";

		FileUtil.setFileData(fileName, listActionTemplate);
	}

	private void generateUpdateActionFile()
	{
		String updateActionTemplate = FileUtil.getFileData(Configer
				.getInstance().getUpdateActionPath());

		updateActionTemplate = updateActionTemplate.replaceAll(
				"@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
		updateActionTemplate = updateActionTemplate.replaceAll(
				"@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
		updateActionTemplate = updateActionTemplate.replaceAll(
				"@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
		updateActionTemplate = updateActionTemplate.replaceAll("@CLASSNAME@",
				hbmUtil.getClassName());
		updateActionTemplate = updateActionTemplate.replaceAll("@UPDATEBEAN@",
				this.getUpdateActionFieldData());
		updateActionTemplate = updateActionTemplate.replaceAll(
				"@UPDATEPROPERTY@", this.getUpdatePropertyData());

		String fileName = this.outputPath + "/" + hbmUtil.getActionPathName()
				+ "/Update" + hbmUtil.getClassName() + ".java";

		FileUtil.setFileData(fileName, updateActionTemplate);
	}

	private void generateUpdatePActionFile()
	{
		String updatePActionTemplate = FileUtil.getFileData(Configer
				.getInstance().getUpdatePActionPath());

		updatePActionTemplate = updatePActionTemplate.replaceAll(
				"@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
		updatePActionTemplate = updatePActionTemplate.replaceAll(
				"@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
		updatePActionTemplate = updatePActionTemplate.replaceAll(
				"@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
		updatePActionTemplate = updatePActionTemplate.replaceAll("@CLASSNAME@",
				hbmUtil.getClassName());
		updatePActionTemplate = updatePActionTemplate.replaceAll("@classname@",
				hbmUtil.getSmallClassName());

		String fileName = this.outputPath + "/" + hbmUtil.getActionPathName()
				+ "/UpdateP" + hbmUtil.getClassName() + ".java";

		FileUtil.setFileData(fileName, updatePActionTemplate);
	}
	
	private void generateDeleteActionFile()
	{
		String deleteActionTemplate = FileUtil.getFileData(Configer
				.getInstance().getDeleteActionPath());

		deleteActionTemplate = deleteActionTemplate.replaceAll(
				"@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
		deleteActionTemplate = deleteActionTemplate.replaceAll(
				"@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
		deleteActionTemplate = deleteActionTemplate.replaceAll(
				"@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
		deleteActionTemplate = deleteActionTemplate.replaceAll("@CLASSNAME@",
				hbmUtil.getClassName());

		String fileName = this.outputPath + "/" + hbmUtil.getActionPathName()
				+ "/Delete" + hbmUtil.getClassName() + ".java";

		FileUtil.setFileData(fileName, deleteActionTemplate);
	}

}