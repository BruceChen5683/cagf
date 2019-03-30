package com.cagf.tool.hbm2xml.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
	private static String outputPath;

	private static String fileName;

	private static String dbProperty;

	private static String hibernateProperty;

	private static String projectDirectory;

	private static List<String> hbmFiles = new ArrayList<String>();
	
	private static final String OUT_PUT_PATH_KEY = "--output=";
	private static final String FILE_NAME__KEY = "--filename=";
	private static final String DB_PROPERTY_KEY = "--dbProperty=";
	private static final String HIBERNATE_PROPERTY_KEY = "--hibernateProperty=";
	private static final String PROJECT_DIR_KEY = "--projectDirectory=";



	public static void main(String[] args) {
		System.out.println("generating Spring infrastructure...");

		for (String temp : args) {
			if (temp.startsWith(OUT_PUT_PATH_KEY)) {
				outputPath = temp.substring(OUT_PUT_PATH_KEY.length()); // 设定xml文件输出目录
			} else if (temp.startsWith(FILE_NAME__KEY)) {
				fileName = temp.substring(FILE_NAME__KEY.length()); // 设定配置文件名
			} else if (temp.startsWith(DB_PROPERTY_KEY)) {
				dbProperty = temp.substring(DB_PROPERTY_KEY.length());
			} else if (temp.startsWith(HIBERNATE_PROPERTY_KEY)) {
				hibernateProperty = temp.substring(HIBERNATE_PROPERTY_KEY.length());
			} else if (temp.startsWith(PROJECT_DIR_KEY)) {
				projectDirectory = temp.substring(PROJECT_DIR_KEY.length());
			} else {
				hbmFiles.add(temp); // 将hbm全路径加入集合
			}
		}

		Helper.getInstance().generateInfrastructureXML(dbProperty, hibernateProperty, hbmFiles, outputPath, fileName,
				projectDirectory);

		System.out.println("finishing Spring infrastructure...");
	}
}
