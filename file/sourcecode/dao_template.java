package @PACKAGE@;

import java.util.*;
import @IMPORTBEANS@;

public interface @CLASSNAME@Dao
{
	public void save@CLASSNAME@ (@CLASSNAME@ bean);
	
	public void save@CLASSNAME@s (List<@CLASSNAME@> beans);

	public void update@CLASSNAME@ (@CLASSNAME@ bean);

	public void update@CLASSNAME@s (List<@CLASSNAME@> objs);

	public @CLASSNAME@ get@CLASSNAME@ (Long id);

	public void remove@CLASSNAME@ (Long id);

	public void remove@CLASSNAME@ (@CLASSNAME@ bean);
	
	public void remove@CLASSNAME@s (List<Long> ids);
	
	public long get@CLASSNAME@Count (String queryString);

	public long get@CLASSNAME@Count (String queryString, String value);

	public long get@CLASSNAME@Count (String queryString, String[] value);

	public List<@CLASSNAME@> search@CLASSNAME@s (String query);

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String value);

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String[] value);

	public @CLASSNAME@ search@CLASSNAME@ (String query);

	public @CLASSNAME@ search@CLASSNAME@ (String query, String value);

	public @CLASSNAME@ search@CLASSNAME@ (String query, String[] value);

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String value, int start, int number);

	public List<@CLASSNAME@> search@CLASSNAME@s (String query, String[] value, int start, int number);
}
