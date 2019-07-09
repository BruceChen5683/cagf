package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionSupport;

public class Update@CLASSNAME@ extends ActionSupport
{
	private @CLASSNAME@Service service;

@UPDATEBEAN@
	
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
		@CLASSNAME@ bean = this.service.get@CLASSNAME@(id);

@UPDATEPROPERTY@

		this.service.update@CLASSNAME@ (bean);

		return SUCCESS;
		
	}

}


