<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form name="submitInfo" method="post" action="add@CLASSNAME@.action">

<table cellpadding="3" cellspacing="1" border="0" align="center" class="table" width="90%">

@ADD@


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

