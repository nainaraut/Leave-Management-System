<html>
	<head>
		<title>
	Managing Leave Approvals
		</title>
		
	<link href="resource/css/test1.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="resource/js/loginpv.js" language="JavaScript"></script>

 <%

session.setAttribute("megawaresession",null);
 //session.removeAttribute("mega")
 session.invalidate();
 %>
		
	</head>
	<body background="resource/image/wrapper-bg.jpg">
		
			
				<div id="header" style="color:#592C0C;">
					<h1 style="margin-bottom:0;"><center> HR Login</center></h1>
				</div>
				
			<table cellpadding="8">
			<form action="MegawareServlet" name="pvform" method="post" onSubmit="return validationform()">
				<br/>
				
				<tr>
				<td>UserName <font color="red">*</font>:</td>
				<td><input type="text" name="username" id="userid"/><label id="luid"> </label></td>
				</tr>
				
				<tr>
				<td>Password <font color="red">*</font>:</td>
				<td><input type="password" name="password" id="pwdd"  /><label id="lpwd"></td>
				</tr>
				
				<tr><td><input type="hidden" name="xcode" value="login" /></td></tr>
				<tr>
					<td><input type="reset" name="reset" value="reset" /></td> 
					<td>
						<input type="submit" name="submit" value="Login" />
					</td>
				</tr>
				
				</form>
				
						
		</table>
	
	</body>
</html>
				
 
 
 

