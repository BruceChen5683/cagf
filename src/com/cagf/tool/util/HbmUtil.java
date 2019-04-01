package com.cagf.tool.util;

public class HbmUtil
{
	private String beanPackageName;

	private String servicePackageName;

	private String generalPackageName;

	private String className;

	private String beanPathName;

	private String actionPackageName;

	private String actionPathName;

	private String servicePathName;

	private String smallClassName;

	public String getSmallClassName()
	{
		return smallClassName;
	}

	public void setSmallClassName(String smallClassName)
	{
		this.smallClassName = smallClassName;
	}

	public String getBeanPackageName()
	{
		return beanPackageName;
	}

	public void setBeanPackageName(String beanPackageName)
	{
		this.beanPackageName = beanPackageName;
	}

	public String getServicePackageName()
	{
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName)
	{
		this.servicePackageName = servicePackageName;
	}

	public String getGeneralPackageName()
	{
		return generalPackageName;
	}

	public void setGeneralPackageName(String generalPackageName)
	{
		this.generalPackageName = generalPackageName;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getBeanPathName()
	{
		return beanPathName;
	}

	public void setBeanPathName(String beanPathName)
	{
		this.beanPathName = beanPathName;
	}

	public String getActionPackageName()
	{
		return actionPackageName;
	}

	public void setActionPackageName(String actionPackageName)
	{
		this.actionPackageName = actionPackageName;
	}

	public String getActionPathName()
	{
		return actionPathName;
	}

	public void setActionPathName(String actionPathName)
	{
		this.actionPathName = actionPathName;
	}

	public String getServicePathName()
	{
		return servicePathName;
	}

	public void setServicePathName(String servicePathName)
	{
		this.servicePathName = servicePathName;
	}

	public HbmUtil(String hbmFileName)
	{
		String hbmData = FileUtil.getFileData(hbmFileName);

		int pos1 = hbmData.indexOf("name");
		int pos2 = hbmData.indexOf("\"", pos1);
		int pos3 = hbmData.indexOf("\"", pos2 + 1);

		String beanFullName = hbmData.substring(pos2 + 1, pos3);

		this.className = beanFullName
				.substring(beanFullName.lastIndexOf(".") + 1);

		this.smallClassName = this.className.substring(0, 1).toLowerCase()
				+ this.className.substring(1);

		// packages
		this.beanPackageName = beanFullName.substring(0, beanFullName
				.lastIndexOf("."));
		this.generalPackageName = beanPackageName.substring(0, beanPackageName
				.lastIndexOf("."));
		this.servicePackageName = this.generalPackageName + ".service";
		this.actionPackageName = this.generalPackageName + ".action."
				+ this.className.toLowerCase();

		// paths
		this.beanPathName = package2Path(beanPackageName);
		this.servicePathName = package2Path(servicePackageName);
		this.actionPathName = package2Path(actionPackageName);

	}

	private String package2Path(String packageName)
	{
		return packageName.replace(".", "/");
	}

}
