package com.battlecall.spring.hibernate.impl;

import java.util.*;
import com.battlecall.spring.hibernate.model.*;
import com.battlecall.spring.hibernate.dao.*;
import com.cagf.tool.util.*;

public class PersonDaoImpl extends BaseDao<Person> implements PersonDao
{
	//save
	public void savePerson (Person bean)
	{
		storeObj(bean);
	}

	//saves
	public void savePersons (List<Person> beans)
	{
		storeObjs(beans);
	}

	//get
	public Person getPerson(Long id)
	{
		return retrieveObj(Person.class, id);
	}

	//remove
	public void removePerson (Long id)
	{
		removeObj(Person.class, id);
	}

	public void removePerson (Person bean)
	{
		removePerson(bean.getId());
	}

	public void removePersons (List<Long> ids)
	{
		removeObjs(Person.class ,ids);
	}

	public void updatePerson (Person bean)
	{
		updateObj(bean);
	}

	public void updatePersons(List<Person> beans)
	{
		updateObjs(beans);
	}

	//get count
	public long getPersonCount(String queryString)
	{
		return retrieveObjsCount(queryString);
	}

	public long getPersonCount(String queryString, String value)
	{
		return retrieveObjsCount(queryString, value);
	}

	public long getPersonCount(String queryString, String[] value)
	{
		return retrieveObjsCount(queryString, value);
	}

	//search
	public List<Person> searchPersons (String query)
	{
		return retrieveObjs(query);
	}

	public List<Person> searchPersons (String query, String value)
	{
		return retrieveObjs(query, value);
	}

	public List<Person> searchPersons (String query, String[] value)
	{
		return retrieveObjs(query, value);
	}

	public Person searchPerson (String query)
	{
		return retrieveObj(query);
	}
	
	public Person searchPerson (String query, String value)
	{
		return retrieveObj(query, value);
	}

	public Person searchPerson (String query, String[] value)
	{
		return retrieveObj(query, value);
	}

	public List<Person> searchPersons (String query, String value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}

	public List<Person> searchPersons (String query, String[] value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}
}
