<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form name="submitInfo" method="post" action="updatePeople.action">

<table cellpadding="3" cellspacing="1" border="0" align="center" class="table" width="90%">

<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">username:</td><td bgcolor="#78A1E6"><input type="text" name="username" value="<s:property value='people.username'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">password:</td><td bgcolor="#78A1E6"><input type="text" name="password" value="<s:property value='people.password'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">telphone:</td><td bgcolor="#78A1E6"><input type="text" name="telphone" value="<s:property value='people.telphone'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">gender:</td><td bgcolor="#78A1E6"><input type="text" name="gender" value="<s:property value='people.gender'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">graduation:</td><td bgcolor="#78A1E6"><input type="text" name="graduation" value="<s:property value='people.graduation'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">birthday:</td><td bgcolor="#78A1E6"><input type="text" name="birthday" value="<s:property value='people.birthday'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">marryTime:</td><td bgcolor="#78A1E6"><input type="text" name="marryTime" value="<s:property value='people.marryTime'/>" size="40"/></td>
	<tr bgcolor="#f0f0f0"><td bgcolor="#78A1E6">file:</td><td bgcolor="#78A1E6"><input type="text" name="file" value="<s:property value='people.file'/>" size="40"/></td>
	

  <tr class="tr">
      <td>
        <input type="submit" value="submit">
      </td>
      <td>
        <input type="reset" value="reset">
      </td>
    </tr>

</table>

<input type="hidden" name="id" value="<s:property value='people.id' />">

</form>
