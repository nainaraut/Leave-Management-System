<html>
<head>
	<title>user_login</title>
<script language="javaScript" type="text/javascript" src="resource/login.js">	
</script>	
</head>
	<body  background="resource/wrapper-bg.jpg">
	
<form name="myform" method="post" action="AllocationServlet" onSubmit="return validate()" >
<input type="hidden" name="page" value="login">


	<center><div id="header" style="background-color:#FFA500;font-color:#EED500;">
	<marquee><h2 style="margin-bottom:0;">Megaware Private limited</h2></marquee></div></center>

	<div style="height:200px;width:100px;float:left;">
	<img src="resourse/image/user.png">
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
		

	</body>
	
</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>