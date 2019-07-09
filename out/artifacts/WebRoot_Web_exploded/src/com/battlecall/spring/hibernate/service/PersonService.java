package com.battlecall.spring.hibernate.service;

import java.util.*;

import com.battlecall.spring.hibernate.model.*;

public interface PersonService
{
	public List<Person> listPersons (int start, int range);

	public List<Person> listPersonDesc (int start, int range);

	public List<Person> listPersonAsc (int start, int range);

	public long getPersonCount();

	public void savePerson (Person bean);

	public void updatePerson (Person bean);

	public void deletePerson (Long id);

	public Person getPerson (Long id);
}
