<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form name="submitInfo" method="post" action="updatePerson.action">

<table cellpadding="3" cellspacing="1" border="0" align="center" class="table" width="90%">

<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">name:</td><td bgcolor="#78A1E6"><input type="text" name="name" value="<s:property value='person.name'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">age:</td><td bgcolor="#78A1E6"><input type="text" name="age" value="<s:property value='person.age'/>" size="40"/></td>
	

  <tr class="tr">
      <td>
        <input type="submit" value="submit">
      </td>
      <td>
        <input type="reset" value="reset">
      </td>
    </tr>

</table>

<input type="hidden" name="id" value="<s:property value='person.id' />">

</form>
