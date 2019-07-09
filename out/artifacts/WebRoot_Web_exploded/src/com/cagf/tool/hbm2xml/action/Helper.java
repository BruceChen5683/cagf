package com.cagf.tool.hbm2xml.action;

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

	public void generateActionXML(List<String> hbmFiles, String outputPath,
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

			// 生成action配置开始

			for (String hbmFile : hbmFiles)
			{
				File file = new File(hbmFile);
				String name = file.getName();

				String beanName = name.substring(0, name.indexOf(".")); // bean的名字

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

				Element addAction = new Element("bean", n1);
				addAction.setAttribute("id", "add" + beanName).setAttribute(
						"class",
						generalPackage + ".action." + beanName.toLowerCase()
								+ ".Add" + beanName).setAttribute("scope","prototype");
				
				Element listAction = new Element("bean", n1);
				listAction.setAttribute("id", "list" + beanName).setAttribute("class", generalPackage + ".action." + beanName.toLowerCase() + ".List" + beanName).setAttribute("scope","prototype");
				
				Element updatePAction = new Element("bean", n1);
				updatePAction.setAttribute("id", "updateP" + beanName).setAttribute("class", generalPackage + ".action." + beanName.toLowerCase() + ".UpdateP" + beanName).setAttribute("scope","prototype");
				
				Element updateAction = new Element("bean", n1);
				updateAction.setAttribute("id", "update" + beanName).setAttribute("class", generalPackage + ".action." + beanName.toLowerCase() + ".Update" + beanName).setAttribute("scope","prototype");
				
				Element deleteAction = new Element("bean", n1);
				deleteAction.setAttribute("id", "delete" + beanName).setAttribute("class", generalPackage + ".action." + beanName.toLowerCase() + ".Delete" + beanName).setAttribute("scope","prototype");
				
				Element addProperty = new Element("property",n1);
				addProperty.setAttribute("name", "service").setAttribute("ref", beanName.substring(0,1).toLowerCase() + beanName.substring(1) + "Service");
				
				Element listProperty = new Element("property",n1);
				listProperty.setAttribute("name", "service").setAttribute("ref", beanName.substring(0,1).toLowerCase() + beanName.substring(1) + "Service");
				
				Element updateProperty = new Element("property",n1);
				updateProperty.setAttribute("name", "service").setAttribute("ref", beanName.substring(0,1).toLowerCase() + beanName.substring(1) + "Service");
				
				Element updateroperty = new Element("property",n1);
				updateroperty.setAttribute("name", "service").setAttribute("ref", beanName.substring(0,1).toLowerCase() + beanName.substring(1) + "Service");
				
				Element deleteProperty = new Element("property",n1);
				deleteProperty.setAttribute("name", "service").setAttribute("ref", beanName.substring(0,1).toLowerCase() + beanName.substring(1) + "Service");
				
				addAction.addContent(addProperty);
				listAction.addContent(listProperty);
				updatePAction.addContent(updateProperty);
				updateAction.addContent(updateroperty);
				deleteAction.addContent(deleteProperty);
				
				root.addContent(addAction);
				root.addContent(listAction);
				root.addContent(updatePAction);
				root.addContent(updateAction);
				root.addContent(deleteAction);
			}

			// 生成action配置结束

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