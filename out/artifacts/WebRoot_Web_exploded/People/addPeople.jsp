<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form name="submitInfo" method="post" action="addPeople.action">

<table cellpadding="3" cellspacing="1" border="0" align="center" class="table" width="90%">

<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">username:</td><td bgcolor="#78A1E6"><input name="username" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">password:</td><td bgcolor="#78A1E6"><input name="password" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">telphone:</td><td bgcolor="#78A1E6"><input name="telphone" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">gender:</td><td bgcolor="#78A1E6"><input name="gender" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">graduation:</td><td bgcolor="#78A1E6"><input name="graduation" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">birthday:</td><td bgcolor="#78A1E6"><input name="birthday" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">marryTime:</td><td bgcolor="#78A1E6"><input name="marryTime" type="text" size="40"></td>
</tr>
	<tr bgcolor="#f0f0f0">
	<td bgcolor="#78A1E6">file:</td><td bgcolor="#78A1E6"><input name="file" type="text" size="40"></td>
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

