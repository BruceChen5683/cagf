package com.battlecall.spring.hibernate.dao;

import java.util.*;
import com.battlecall.spring.hibernate.model.*;

public interface PersonDao
{
	public void savePerson (Person bean);
	
	public void savePersons (List<Person> beans);

	public void updatePerson (Person bean);

	public void updatePersons (List<Person> objs);

	public Person getPerson (Long id);

	public void removePerson (Long id);

	public void removePerson (Person bean);
	
	public void removePersons (List<Long> ids);
	
	public long getPersonCount (String queryString);

	public long getPersonCount (String queryString, String value);

	public long getPersonCount (String queryString, String[] value);

	public List<Person> searchPersons (String query);

	public List<Person> searchPersons (String query, String value);

	public List<Person> searchPersons (String query, String[] value);

	public Person searchPerson (String query);

	public Person searchPerson (String query, String value);

	public Person searchPerson (String query, String[] value);

	public List<Person> searchPersons (String query, String value, int start, int number);

	public List<Person> searchPersons (String query, String[] value, int start, int number);
}
