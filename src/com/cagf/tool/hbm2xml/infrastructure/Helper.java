package com.cagf.tool.hbm2xml.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Helper {
	
	
	private static Helper helper = new Helper();

	private Helper() {

	}

	public static Helper getInstance() {
		return helper;
	}

	public void generateInfrastructureXML(String dbProperty, String hibernateProperty, List<String> hbmFiles,
			String outputPath, String fileName, String projectDirectory) {
		try {
			Namespace n1 = Namespace.getNamespace("http://www.springframework.org/schema/beans");
			Namespace n2 = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

			Element root = new Element("beans", n1);

			Document document = new Document(root);

			root.addNamespaceDeclaration(n2);
			root.setAttribute(new Attribute("schemaLocation",
					"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd",
					n2));

			Element bean1 = new Element("bean", n1); // 必须指定子元素的命名空间
			bean1.setAttribute("id", "dataSource");
			bean1.setAttribute("class", "org.apache.commons.dbcp.BasicDataSource");
			bean1.setAttribute("destroy-method", "close");

			root.addContent(bean1);

			//获取db.properties 信息加载
			
			System.out.println("projectDirectory:"+projectDirectory);
			System.out.println("dbProperty:"+dbProperty);

			InputStream is = new FileInputStream(projectDirectory + "/" + dbProperty);
			Properties props = new Properties();
			props.load(is);
			is.close();

			Enumeration<?> e = props.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = props.getProperty(key);

				Element element = new Element("property", n1);
				element.setAttribute("name", key).setAttribute("value", value);
				bean1.addContent(element);
			}

			// SessionFactory 处理开始

			Element bean2 = new Element("bean", n1); // 必须指定子元素的命名空间
			bean2.setAttribute("id", "sessionFactory");
			bean2.setAttribute("class", "org.springframework.orm.hibernate3.LocalSessionFactoryBean");

			root.addContent(bean2);

			Element property = new Element("property", n1);
			property.setAttribute("name", "dataSource").setAttribute("ref", "dataSource");

			bean2.addContent(property);

			Element property2 = new Element("property", n1);
			property2.setAttribute("name", "hibernateProperties");

			bean2.addContent(property2);

			Element subProperty = new Element("props", n1);
			property2.addContent(subProperty);

			Properties p = new Properties();
			is = new FileInputStream(projectDirectory + "/" + hibernateProperty);

			p.load(is);
			is.close();

			Enumeration<?> e2 = p.propertyNames();
			while (e2.hasMoreElements()) {
				String key = (String) e2.nextElement();
				String value = p.getProperty(key);

				Element prop = new Element("prop", n1);
				prop.setAttribute("key", key);
				prop.setText(value);

				subProperty.addContent(prop);
			}

			Element property3 = new Element("property", n1);
			property3.setAttribute("name", "mappingResources");
			bean2.addContent(property3);

			Element list = new Element("list", n1);
			property3.addContent(list);

			for (String hbmFile : hbmFiles) {
				Element value = new Element("value", n1);

				File file = new File(hbmFile);
				String hbmName = file.getName();

				// String hbmName =
				// hbmFile.substring(hbmFile.lastIndexOf(File.separator) + 1);
				value.setText(hbmName);

				list.addContent(value);
			}

			// sessionFactory 处理结束

			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");
			format.setIndent("    ");

			XMLOutputter output = new XMLOutputter(format);
			output.output(document, new FileWriter(outputPath + "/" + fileName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

//<?xml version="1.0" encoding="UTF-8"?>
//<beans xmlns="http://www.springframework.org/schema/beans"
//       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
//
//
//
//    <!--hibernate-->
//    <!--dao service 无状态　　singleton-->
//
//    <!--数据源-->
//    <bean class="org.apache.commons.dbcp.BasicDataSource" id="dataSource" destroy-method="close">
//        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
//
//        <property name="url" value="jdbc:mysql://localhost/hibernate"></property>
//
//        <property name="username" value="root"></property>
//
//        <property name="password" value="123456"></property>
//    </bean>
//
//    <bean class="org.springframework.orm.hibernate3.LocalSessionFactoryBean" id="sessionFactory">
//        <property name="dataSource" ref="dataSource"></property>
//
//        <property name="mappingResources">
//            <list>
//                <value>Person.hbm.xml</value>
//            </list>
//        </property>
//
//        <property name="hibernateProperties">
//            <props>
//                <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
//                <prop key="hibernate.show_sql">true</prop>
//            </props>
//        </property>
//    </bean>
//    </beans>