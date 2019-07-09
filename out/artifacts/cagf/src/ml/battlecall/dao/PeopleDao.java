package ml.battlecall.dao;

import java.util.*;
import ml.battlecall.model.*;

public interface PeopleDao
{
	public void savePeople (People bean);
	
	public void savePeoples (List<People> beans);

	public void updatePeople (People bean);

	public void updatePeoples (List<People> objs);

	public People getPeople (Long id);

	public void removePeople (Long id);

	public void removePeople (People bean);
	
	public void removePeoples (List<Long> ids);
	
	public long getPeopleCount (String queryString);

	public long getPeopleCount (String queryString, String value);

	public long getPeopleCount (String queryString, String[] value);

	public List<People> searchPeoples (String query);

	public List<People> searchPeoples (String query, String value);

	public List<People> searchPeoples (String query, String[] value);

	public People searchPeople (String query);

	public People searchPeople (String query, String value);

	public People searchPeople (String query, String[] value);

	public List<People> searchPeoples (String query, String value, int start, int number);

	public List<People> searchPeoples (String query, String[] value, int start, int number);
}
