<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form name="submitInfo" method="post" action="addPerson.action">

<table cellpadding="3" cellspacing="1" border="0" align="center" class="table" width="90%">

<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">name:</td><td bgcolor="#78A1E6"><input name="name" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">age:</td><td bgcolor="#78A1E6"><input name="age" type="text" size="40"></td>
</tr>
	


  <tr class="tr">
      <td>
        <input type="submit" value="submit">
      </td>
      <td>
        <input type="reset" value="reset">
      </td>
    </tr>

</table>

</form>

