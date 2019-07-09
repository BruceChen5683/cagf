package ml.battlecall.action.people;

import java.util.*;

import ml.battlecall.model.*;
import ml.battlecall.service.*;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePeople extends ActionSupport
{
	private PeopleService service;

	private long id;

	private String username;

	private String password;

	private int telphone;

	private Character gender;

	private boolean graduation;

	private Date birthday;

	private Date marryTime;

	private byte[] file;


	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getTelphone()
	{
		return telphone;
	}
	public void setTelphone(int telphone)
	{
		this.telphone = telphone;
	}
	public Character getGender()
	{
		return gender;
	}
	public void setGender(Character gender)
	{
		this.gender = gender;
	}
	public boolean getGraduation()
	{
		return graduation;
	}
	public void setGraduation(boolean graduation)
	{
		this.graduation = graduation;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public Date getMarryTime()
	{
		return marryTime;
	}
	public void setMarryTime(Date marryTime)
	{
		this.marryTime = marryTime;
	}
	public byte[] getFile()
	{
		return file;
	}
	public void setFile(byte[] file)
	{
		this.file = file;
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
		People bean = this.service.getPeople(id);

		bean.setId(id);
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setTelphone(telphone);
		bean.setGender(gender);
		bean.setGraduation(graduation);
		bean.setBirthday(birthday);
		bean.setMarryTime(marryTime);
		bean.setFile(file);
		

		this.service.updatePeople (bean);

		return SUCCESS;
		
	}

}


