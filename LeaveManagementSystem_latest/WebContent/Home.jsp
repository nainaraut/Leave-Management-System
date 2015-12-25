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
		<a href="login.jsp">Logout</a>
			<center>
				<div id="header" style="color:#592C0C;">
					<h1 style="margin-bottom:0;"><center> Managing Leave Approvals</center></h1>
				</div>
				
			<table cellpadding="8">
			<form action="MegawareServlet" name="myform" method="post" onSubmit="return validationform()">
				<br/>
				<tr><td><input type="hidden" name="xcode" value="create" /></td></tr>
				<tr>
					<td>Approve/Reject Leaves :</td> 
					<td>
						<input type="submit" name="submit" value="Click" />
					</td>
				</tr>
				
				</form>
				<form action="MegawareServlet" name="myform" method="post" onSubmit="return validationform()">
				<tr><td><input type="hidden" name="xcode" value="read" /></td></tr>
				<tr>
					<td>View Leave Status :</td> 
					<td>
						<input type="submit" name="submit" value="Click" />
					</td>
				</tr>
				
				
				</form>
				
				
				
				<form action="MegawareServlet" name="myform" method="post" onSubmit="return validationform()">
				
				<tr><td><input type="hidden" name="xcode" value="update" /></td></tr>
				<tr>
					<td>Update Leave Status :</td> 
					<td>
						<input type="submit" name="submit" value="Click" />
					</td>
				</tr>
				
			</form>
				
				<form action="MegawareServlet" name="myform" method="post" onSubmit="return validationform()">
				<tr><td><input type="hidden" name="xcode" value="delete" /></td></tr>	
				<tr>
					<td>Delete Leave Status :</td> 
					<td>
						<input type="submit" name="submit" value="Click" width="20"/>
					</td>
				</tr>
				
			</form>
		</table>
		</form>
	</center>
			
 

	</body>
</html>
				
 
 
 

