package com.cagf.tool.hbm2jsp;

public class CodeGenerator
{
	private static String outputPath;

	public static void main(String[] args)
	{
		int count = 0;

		System.out.println("generating *.jsp...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); // 设定源代码输出目录
			}
			else if (temp.startsWith("--rootpath="))
			{
				Configer.getInstance().setRootPath(temp.substring(11)); // 设定模板文件的绝对路径
			}
			else
			{
				System.out.println("generating *.jsp");
				++count;
				
				// 执行一次生成CRU共3个jsp
				Helper.getInstance().generateJsps(temp, outputPath);
			}
		}

		System.out.println("total: " + count + " jsp");
	}

}