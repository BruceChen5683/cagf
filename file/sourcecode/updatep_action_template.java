package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateP@CLASSNAME@ extends ActionSupport
{
	private long id;

	private @CLASSNAME@Service service;

	private @CLASSNAME@ @classname@;

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

	public @CLASSNAME@ get@CLASSNAME@()
	{
		return this.@classname@;
	}

	public void set@CLASSNAME@(@CLASSNAME@ @classname@)
	{
		this.@classname@ = @classname@;
	}

	@Override
	public String execute() throws Exception
	{
		this.@classname@ = this.service.get@CLASSNAME@(id);

		return SUCCESS;
	}

}

