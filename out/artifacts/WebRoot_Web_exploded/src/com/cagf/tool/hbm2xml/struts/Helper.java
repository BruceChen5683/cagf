package com.cagf.tool.hbm2xml.struts;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.cagf.tool.util.HbmUtil;

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

	@SuppressWarnings("unchecked")
	public void generateStrutsXML(List<String> hbmFiles, String outputPath,
			String fileName, String projectDirectory)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			//important
			// 取消对dtd的联网验证
//			builder
//					.setFeature(
//							"http://apache.org/xml/features/nonvalidating/load-external-dtd",
//							false);

			// fileName即struts.xml
			Document document = builder.build(new File(outputPath, fileName));
			Element struts = document.getRootElement();

			List<Element> packages = struts.getChildren("package");

			for (String hbmFile : hbmFiles)
			{
				HbmUtil hbmUtil = new HbmUtil(hbmFile);
				String className = hbmUtil.getClassName();

				boolean isExisted = false;

				for (Element pack : packages)
				{
					String packageName = pack.getAttributeValue("name");
					if (className.equals(packageName))
					{
						isExisted = true;
						break;
					}
				}

				if (!isExisted)
				{
					Element packageElement = new Element("package");
					packageElement.setAttribute("name", className)
							.setAttribute("extends", "struts-default")
							.setAttribute("namespace", "/" + className);//******** 命名空间便于直接访问jsp

					// add action
					Element addAction = new Element("action");
					addAction.setAttribute("name", "add" + className)
							.setAttribute("class", "add" + className);

					Element addActionResult = new Element("result");
					addActionResult.setAttribute("name", "success")
							.setAttribute("type", "redirectAction");

					Element AddActionParam1 = new Element("param");
					AddActionParam1.setAttribute("name", "actionName").setText(
							"list" + className);

					addAction.addContent(addActionResult);
					addActionResult.addContent(AddActionParam1);

					// list action
					Element listAction = new Element("action");
					listAction.setAttribute("name", "list" + className)
							.setAttribute("class", "list" + className);

					Element listActionResult = new Element("result");
					listActionResult.setAttribute("name", "success").setText(
							"list" + className + ".jsp");

					listAction.addContent(listActionResult);

					// delete action
					Element deleteAction = new Element("action");
					deleteAction.setAttribute("name", "delete" + className)
							.setAttribute("class", "delete" + className);

					Element deleteActionResult = new Element("result");
					deleteActionResult.setAttribute("name", "success")
							.setAttribute("type", "redirectAction");

					Element deleteActionParam1 = new Element("param");
					deleteActionParam1.setAttribute("name", "actionName")
							.setText("list" + className);

					Element deleteActionParam2 = new Element("param");
					deleteActionParam2.setAttribute("name", "start").setText(
							"${start}");

					Element deleteActionParam3 = new Element("param");
					deleteActionParam3.setAttribute("name", "range").setText(
							"${range}");

					deleteAction.addContent(deleteActionResult);
					deleteActionResult.addContent(deleteActionParam1)
							.addContent(deleteActionParam2).addContent(
									deleteActionParam3);

					// updateP action
					Element updatePAction = new Element("action");
					updatePAction.setAttribute("name", "updateP" + className)
							.setAttribute("class", "updateP" + className);

					Element updatePActionResult = new Element("result");
					updatePActionResult.setAttribute("name", "success")
							.setText("update" + className + ".jsp");

					updatePAction.addContent(updatePActionResult);

					// update action
					Element updateAction = new Element("action");
					updateAction.setAttribute("name", "update" + className)
							.setAttribute("class", "update" + className);

					Element updateActionResult = new Element("result");
					updateActionResult.setAttribute("name", "success")
							.setAttribute("type", "redirectAction");

					Element updateActionParam1 = new Element("param");
					updateActionParam1.setAttribute("name", "actionName")
							.setText("list" + className);

					updateAction.addContent(updateActionResult);
					updateActionResult.addContent(updateActionParam1);

					// 将CRUD共5个Action附加到package上
					packageElement.addContent(addAction).addContent(listAction)
							.addContent(deleteAction).addContent(updatePAction)
							.addContent(updateAction);

					// 将package元素附加到根struts元素上
					struts.addContent(packageElement);
				}
			}

			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");
			format.setIndent(" ");

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