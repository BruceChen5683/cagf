package ml.battlecall.service.impl;

import java.util.*;
import ml.battlecall.model.*;
import ml.battlecall.service.*;
import ml.battlecall.dao.PeopleDao;

public class PeopleServiceImpl implements PeopleService
{
	private PeopleDao peopleDao;

	private String list_all_desc = "from People bean order by bean.id desc";

	private String list_all_asc = "from People bean order by bean.id asc";

	public void setPeopleDao (PeopleDao peopleDao)
	{
		this.peopleDao = peopleDao;
	}

	public PeopleDao getPeopleDao()
	{
		return this.peopleDao;
	}

	public List<People> listPeoples(int start, int range)
	{
		return this.listPeopleDesc(start, range);
	}

	public List<People> listPeopleDesc(int start, int range)
	{
		return this.peopleDao.searchPeoples(list_all_desc, new String[]{}, start, range);
	}

	public List<People> listPeopleAsc(int start, int range)
	{
		return this.peopleDao.searchPeoples(list_all_asc, new String[]{}, start, range);
	}

	public long getPeopleCount()
	{
		return this.peopleDao.getPeopleCount(list_all_desc);
	}

	public void savePeople (People bean)
	{
		this.peopleDao.savePeople(bean);
	}

	public void updatePeople (People bean)
	{
		this.peopleDao.updatePeople(bean);
	}

	public void deletePeople (Long id)
	{
		this.peopleDao.removePeople(id);
	}

	public People getPeople (Long id)
	{
		return this.peopleDao.getPeople(id);
	}

}
