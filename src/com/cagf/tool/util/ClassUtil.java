package com.cagf.tool.util;

import java.lang.reflect.Field;

public class ClassUtil
{
	public static String[][] getFields(String hbmFilePath)
	{
		HbmUtil hbmUtil = new HbmUtil(hbmFilePath);

		String className = hbmUtil.getBeanPackageName() + "."
				+ hbmUtil.getClassName();
		try
		{
			Class<?> c = Class.forName(className);
			Field[] f = c.getDeclaredFields();

			String[][] fields = new String[f.length][2];

			for (int i = 0; i < f.length; ++i)
			{
				fields[i][0] = f[i].getName();
				fields[i][1] = f[i].getType().getName();
				if(fields[i][1].equals("[B")){
					fields[i][1] = "byte[]";
				}
			}

			return fields;

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}

	}
}
