<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tcs.ilp84.LMS.bean.AllocationBean"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<% 
		String megawaresession=(String)session.getAttribute("megawaresession");
		String megawaresession2=(String)session.getAttribute("megawaresession2");
		System.out.println("session value="+megawaresession);
		if(megawaresession==null && megawaresession2==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);	
		}
		if(megawaresession2==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("AllocationLogin.jsp");
			rd.forward(request, response);	
		}
%>
--><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resource/mystyle.css">
<script language="javascript" src="resource/validate.js"
	type="text/javascript"></script>
</head>
<body>

<%
	ArrayList<AllocationBean> data=(ArrayList<AllocationBean>)request.getAttribute("ab1");
%>
<form action="AllocationServlet" method="post">
<input type="hidden" name="page" value="view2" ">
<center>
<table>
<tr bgcolor="#ffcc99" >
	<td><a href="ViewDetails.jsp">View Allocated Days</a></td>
	<td><a href="UpdateDetails.jsp">Update Days</a></td>
	<td><a href="ViewDetails2.jsp">View Leave Data</a></td>
</tr>
	<tr>
		<td width="35%">Employee ID<font color="red">*</font></td>
		<td><input type="text" name="id" maxlength="6" /></td>
		<td width="30%"></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="View" name="submit"></td>
	</tr>
</table>
</center>
<center>
<table cellpadding="5">
	<% if(data!=null){%>
	<tr bgcolor="#ffcc99" >
		<td width="10%">Name</td>
		<td width="10%">ID</td>
		<td width="10%">DESIGNATION</td>
		<td width="10%">TYPE</td>
		<td width="10%">DAYS</td>
	</tr>
	<hr/>
	
	<% for(AllocationBean ab:data)
	{ %>
	<tr>
		<td>
		<% out.println(ab.getName());%>
		</td>
		<td>
		<% out.println(ab.getId());%>
		</td>
		<td>
		<% out.println(ab.getDept());%>
		</td>
		<td>
		<% out.println(ab.getType());%>
		</td>
		<td>
		<% out.println(ab.getDays());%>
		</td>
	</tr>
	<%} %>
	<%} %>
	
</table>
</center>
</form>

</body>
</html>