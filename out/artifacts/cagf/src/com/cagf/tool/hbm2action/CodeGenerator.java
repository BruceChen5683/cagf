package com.cagf.tool.hbm2action;

public class CodeGenerator
{
	private static String outputPath;

	public static void main(String[] args)
	{
		int count = 0;

		System.out.println("generating *.action...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); //设定源代码输出目录
			}
			else if (temp.startsWith("--rootpath="))
			{
				Configer.getInstance().setRootPath(temp.substring(11)); // 模板文件位置
			}
			else
			{
				System.out.println("generating *.action");
				++count;
				
				Helper.getInstance().generateActions(temp, outputPath);
			}
		}

		System.out.println("total " + count + " Action");
	}

}
