package ml.battlecall.action.people;

import java.util.*;

import ml.battlecall.model.*;
import ml.battlecall.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePeople extends ActionSupport
{
	private long id;

	private PeopleService service;

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
	
	@Override
	public String execute() throws Exception
	{
		this.service.deletePeople(id);

		return SUCCESS;
	}
}
