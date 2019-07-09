package com.cagf.tool.hbm2jsp;

import com.cagf.tool.util.ClassUtil;
import com.cagf.tool.util.FileUtil;
import com.cagf.tool.util.HbmUtil;

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

	public void generateJsps(String hbmFilePath, String outputPath)
	{
		this.hbmFilePath = hbmFilePath;
		this.outputPath = outputPath;
		this.hbmUtil = new HbmUtil(hbmFilePath);

		// 完成CRU JSP生成
		this.generateAddJsp();
		this.generateListJsp();
		this.generateUpdateJsp();
	}

	private void generateAddJsp()
	{
		String fileName = this.outputPath + "/" + this.hbmUtil.getClassName()
				+ "/add" + this.hbmUtil.getClassName() + ".jsp";

		String addJspTemplate = FileUtil.getFileData(Configer.getInstance()
				.getAddJspPath());
		addJspTemplate = addJspTemplate.replaceAll("@CLASSNAME@", hbmUtil
				.getClassName());
		addJspTemplate = addJspTemplate.replaceAll("@ADD@", this
				.getAddFieldData());

		FileUtil.setFileData(fileName, addJspTemplate);
	}

	private void generateListJsp()
	{
		String fileName = this.outputPath + "/" + this.hbmUtil.getClassName()
				+ "/list" + this.hbmUtil.getClassName() + ".jsp";

		String listJspTemplate = FileUtil.getFileData(Configer.getInstance()
				.getListJspPath());

		listJspTemplate = listJspTemplate.replaceAll("@CLASSNAME@", hbmUtil
				.getClassName());
		listJspTemplate = listJspTemplate.replaceAll("@LIST1@", this
				.getLIST1FieldData());
		listJspTemplate = listJspTemplate.replaceAll("@LIST2@", this
				.getLIST2FieldData());

		FileUtil.setFileData(fileName, listJspTemplate);
	}

	private void generateUpdateJsp()
	{
		String fileName = this.outputPath + "/" + this.hbmUtil.getClassName()
				+ "/update" + this.hbmUtil.getClassName() + ".jsp";

		String updateJspTemplate = FileUtil.getFileData(Configer.getInstance()
				.getUpdateJspPath());
		updateJspTemplate = updateJspTemplate.replaceAll("@CLASSNAME@", hbmUtil
				.getClassName());
		updateJspTemplate = updateJspTemplate.replaceAll("@UPDATE@", this
				.getUPDATEFieldData());
		updateJspTemplate = updateJspTemplate.replaceAll("@classname@", hbmUtil
				.getSmallClassName());

		FileUtil.setFileData(fileName, updateJspTemplate);
	}

	private String getAddFieldData()
	{
		String jsp = "<tr bgcolor=\"#f0f0f0\">\n\t<td bgcolor=\"#78A1E6\">@NAME@:</td><td bgcolor=\"#78A1E6\"><input name=\"@NAME@\" type=\"text\" size=\"40\"></td>\n</tr>";

		StringBuffer sb = new StringBuffer();

		String[][] fields = ClassUtil.getFields(hbmFilePath);
		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			if ("id".equals(name))
			{
				continue;
			}

			String str = jsp.replaceAll("@NAME@", name);
			sb.append(str).append("\n\t");
		}

		return sb.toString();
	}

	private String getLIST1FieldData()
	{
		String jsp = "<td align=\"center\" bgcolor=\"#78A1E6\" nowrap=\"nowrap\">@NAME@</td>";

		StringBuffer sb = new StringBuffer();

		String[][] fields = ClassUtil.getFields(hbmFilePath);
		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			if ("id".equals(name))
			{
				continue;
			}

			String str = jsp.replaceAll("@NAME@", name);
			sb.append(str).append("\n\t");
		}

		return sb.toString();
	}

	private String getLIST2FieldData()
	{
		String jsp = "<td align=\"center\" bgcolor=\"#E6ECF9\"><s:property value=\"#u.@NAME@\"/></td>";

		StringBuffer sb = new StringBuffer();

		String[][] fields = ClassUtil.getFields(hbmFilePath);
		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			if ("id".equals(name))
			{
				continue;
			}

			String str = jsp.replaceAll("@NAME@", name);
			sb.append(str).append("\n\t");
		}

		return sb.toString();
	}

	private String getUPDATEFieldData()
	{
		String jsp = "<tr bgcolor=\"#f0f0f0\"><td bgcolor=\"#78A1E6\">@NAME@:</td><td bgcolor=\"#78A1E6\"><input type=\"text\" name=\"@NAME@\" value=\"<s:property value='@classname@.@NAME@'/>\" size=\"40\"/></td>";

		StringBuffer sb = new StringBuffer();

		String[][] fields = ClassUtil.getFields(hbmFilePath);
		for (int i = 0; i < fields.length; ++i)
		{
			String name = fields[i][0];

			if ("id".equals(name))
			{
				continue;
			}

			String str = jsp.replaceAll("@NAME@", name);
			sb.append(str).append("\n\t");
		}

		return sb.toString();

	}

}