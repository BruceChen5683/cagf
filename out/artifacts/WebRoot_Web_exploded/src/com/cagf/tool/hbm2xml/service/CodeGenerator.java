package com.cagf.tool.hbm2xml.service;

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
		System.out.println("generating Spring Service configs...");

		for (String temp : args)
		{
			if (temp.startsWith("--output="))
			{
				outputPath = temp.substring(9); // �趨xml�ļ����Ŀ¼
			}
			else if (temp.startsWith("--filename="))
			{
				fileName = temp.substring(11); // �趨�����ļ���
			}
			else if (temp.startsWith("--projectDirectory="))
			{
				projectDirectory = temp.substring(19);
			}
			else
			{
				hbmFiles.add(temp); // ��hbmȫ·���ӵ�������
			}
		}

		Helper.getInstance().generateServiceXML(hbmFiles, outputPath, fileName,
				projectDirectory);

		System.out.println("finishing Spring Service configs...");
	}
}
