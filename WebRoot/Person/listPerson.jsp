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
			onclick="javascript:window.location.href='addPerson.jsp'">
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

<td align="center" bgcolor="#78A1E6" nowrap="nowrap">name</td>
	<td align="center" bgcolor="#78A1E6" nowrap="nowrap">age</td>
	

<td width="" align="center" bgcolor="#78A1E6" nowrap="nowrap">
	Operation
</td>

</tr>

<s:iterator value="#request.list" id="u">

<tr class="tr">

<td align="center" bgcolor="#E6ECF9"><s:property value="#u.name"/></td>
	<td align="center" bgcolor="#E6ECF9"><s:property value="#u.age"/></td>
	

<td align="center" bgcolor="#E6ECF9">
	<a href="updatePPerson.action?id=<s:property value='#u.id'/>&start=<s:property value='start'/>&range=<s:property value='range'/>">update</a>			
&nbsp;|&nbsp;
<a href="deletePerson.action?id=<s:property value='#u.id'/>&start=<s:property   value='start'/>&range=<s:property value='range'/>" onclick="return del();">delete</a>
</td>


</s:iterator>


</table>
    