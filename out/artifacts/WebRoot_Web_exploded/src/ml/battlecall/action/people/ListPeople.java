package ml.battlecall.action.people;

import java.util.*;

import ml.battlecall.model.*;
import ml.battlecall.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class ListPeople extends ActionSupport
{
	private List<People> list;

	private PeopleService service;

	public void setList(List<People> list)
	{
		this.list = list;
	}

	public List<People> getList()
	{
		return this.list;
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
		this.list = this.service.listPeoples(0, 10);

		return SUCCESS;
	}
}

