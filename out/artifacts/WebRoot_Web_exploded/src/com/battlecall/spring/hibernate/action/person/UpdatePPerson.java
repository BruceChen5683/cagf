package com.battlecall.spring.hibernate.action.person;

import java.util.*;

import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePPerson extends ActionSupport
{
	private long id;

	private PersonService service;

	private Person person;

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

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	@Override
	public String execute() throws Exception
	{
		this.person = this.service.getPerson(id);

		return SUCCESS;
	}

}

