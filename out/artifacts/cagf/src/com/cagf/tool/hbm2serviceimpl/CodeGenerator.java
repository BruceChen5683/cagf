package com.cagf.tool.hbm2serviceimpl;

public class CodeGenerator
{
	private static String outputPath;

	public static void main(String[] args)
	{
		int count = 0;

		System.out.println("generating *.ServiceImpl...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); 
			}
			else if (temp.startsWith("--rootpath="))
			{
				Configer.getInstance().setServiceImplTemplatePath(
						temp.substring(11));
			}
			else
			{
				System.out.println("generating  *.ServiceImpl");
				++count;

				Helper.getInstance().generateServiceImpl(temp, outputPath);
			}
		}

		System.out.println("total " + count + " ServiceImpl");
	}

}
