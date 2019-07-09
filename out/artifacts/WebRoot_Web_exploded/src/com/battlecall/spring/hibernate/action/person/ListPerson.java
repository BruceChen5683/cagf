package com.battlecall.spring.hibernate.action.person;

import java.util.*;

import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class ListPerson extends ActionSupport
{
	private List<Person> list;

	private PersonService service;

	public void setList(List<Person> list)
	{
		this.list = list;
	}

	public List<Person> getList()
	{
		return this.list;
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
		this.list = this.service.listPersons(0, 10);

		return SUCCESS;
	}
}

