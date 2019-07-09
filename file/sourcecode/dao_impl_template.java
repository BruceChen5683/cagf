package @PACKAGE@;

import java.util.*;
import @IMPORTBEANS@;
import @IMPORTDAOINTERFACE@;
import com.cagf.tool.util.*;

public class @CLASSNAME@DaoImpl extends BaseDao<@CLASSNAME@> implements @CLASSNAME@Dao
{
	//save
	public void save@CLASSNAME@ (@CLASSNAME@ bean)
	{
		storeObj(bean);
	}

	//saves
	public void save@CLASSNAME@s (List<@CLASSNAME@> beans)
	{
		storeObjs(beans);
	}

	//get
	public @CLASSNAME@ get@CLASSNAME@(Long id)
	{
		return retrieveObj(@CLASSNAME@.class, id);
	}

	//remove
	public void remove@CLASSNAME@ (Long id)
	{
		removeObj(@CLASSNAME@.class, id);
	}

	public void remove@CLASSNAME@ (@CLASSNAME@ bean)
	{
		remove@CLASSNAME@(bean.getId());
	}

	public void remove@CLASSNAME@s (List<Long> ids)
	{
		removeObjs(@CLASSNAME@.class ,ids);
	}

	public void update@CLASSNAME@ (@CLASSNAME@ bean)
	{
		updateObj(bean);
	}

	public void update@CLASSNAME@s(List<@CLASSNAME@> beans)
	{
		updateObjs(beans);
	}

	//get count
	public long get@CLASSNAME@Count(String queryString)
	{
		return retrieveObjsCount(queryString);
	}

	public long get@CLASSNAME@Count(String queryString, String value)
	{
		return retrieveObjsCount(queryString, value);
	}

	public long get@CLASSNAME@Count(String queryString, String[] value)
	{
		return retrieveObjsCount(queryString, value);
	}

	//search
	public List<@CLASSNAME@> search@CLASSNAME@s (String query)
	{
		return retrieveObjs(query);
	}

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String value)
	{
		return retrieveObjs(query, value);
	}

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String[] value)
	{
		return retrieveObjs(query, value);
	}

	public @CLASSNAME@ search@CLASSNAME@ (String query)
	{
		return retrieveObj(query);
	}
	
	public @CLASSNAME@ search@CLASSNAME@ (String query, String value)
	{
		return retrieveObj(query, value);
	}

	public @CLASSNAME@ search@CLASSNAME@ (String query, String[] value)
	{
		return retrieveObj(query, value);
	}

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String[] value, int start, int number)
	{
		return retrieveObjs(query, value, start, number);
	}
}
