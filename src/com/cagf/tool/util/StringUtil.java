package com.cagf.tool.util;

public class StringUtil
{
	public static String obtainGetMethodName(String name)
	{
		return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String obtainSetMethodName(String name)
	{
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
