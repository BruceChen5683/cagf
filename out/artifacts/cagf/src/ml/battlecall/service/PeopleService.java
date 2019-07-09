package ml.battlecall.service;

import java.util.*;

import ml.battlecall.model.*;

public interface PeopleService
{
	public List<People> listPeoples (int start, int range);

	public List<People> listPeopleDesc (int start, int range);

	public List<People> listPeopleAsc (int start, int range);

	public long getPeopleCount();

	public void savePeople (People bean);

	public void updatePeople (People bean);

	public void deletePeople (Long id);

	public People getPeople (Long id);
}
