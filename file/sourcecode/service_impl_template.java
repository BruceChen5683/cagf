package @PACKAGE@;

import java.util.*;
import @IMPORTBEANS@;
import @IMPORTSERVICEINTERFACE@;
import @IMPORTDAO@;

public class @CLASSNAME@ServiceImpl implements @CLASSNAME@Service
{
	private @CLASSNAME@Dao @classname@Dao;

	private String list_all_desc = "from @CLASSNAME@ bean order by bean.id desc";

	private String list_all_asc = "from @CLASSNAME@ bean order by bean.id asc";

	public void set@CLASSNAME@Dao (@CLASSNAME@Dao @classname@Dao)
	{
		this.@classname@Dao = @classname@Dao;
	}

	public @CLASSNAME@Dao get@CLASSNAME@Dao()
	{
		return this.@classname@Dao;
	}

	public List<@CLASSNAME@> list@CLASSNAME@s(int start, int range)
	{
		return this.list@CLASSNAME@Desc(start, range);
	}

	public List<@CLASSNAME@> list@CLASSNAME@Desc(int start, int range)
	{
		return this.@classname@Dao.search@CLASSNAME@s(list_all_desc, new String[]{}, start, range);
	}

	public List<@CLASSNAME@> list@CLASSNAME@Asc(int start, int range)
	{
		return this.@classname@Dao.search@CLASSNAME@s(list_all_asc, new String[]{}, start, range);
	}

	public long get@CLASSNAME@Count()
	{
		return this.@classname@Dao.get@CLASSNAME@Count(list_all_desc);
	}

	public void save@CLASSNAME@ (@CLASSNAME@ bean)
	{
		this.@classname@Dao.save@CLASSNAME@(bean);
	}

	public void update@CLASSNAME@ (@CLASSNAME@ bean)
	{
		this.@classname@Dao.update@CLASSNAME@(bean);
	}

	public void delete@CLASSNAME@ (Long id)
	{
		this.@classname@Dao.remove@CLASSNAME@(id);
	}

	public @CLASSNAME@ get@CLASSNAME@ (Long id)
	{
		return this.@classname@Dao.get@CLASSNAME@(id);
	}

}
