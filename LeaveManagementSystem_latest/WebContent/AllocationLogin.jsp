<html>
<head>
	<title>user_login</title>
<script language="javaScript" type="text/javascript" src="resource/login.js">	
</script>
<%

session.setAttribute("megawaresession2",null);
 //session.removeAttribute("mega")
 session.invalidate();
 %>	
</head>
	<body  background="resource/wrapper-bg.jpg">
	
<form name="myform" method="post" action="AllocationServlet" onSubmit="return validate()" >
<input type="hidden" name="page" value="login">


	<center><div id="header" style="background-color:#FFA500;font-color:#EED500;">
	<marquee><h2 style="margin-bottom:0;">Megaware Private limited</h2></marquee></div></center>

	<div style="height:200px;width:100px;float:left;">
	<img src="resourse/user.png">
	</div>

<div id="content" style="height:80%;width:40%;float:right;">
<table><br><br><br><br><br><br>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname" id="userid"></td>
			</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="pwd" id="pwdd"></td>
	</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="sub1" value="Login">	
			<button type="button">Cancel</button></td>
	</table>
</div>

 

<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright@Megaware.pvt.ltd</div>

</div>
		
</form>
</body>
	
</html>