<%@ page import="java.util.*" %>
<%@ page import="com.tcs.ilp84.LMS.bean.AllocationBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Database</title>
<link href="resource/mystyle.css" rel="stylesheet" type="text/css">
<script language="javaScript" type="text/javascript"
	src="resource/validate.js">	
</script>
	<% 
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
</head>
<body background="resource/wrapper-bg.jpg">
<%
	ArrayList<String> names=(ArrayList<String>)request.getAttribute("names");
	
	String msg=(String)request.getAttribute("msg");
	if(msg!=null)
	{
		out.println("<center><h4>"+msg+"</h4></center>");
	}
%>

<form action="AllocationServlet" name="f1" id="myForm" method="post" onSubmit="return validate();">
<input type="hidden" name="page" value="create">
<center>
<div>
<h1 style="margin-bottom: 0;">
<center>Managing Leave Allocation</center>
<h4 align="right"><a href="login.jsp">Logout</a></h4>
</h1>
</div>
<table>
<tr bgcolor="#ffcc99" >
	<td><a href="ViewDetails.jsp">View Allocated Days</a></td>
	<td><a href="UpdateDetails.jsp">Update Days</a></td>
	<td><a href="ViewDetails2.jsp">View Leave Data</a></td>
</tr>
</table>

<table cellpadding="8">

	<% if(names!=null){%>
	<tr>
		<td>Employee Name: <font color="red">*</font></td>
		<td><select name="emp" id="name">
			<option value="0">--select--</option>
		<%for(int i=0;i<names.size();i++) {%>
			<option value="<%=names.get(i) %>"><%= names.get(i)%></option>
		<% }%>	
		</select>&nbsp;&nbsp;
		<input type="submit" name="submit" value="ViewDetails"></td>
		</tr>
		<tr>
		<td>Employee ID: <font color="red">*</font>:</td>
		<td><input type="text" name="id" maxlength="6" /></td>
	</tr>

	<tr>
		<td>Leave Type:</td>
		<td><input type="text" name="res"></td>
	</tr>
	<tr>
		<td>Designation:</td>
		<td><input type="text" name="dept"></td>
	</tr>
	<tr>
		<td>Days Entitled/Year:</td>
		<td><input type="text" name="days" /></td>
	</tr>
	<tr>
		<td>Comment:</td>
		<td><textarea rows="4" cols="40" name="comment"> 
					</textarea></td>
	</tr>
	<tr>
		<td style="text-align: right"><input type="submit" value="Submit">
		</td>
		<td><input type="reset" value=" reset "></td>
	</tr>
	<tr>
		<td><font color="red">* mandatory field</font></td>
	</tr>
		<%} %>
	
</table>
</form>
<form action="AllocationServlet" method="post" name="myForm2" onSubmit="return validate()">
<input type="hidden" name="page" value="create2"></input>
<table cellpadding="8">
	<tr>
	
	</tr>
	<% AllocationBean ab=(AllocationBean)request.getAttribute("data"); %>
	<%if(ab!=null){ %>
	<tr>
		<td>Employee Name: <font color="red">*</font>:</td>
		<td><input type="text" name="emp" value="<%=ab.getName()%>" /></td>
	</tr>
	<tr>
		<td>Employee ID: <font color="red">*</font>:</td>
		<td><input type="text" name="id" value="<%=ab.getId()%>" maxlength="6" /></td>
	</tr>

	<tr>
		<td>Leave Type:</td>
		<td><input type="text" name="res" value="<%=ab.getType() %>"></td>
	</tr>
	<tr>
		<td>Designation:</td>
		<td><input type="text" name="dept" value="<%=ab.getDept() %>"></td>
	</tr>
	<tr>
		<td>Days Entitled/Year:</td>
		<td><input type="text" name="days" /></td>
	</tr>
	<tr>
		<td>Comment:</td>
		<td><textarea rows="4" cols="40" name="comment"> 
					</textarea></td>
	</tr>
	<tr>
		<td style="text-align: right"><input type="submit" value="Submit">
		</td>
		<td><input type="reset" value=" reset "></td>
	</tr>
	<tr>
		<td><font color="red">* mandatory field</font></td>
	</tr>
	<%}%>
</table>
</form>
</center>

</body>
</html>
