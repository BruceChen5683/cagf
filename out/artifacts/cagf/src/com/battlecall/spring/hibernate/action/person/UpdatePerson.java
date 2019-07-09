package com.battlecall.spring.hibernate.action.person;

import java.util.*;

import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePerson extends ActionSupport
{
	private PersonService service;

	private long id;

	private String name;

	private int age;


	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setService(PersonService service)
	{
		this.service = service;
	}

	public PersonService getService()
	{
		return this.service;
	}

	@Override
	public String execute() throws Exception
	{
		Person bean = this.service.getPerson(id);

		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		

		this.service.updatePerson (bean);

		return SUCCESS;
		
	}

}


