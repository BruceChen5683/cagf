package com.battlecall.spring.hibernate.action.person;

import java.util.*;

import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePerson extends ActionSupport
{
	private long id;

	private PersonService service;

	public void setId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return this.id;
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
		this.service.deletePerson(id);

		return SUCCESS;
	}
}
