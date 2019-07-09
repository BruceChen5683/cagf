package com.cagf.tool.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil
{
	public static String getFileData(String fileName)
	{
		try
		{
			File inputFile = new File(fileName);
			FileReader in = new FileReader(inputFile);

			char[] fileData = new char[(int) inputFile.length()];
			in.read(fileData);

			return String.copyValueOf(fileData);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return "";
		}
	}

	public static void setFileData(String fileName, String fileData)
	{
		try
		{
			File outFile = new File(fileName);
			
			//创建父目录以免发生异常
			outFile = new File(outFile.getParent());
			outFile.mkdirs();

			outFile = new File(fileName);
			FileWriter out = new FileWriter(outFile);

			out.write(fileData);
			out.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
