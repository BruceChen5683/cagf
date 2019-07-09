package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionSupport;

public class Delete@CLASSNAME@ extends ActionSupport
{
	private long id;

	private @CLASSNAME@Service service;

	public void setId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return this.id;
	}

	public void setService(@CLASSNAME@Service service)
	{
		this.service = service;
	}

	public @CLASSNAME@Service getService()
	{
		return this.service;
	}
	
	@Override
	public String execute() throws Exception
	{
		this.service.delete@CLASSNAME@(id);

		return SUCCESS;
	}
}
