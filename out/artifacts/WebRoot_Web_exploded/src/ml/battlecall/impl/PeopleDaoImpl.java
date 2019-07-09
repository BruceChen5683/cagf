package ml.battlecall.impl;

import java.util.*;
import ml.battlecall.model.*;
import ml.battlecall.dao.*;
import com.cagf.tool.util.*;

public class PeopleDaoImpl extends BaseDao<People> implements PeopleDao
{
	//save
	public void savePeople (People bean)
	{
		storeObj(bean);
	}

	//saves
	public void savePeoples (List<People> beans)
	{
		storeObjs(beans);
	}

	//get
	public People getPeople(Long id)
	{
		return retrieveObj(People.class, id);
	}

	//remove
	public void removePeople (Long id)
	{
		removeObj(People.class, id);
	}

	public void removePeople (People bean)
	{
		removePeople(bean.getId());
	}

	public void removePeoples (List<Long> ids)
	{
		removeObjs(People.class ,ids);
	}

	public void updatePeople (People bean)
	{
		updateObj(bean);
	}

	public void updatePeoples(List<People> beans)
	{
		updateObjs(beans);
	}

	//get count
	public long getPeopleCount(String queryString)
	{
		return retrieveObjsCount(queryString);
	}

	public long getPeopleCount(String queryString, String value)
	{
		return retrieveObjsCount(queryString, value);
	}

	public long getPeopleCount(String queryString, String[] value)
	{
		return retrieveObjsCount(queryString, value);
	}

	//search
	public List<People> searchPeoples (String query)
	{
		return retrieveObjs(query);
	}

	public List<People> searchPeoples (String query, String value)
	{
		return retrieveObjs(query, value);
	}

	public List<People> searchPeoples (String query, String[] value)
	{
		return retrieveObjs(query, value);
	}

	public People searchPeople (String query)
	{
		return retrieveObj(query);
	}
	
	public People searchPeople (String query, String value)
	{
		return retrieveObj(query, value);
	}

	public People searchPeople (String query, String[] value)
	{
		return retrieveObj(query, value);
	}

	public List<People> searchPeoples (String query, String value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}

	public List<People> searchPeoples (String query, String[] value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}
}
