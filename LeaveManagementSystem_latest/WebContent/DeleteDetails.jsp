<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<title>MANAGING LEAVE ALLOCATION TOOL</title>
<link rel="stylesheet" type="text/css" href="resource/mystyle.css">
<script language="javascript" src="resource/validate.js"
	type="text/javascript"></script>
</head>

<body background="resource/wrapper-bg.jpg">

<table width="100%">
	<tr>
		<td align="center">
		<h3 style="color: BLACK; font-size: 30px">Managing Leave Allocation</h3>
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
		<h1 align="center" style="color: blue; font-size: 30px">Delete
		</h1>
		<hr />
		<font color="black"> Fields marked with <font color="red">*</font>
		are mandatory.</font></td>
	</tr>
	<tr>
		<td><br>
		</td>
	</tr>
<tr>
<td>
<%
	
	String msg=(String)request.getAttribute("msg");
	if(msg!=null)
	{
		out.println("<center><h4>"+msg+"</h4></center>");
	}
%>
</td>
</tr>
	
	<tr>
		<td>
		<form action="AllocationServlet" method="post" name="f1"
			onSubmit="return validate();"><input type="hidden" name="page"
			value="delete">
		<table width="70%" align="center">
			<tr>
				<td width="35%">Employee ID<font color="red">*</font></td>
				<td><input type="text" name="id" maxlength="6" /></td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td width="35%" colspan="2" align="center">
					<input type="submit" name="submit" value="Delete" />
					<input type="reset" name="reset" value="Reset" onclick="clearMessage()" /></td>
				<td width="30%"></td>
			</tr>
			</table>
			</form>
			</td>
			</tr>
			</table>
</body>
</html>