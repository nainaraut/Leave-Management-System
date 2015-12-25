<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="javascript" type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="mystyle.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Leave Request</title>
</head>
<body  background="resource/wrapper-bg.jpg">
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
out.print("<h3>"+msg+"</h3>");	
}
%>
<form action="ControllerServlet" method="post" onSubmit="return validate();">
<input type="hidden" name="page" value="update"></input>
<table width="100%">
	<tr id="row">
		<td width="20%" align="center"><a href="LeaveRequest.jsp">Apply
		Leave</a></td>
		<td width="20%" align="center"><a href="RequestView.jsp">View
		Leave</a></td>
		<td width="20%" align="center"><a href="RequestCancel.jsp">Cancel
		Leave</a></td>
	</tr>
</table>
<table align="center">
	<tr>
		<td width="35%">Employee ID<font color="red">*</font></td width="35%">
		<td><input type="text" name="empid" /></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%">Designation<font color="red">*</font></td width="35%">
		<td><select name="designation">
			<option value="">Select</option>
			<option value="ASE-TRAINEE">ASE-TRAINEE</option>
			<option value="ASE">ASE</option>
			<option value="System Engineer">System Engineer</option>
			<option value="Assistant Consultant">Assistant Consultant</option>
		</select></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%">Start Date(dd-mm-yyyy)<font color="red">*</font>
		</td width="35%">
		<td><input type="text" name="start" /></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%">End Date(dd-mm-yyyy)<font color="red">*</font></td width="35%">
		<td><input type="text" name="end" /></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%">Leave Type<font color="red">*</font></td width="35%">
		<td><select name="type">
			<option value="">Select</option>
			<option value="casual">Casual</option>
			<option value="sick">Sick</option>
			<option value="earned">Earned</option>
			<option value="maternity">Maternity</option>
		</select></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td>Reason<font color="red">*</font></td>
		<td><textarea rows="4" name="reason"></textarea></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%">Phone Number<font color="red">*</font></td width="35%">
		<td><input type="text" name="phonenumber" /></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td width="35%"><input type="submit" name="submit" value="Submit" /></td width="35%">
		<td><input type="reset" name="reset" value="Reset"
			onclick="clearMessage()" /></td>
		<td width="30%"></td>
	</tr>
</table>
</form>
</body>
</html>