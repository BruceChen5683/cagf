package com.cagf.tool.hbm2xml.dao;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator
{
	private static String outputPath;

	private static String fileName;

	private static String projectDirectory;

	private static List<String> hbmFiles = new ArrayList<String>();

	public static void main(String[] args)
	{
		System.out.println("generating Spring DAO configs...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); // ｘｍｌ输出目录
			}
			else if (temp.startsWith("--filename="))
			{
				fileName = temp.substring(11); // 设定配置文件名
			}
			else if (temp.startsWith("--projectDirectory="))
			{
				projectDirectory = temp.substring(19);
			}
			else
			{
				hbmFiles.add(temp); 
			}
		}

		Helper.getInstance().generateDaoXML(hbmFiles, outputPath, fileName,
				projectDirectory);

		System.out.println("finishing Spring DAO configs...");
	}
}
