package @PACKAGE@;

import java.util.*;

import @IMPORTBEANS@;

public interface @CLASSNAME@Service
{
	public List<@CLASSNAME@> list@CLASSNAME@s (int start, int range);

	public List<@CLASSNAME@> list@CLASSNAME@Desc (int start, int range);

	public List<@CLASSNAME@> list@CLASSNAME@Asc (int start, int range);

	public long get@CLASSNAME@Count();

	public void save@CLASSNAME@ (@CLASSNAME@ bean);

	public void update@CLASSNAME@ (@CLASSNAME@ bean);

	public void delete@CLASSNAME@ (Long id);

	public @CLASSNAME@ get@CLASSNAME@ (Long id);
}
