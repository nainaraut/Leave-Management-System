<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Leave Request</title>
</head>
<body  background="resource/wrapper-bg.jpg">
<form action="ControllerServlet" method="post">
<input type="hidden" name="page" value="cancel"></input> 
	<%
 	String msg = (String) request.getAttribute("msg");
 	if (msg != null) {
 		out.print("<h3>" + msg + "</h3>");
 	}
 %>
<table width="100%">
	<tr id="row">
		<td width="20%" align="center"><a href="LeaveRequest.jsp">Apply Leave</a></td>
		<td width="20%" align="center"><a href="RequestView.jsp">View Leave</a></td>
		<td width="20%" align="center"><a href="RequestUpdate.jsp">Update
		Leave</a></td>
	</tr>
</table>
<table align="center">
	<tr>
		<td>Enter Your Employee ID to Cancel Leave</td>
		<td><input type="text" name="empid"></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="submit"></td>
	</tr>
</table>
<input type="hidden" value="cancel" name="cmd"></input></form>
</body>
</html>