<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

function del()
{
	if(confirm("Are you sure?"))
	{
		return true;
	}
	return false;
}

</script>

<table width="97%" align="center">
	<tr>
		<td>
			<input type="button" value="增加" 
			onclick="javascript:window.location.href='addPeople.jsp'">
		</td>

		<td>
			<table align="right">
			<tr>
				<td>
			

					

				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>



<table cellpadding="3" cellspacing="1" border="0" align="center"
	class="table" width="97%">

<tr class="tr">

<td align="center" bgcolor="#78A1E6" nowrap="nowrap">username</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">password</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">telphone</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">gender</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">graduation</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">birthday</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">marryTime</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">file</td>
	

<td width="" align="center" bgcolor="#78A1E6" nowrap="nowrap">
	Operation
</td>

</tr>

<s:iterator value="#request.list" id="u">

<tr class="tr">

<td align="center" bgcolor="#E6ECF9"><s:property value="#u.username"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.password"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.telphone"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.gender"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.graduation"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.birthday"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.marryTime"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.file"/></td>
	

<td align="center" bgcolor="#E6ECF9">
	<a href="updatePPeople.action?id=<s:property value='#u.id'/>&start=<s:property value='start'/>&range=<s:property value='range'/>">update</a>			
&nbsp;|&nbsp;
<a href="deletePeople.action?id=<s:property value='#u.id'/>&start=<s:property   value='start'/>&range=<s:property value='range'/>" onclick="return del();">delete</a>
</td>


</s:iterator>


</table>
    