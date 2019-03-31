package com.cagf.tool.hbm2serviceimpl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Helper
{
	private String SPOT = ".";
	private String ANCHOR = "name";
	private String QUOTE = "\"";
	private String STAR = "*";
	private String SERVICE_IMPL = "service.impl";
	private String SERVICE_IMPL_EXT = "ServiceImpl.java";

	private static Helper helper = new Helper();

	private Helper()
	{

	}

	public static Helper getInstance()
	{
		return helper;
	}

	private String getFileData(String fileName)
	{
		FileReader in = null;

		try
		{
			File inputFile = new File(fileName);
			in = new FileReader(inputFile);
			char[] fileData = new char[(int) inputFile.length()];
			in.read(fileData);
			return String.copyValueOf(fileData);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return "";
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	private String getTemplateServiceImpl()
	{
		return this.getFileData(Configer.getInstance()
				.getServiceImplTemplatePath());
	}

	private String getHBM(String strSource)
	{
		int pos1 = strSource.indexOf(ANCHOR);
		int pos2 = strSource.indexOf(QUOTE, pos1);
		int pos3 = strSource.indexOf(QUOTE, pos2 + 1);

		String strHBM = strSource.substring(pos2 + 1, pos3);
		return strHBM;
	}

	private String getPackageName(String hbm)
	{
		return hbm.substring(0, hbm
				.lastIndexOf(SPOT, hbm.lastIndexOf(SPOT) - 1))
				+ SPOT + SERVICE_IMPL;
	}

	private String getImportName(String hbm)
	{
		return hbm.substring(0, hbm.lastIndexOf(SPOT)) + SPOT + STAR;
	}

	private String getClassName(String hbm)
	{
		return hbm.substring(hbm.lastIndexOf(SPOT) + 1, hbm.length());
	}

	private String getPathName(String hbm)
	{
		String result = "";
		String temp = this.getPackageName(hbm);
		StringTokenizer st = new StringTokenizer(temp, SPOT);

		while (st.hasMoreTokens())
		{
			result += st.nextToken();
			result += "/";
		}

		return result;
	}

	private String getServiceImplFileName(String hbm)
	{
		return this.getClassName(hbm) + SERVICE_IMPL_EXT;
	}

	private String doReplace(String templateContent, String packageData,
			String importData, String className)
	{
		String packageDataTemplate = "@PACKAGE@";
		String importDataTemplate = "@IMPORTBEANS@";
		String classNameTemplate = "@CLASSNAME@";
		String serviceImplInterfaceTemplate = "@IMPORTSERVICEINTERFACE@";
		String smallClassNameTemplate = "@classname@";
		String importDAO = "@IMPORTDAO@";

		templateContent = templateContent.replaceAll(packageDataTemplate,
				packageData);
		templateContent = templateContent.replaceAll(importDataTemplate,
				importData);
		templateContent = templateContent.replaceAll(classNameTemplate,
				className);
		templateContent = templateContent.replaceAll(
				serviceImplInterfaceTemplate, packageData.substring(0,
						packageData.lastIndexOf(".") + 1)
						+ STAR);
		templateContent = templateContent.replaceAll(smallClassNameTemplate,
				className.substring(0, 1).toLowerCase()
						+ className.substring(1));

		String str = packageData.substring(0, packageData.lastIndexOf(".",
				packageData.lastIndexOf(".") - 1)); // general package

		String daoPackage = str + ".dao." + className + "DAO";

		templateContent = templateContent.replaceAll(importDAO, daoPackage);

		return templateContent;
	}

	private boolean mkDir(String filePath)
	{
		File dir = new File(filePath);
		return dir.mkdirs();
	}

	private void bornFile(String filePath, String daoFileName,
			String fileContent)
	{
		this.mkDir(filePath);
		File outFile = new File(filePath + daoFileName);
		FileWriter out = null;
		try
		{
			out = new FileWriter(outFile);
			out.write(fileContent.toCharArray());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void generateServiceImpl(String fileName, String outputPath)
	{
		String hbmFileContent = this.getFileData(fileName); // ��ȡhbm�ļ�����
		String templateFileData = this.getTemplateServiceImpl(); // ��ȡģ���ļ�����
		String hbm = this.getHBM(hbmFileContent); // ��ȡhbm�ļ��ж�������ȫ��
		String packageData = this.getPackageName(hbm); // ��ȡ���趨service impl��İ���
		String importData = this.getImportName(hbm); // ��ȡ�����bean
		String className = this.getClassName(hbm); // ��ȡ�������
		String filePath = this.getPathName(hbm); // ��ȡȫ·��
		String serviceFileName = this.getServiceImplFileName(hbm); // ��ȡService
		// impl�������

		String daoFileContent = this.doReplace(templateFileData, packageData,
				importData, className); // ��ȡģ���ļ������ݲ��滻����Ӧ��ģ��

		this.bornFile(outputPath + "/" + filePath, serviceFileName,
				daoFileContent); // ��serviceimpl����д���ļ���
	}
}
