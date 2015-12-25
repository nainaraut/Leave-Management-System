<%@ page import="com.tcs.ilp84.LMS.bean.LmsBean"%>
<%@ page import="java.util.ArrayList"%>

<html>
	<head>
		<title>
	Managing Leave Approvals
		</title>
		
	<link href="resource/css/test1.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="resourse/js/mangleave.js" language="JavaScript"></script>
<script type="text/javascript" src="resourse/js/calendar.js" language="JavaScript">

	</script>
 
		<% 
		String megawaresession=(String)session.getAttribute("megawaresession");
		if(megawaresession==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

			
		}
		
		%>
	</head>
	<body background="resource/image/wrapper-bg.jpg">
		
			<center>
				<div id="header" style="color:#592C0C;">
					<h1 style="margin-bottom:0;"><center> Update Leave Status</center></h1>
				</div>
				
			<table cellpadding="8">
			
	</center>
			
 <a href="Home.jsp">HOME</a>
 <a href="login.jsp">Logout</a>
	</form>
	
	<%
	
	String status = (String) request.getAttribute("status");
	if (status != null) {
		LmsBean a=new LmsBean();
		a=(LmsBean)request.getAttribute("bean");
		out.println("employee id of errror page update status detail="+a.getEmployeeid());
%>
	<form name="details" action="MegawareServlet" method="post">
	<table border="2" align="center">
    <tr>
	<td>First Name</td>
	<td>
	<%=a.getFirstname()%>
	</td>
	</tr>
	
	<tr>
	<td>Last Name</td>
	<td>
	<%=a.getLastname()%>
	</td>
	</tr>
	
	<tr>
	<td>Employee Id</td>
	<td>
	<%=a.getEmployeeid()%>
	</td>
	</tr>
	
	<tr>
	<td>Designation</td>
	<td>
	<%=a.getDesignation()%>
	</td>
	</tr>
	
	<tr>
	<td>Start Date</td>
	<td>
	<%=a.getStartdate()%>
	</td>
	</tr>
	
	<tr>
	<td>End Date</td>
	<td>
	<%=a.getEnddate()%>
	</td>
	</tr>
	
	<tr>
	<td>Leave Type</td>
	<td>
	<%=a.getLeavetype()%>
	</td>
	</tr>
	
	<tr>
	<td>Reason</td>
	<td>
	<%=a.getReason()%>
	</td>
	</tr>
	
	<tr>
	<td>Phone</td>
	<td>
	<%=a.getPhonenumber()%>
	</td>
	</tr>
	<input type="hidden" name="eid" value="<%= a.getEmployeeid()%>">
	<% if((a.getLeavestatus()).equals("Approved"))
	{
		%>
	<tr>
	<td colspan="3" align="center"> <input type="radio" name="status" value="Approved" checked>Approved</input>
	<input type="radio" name="status" value="Rejected">Rejected</input>
	<%}
	
	if((a.getLeavestatus()).equals("Rejected"))
	{
		%>
	<tr>
	<td colspan=3 align=center> <input type=radio name=status value=Approved >Approved</input>
	<input type=radio name=status value=Rejected checked>Rejected</input>
	<%}
	%>
	</td></tr>

	<input type="hidden" name="xcode" value="setupdatedstatus">
	
	<input type="hidden" name="eid" value="<%= a.getEmployeeid()%>">
	<tr>
			<%	}%>
	<td colspan="3" align="center"><input type="submit" name="Done" value="Update Status">  </td></tr>
		
		
		
		
	</form>
</table>

	
	
	
	
	</body>
</html>
				
 