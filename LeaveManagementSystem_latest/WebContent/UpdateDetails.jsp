<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tcs.ilp84.LMS.bean.AllocationBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANAGING LEAVE ALLOCATION TOOL</title>
<link rel="stylesheet" type="text/css" href="resource/mystyle.css">
<script language="javascript" src="resource/validate.js"
	type="text/javascript"></script>

<%AllocationBean ab=(AllocationBean)request.getAttribute("ab2"); %>

</head>
<body background="resource/wrapper-bg.jpg">
<table width="100%">
	<tr>
		<td align="center">
		<h3 style="color: BLACK; font-size: 30px">MANAGING LEAVE
		ALLOCATION TOOL</h3>
		</td>
	</tr>
</table>
<table>
<tr bgcolor="#ffcc99" >
	<td><a href="ViewDetails.jsp">View Allocated Days</a></td>
	<td><a href="AllocationPage.jsp">Allocate Days</a></td>
	<td><a href="ViewDetails2.jsp">View Leave Data</a></td>
	<td><a href="DeleteDetails.jsp">Delete Details</a></td>
</tr>
</table>
<table width="100%" cellpadding="8">
	<tr>
		<td width="100%">
		<h1 align="center" style="color: blue; font-size: 30px">View
		Details</h1>
		<hr />
		<font color="black"> Fields marked with <font color="red">*</font>
		are mandatory.</font></td>
	</tr>
	<tr>
		<td><br>
		</td>
	</tr>

	<tr id="row">
		<td align="center">Employee Information</td>
	</tr>
	<tr>
		<td>
		<form action="AllocationServlet" method="post" name="f1"
			onSubmit="return validate();"><input type="hidden" name="page"
			value="update">
		<table width="70%" align="center">
			<tr>
				<td width="35%">Employee ID<font color="red">*</font></td>
				<td><input type="text" name="id" maxlength="6" /></td>
				<td width="30%"></td>
			</tr>
				<tr>
				<td width="35%">Days Allocated</td>
				<td><input type="text" name="days"
					maxlength="6" /></td>
				<td width="30%"></td>
			</tr>
		</table>

		<table width="70%" align="center">
			<%if(ab!=null) {out.println("<hr/>");%>
			<tr>
				<td width="35%">Employee Name</td>
				<td><input type="text" name="emp" value="<%=ab.getName()%>"
					maxlength="6" disabled/></td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td width="35%">Employee Id</td>
				<td><input type="text" name="id1" value="<%=ab.getId()%>"
					maxlength="6" disabled/></td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td width="35%">Designation</td>
				<td><input type="text" name="des" value="<%=ab.getDept()%>"
					maxlength="6" disabled/></td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td width="35%">Leave Type</td>
				<td><input type="text" name="lt" value="<%=ab.getType()%>"
					maxlength="6" disabled/></td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td width="35%">Days Allocated</td>
				<td><input type="text" name="days1" value="<%=ab.getDays()%>"
					maxlength="6" /></td>
				<td width="30%"></td>
			</tr>
			<%} %>
		
			<tr>
				<td width="35%" colspan="2">
					<input type="submit" name="submit" value="Update" />
					<input type="reset" name="reset" value="Reset" onclick="clearMessage()" /></td>
				<td width="30%"></td>
			</tr>
		</table>

		</form>
		</td>
	</tr>
</table>

<hr>
<p align="center"><b></b></p>

</body>
</html>