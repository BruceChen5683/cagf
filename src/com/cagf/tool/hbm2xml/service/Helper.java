package com.cagf.tool.hbm2xml.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Helper
{
	private static Helper helper = new Helper();

	private Helper()
	{

	}

	public static Helper getInstance()
	{
		return helper;
	}

	public void generateServiceXML(List<String> hbmFiles, String outputPath,
			String fileName, String projectDirectory)
	{
		try
		{
			Namespace n1 = Namespace
					.getNamespace("http://www.springframework.org/schema/beans");
			Namespace n2 = Namespace.getNamespace("xsi",
					"http://www.w3.org/2001/XMLSchema-instance");

			Element root = new Element("beans", n1);

			Document document = new Document(root);

			root.addNamespaceDeclaration(n2);
			root
					.setAttribute(new Attribute(
							"schemaLocation",
							"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd",
							n2));

			// 生成service配置开始

			for (String hbmFile : hbmFiles)
			{
				File file = new File(hbmFile);
				String name = file.getName();

				String beanName = name.substring(0, name.indexOf(".")); // bean的名字

				String str = beanName.substring(0, 1).toLowerCase()
						+ beanName.substring(1);

				String beanId = str + "Service";

				FileReader in = new FileReader(file);
				char[] ch = new char[(int) file.length()];
				in.read(ch);
				in.close();

				String hbmContent = String.copyValueOf(ch);

				int pos1 = hbmContent.indexOf("name");
				int pos2 = hbmContent.indexOf("\"", pos1);
				int pos3 = hbmContent.indexOf("\"", pos2 + 1);

				String theBeanName = hbmContent.substring(pos2 + 1, pos3);
				String generalPackage = theBeanName.substring(0, theBeanName
						.lastIndexOf(".", theBeanName.lastIndexOf(".") - 1));

				String serviceClassName = generalPackage + ".service.impl."
						+ beanName + "ServiceImpl";

				Element bean = new Element("bean", n1);
				bean.setAttribute("id", beanId).setAttribute("class",
						serviceClassName).setAttribute("scope", "singleton");

				root.addContent(bean);

				Element property = new Element("property", n1);
				property.setAttribute("name", str + "Dao").setAttribute("ref",
						str + "Dao");
				bean.addContent(property);
			}

			// 生成service配置结束

			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");
			format.setIndent("    ");

			XMLOutputter output = new XMLOutputter(format);
			output
					.output(document, new FileWriter(outputPath + "/"
							+ fileName));

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
