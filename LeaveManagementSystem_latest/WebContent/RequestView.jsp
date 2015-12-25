<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="com.tcs.ilp84.LMS.bean.LmsBean;"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resource/mystyle.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Leave Request</title>
</head>
<body  background="resource/wrapper-bg.jpg">
<form action="ControllerServlet" method="post">
<input type="hidden" name="page" value="view"></input>
<%
			String msg=(String)request.getAttribute("msg");
			if (msg != null) {
				out.print("<h3>" + msg + "</h3>");
			}
%>
	<table width="100%">
	<tr id="row">
		<td width="20%" align="center"><a href="RequestView.jsp">Apply
		Leave</a></td>
		<td width="20%" align="center"><a href="RequestUpdate.jsp">Update
		Leave</a></td>
		<td width="20%" align="center"><a href="RequestCancel.jsp">Cancel
		Leave</a></td>
	</tr>
</table>
<table align="center">
	<tr>
		<td>Enter the Employee ID to view Leave Request</td>
		<td><input type="text" name="empid"></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="submit"></td>
	</tr>
</table>

	<%
	LmsBean lBean= new LmsBean();
	lBean = (LmsBean)request.getAttribute("lBean");
	if(lBean!=null)
	{
	
	lBean = (LmsBean) request.getAttribute("lBean");
	
	out.print("<h3>First Name : "+lBean.getFirstname()+"</h3>");
	out.print("<h3>Last Name : "+lBean.getLastname()+"</h3>");
	out.print("<h3>Designation : "+lBean.getDesignation()+"</h3>");
	out.print("<h3>Start Date : "+lBean.getStartdate()+"</h3>");
	out.print("<h3>End Date : "+lBean.getEnddate()+"</h3>");
	out.print("<h3>Leave Type : "+lBean.getLeavetype()+"</h3>");
	out.print("<h3>Reason : "+lBean.getReason()+"</h3>");
	out.print("<h3>Phone Number : "+lBean.getPhonenumber()+"</h3>");
	out.print("<h3>Status : "+lBean.getStatus()+"</h3>");
	out.print("<h3>Days Allocated : "+lBean.getDays_allocated()+"</h3>");
		
}%>
</form>
</body>
</html>