package ml.battlecall.action.people;

import java.util.*;

import ml.battlecall.model.*;
import ml.battlecall.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePPeople extends ActionSupport
{
	private long id;

	private PeopleService service;

	private People people;

	public void setId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return this.id;
	}

	public void setService(PeopleService service)
	{
		this.service = service;
	}

	public PeopleService getService()
	{
		return this.service;
	}

	public People getPeople()
	{
		return this.people;
	}

	public void setPeople(People people)
	{
		this.people = people;
	}

	@Override
	public String execute() throws Exception
	{
		this.people = this.service.getPeople(id);

		return SUCCESS;
	}

}

