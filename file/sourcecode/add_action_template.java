package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionSupport;

public class Add@CLASSNAME@ extends ActionSupport
{
	private @CLASSNAME@Service service;

@ADDBEAN@

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
@SETPROPERTY@

		return SUCCESS;
	}

}
