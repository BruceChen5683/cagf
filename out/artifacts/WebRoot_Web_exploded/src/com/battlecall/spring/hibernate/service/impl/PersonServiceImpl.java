package com.battlecall.spring.hibernate.service.impl;

import java.util.*;
import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.service.*;
import com.battlecall.spring.hibernate.dao.PersonDao;

public class PersonServiceImpl implements PersonService
{
	private PersonDao personDao;

	private String list_all_desc = "from Person bean order by bean.id desc";

	private String list_all_asc = "from Person bean order by bean.id asc";

	public void setPersonDao (PersonDao personDao)
	{
		this.personDao = personDao;
	}

	public PersonDao getPersonDao()
	{
		return this.personDao;
	}

	public List<Person> listPersons(int start, int range)
	{
		return this.listPersonDesc(start, range);
	}

	public List<Person> listPersonDesc(int start, int range)
	{
		return this.personDao.searchPersons(list_all_desc, new String[]{}, start, range);
	}

	public List<Person> listPersonAsc(int start, int range)
	{
		return this.personDao.searchPersons(list_all_asc, new String[]{}, start, range);
	}

	public long getPersonCount()
	{
		return this.personDao.getPersonCount(list_all_desc);
	}

	public void savePerson (Person bean)
	{
		this.personDao.savePerson(bean);
	}

	public void updatePerson (Person bean)
	{
		this.personDao.updatePerson(bean);
	}

	public void deletePerson (Long id)
	{
		this.personDao.removePerson(id);
	}

	public Person getPerson (Long id)
	{
		return this.personDao.getPerson(id);
	}

}
