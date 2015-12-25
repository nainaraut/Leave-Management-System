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
					<h1 style="margin-bottom:0;"><center> View Current Leave Status</center></h1>
				</div>
				
		
			
	</center>
			
 <a href="Home.jsp">HOME</a>
	<a href="login.jsp">Logout</a>
	
	<%
	ArrayList<LmsBean> arrObj = new ArrayList<LmsBean>();
	String status = (String) request.getAttribute("status");
	if (status != null) {
		arrObj = (ArrayList<LmsBean>) request.getAttribute("data");
%>
<form name="form" action="MegawareServlet" method="post">
<table border="2" cellpadding="8">
	<tr>
		<td>First Name</td>
		<td>Last Type</td>
		<td>Employee Id</td>
		<td>Leave Type</td>
		<td>Current Leave Status</td>
		<td>Action</td>
		<%
		//boolean check=false;
		//check=(Boolean)request.getAttribute("check");
		//if(check)
		//{
			//out.println("Status Updated Successfully");
		//}
			
		
				for (LmsBean a : arrObj) {
				%>
				<form name="seedetail" action="MegawareServlet" method="post">
					<tr>
					<td>
					<%=a.getFirstname()%>
					</td>
					<td>
					<%=a.getLastname()%>
					</td>
					<td>
					<%=a.getEmployeeid()%>
					</td>
					<td>
					<%=a.getLeavetype()%>
					</td>
					
					<td>
					<%=a.getLeavestatus()%>
					</td>
					
					<td>
					
					<input type="hidden" name ="xcode" value="readstatus"><input type="hidden" name ="empid" value="<%= a.getEmployeeid()%>"><input type="submit" name ="View" Details value="More Detail" >
					</td>
					</tr>
				
			
				
					
					
					
					
					</form>
			<% 	}}
		%>
		
		
		
	
</table>
</form>
	
	
	
	
	</body>
</html>
				
 
 
 

