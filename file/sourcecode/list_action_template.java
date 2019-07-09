package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionSupport;

public class List@CLASSNAME@ extends ActionSupport
{
	private List<@CLASSNAME@> list;

	private @CLASSNAME@Service service;

	public void setList(List<@CLASSNAME@> list)
	{
		this.list = list;
	}

	public List<@CLASSNAME@> getList()
	{
		return this.list;
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
		this.list = this.service.list@CLASSNAME@s(0, 10);

		return SUCCESS;
	}
}

