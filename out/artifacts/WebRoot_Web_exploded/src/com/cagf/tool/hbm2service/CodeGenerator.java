package com.cagf.tool.hbm2service;

public class CodeGenerator
{
	private static String outputPath;

	public static void main(String[] args)
	{
		int count = 0;

		System.out.println("generating *.Service...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); //设定源目录输出目录
			}
			else if (temp.startsWith("--rootpath="))
			{
				Configer.getInstance().setServiceTemplatePath(temp.substring(11)); // 模板文件位置
			}
			else
			{
				System.out.println("generating *.Service");
				++count;

				Helper.getInstance().generateService(temp, outputPath);
			}
		}

		System.out.println("total: " + count + " Service");
	}

}
