<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<script language="javascript" type="text/javascript" src="resource/RequestValidate.js"></script>
<link rel="stylesheet" type="text/css" href="resource/mystyle.css"></link>
<title>LEAVE REQUEST MANAGEMENT TOOL</title>
</head>
<body background="resource/wrapper-bg.jpg">
<table width="100%">
	<tr>
		<td align="center">
		<h3 style="color: BLACK; font-size: 30px">LEAVE REQUEST
		MANAGEMENT TOOL</h3>
		</td>
	</tr>
</table>
<table width="100%">
	<tr id="row">
		<td width="20%" align="center"><a href="RequestView.jsp">View Leave</a></td>
		<td width="20%" align="center"><a href="RequestUpdate.jsp">Update Leave</a></td>
		<td width="20%" align="center"><a href="RequestCancel.jsp">Cancel Leave</a></td>
	</tr>
</table>
<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
				out.print("<h3>" + msg + "</h3>");
			}
%>
<table width="100%">
	<tr>
		<td width="50%">
		<h1 align="center" style="color: blue; font-size: 30px">Leave
		Request Form</h1>
		<font color="black"> Fields marked with <font color="red">*</font>
		are mandatory.</font></td>
	</tr>
	<tr>
		<td><br>
		</td>
	</tr>
	<tr id="row">
		<td align="center">Employee Information</td>
	</tr>
	<tr>
		<td>
		<form action="ControllerServlet" name="form" method="post"
			onSubmit="return validate();">
			<input type="hidden" name="page" value="create"></input>
		<table width="70%" align="center">
			<tr>
				<td width="35%">First Name<font color="red">*</font></td>
				<td width="35%"><input type="text" name="first" /></td>
				<td rowspan="10" width="30%" style="vertical-align: top"><span
					id="msg" name="msg"> </span></td>
			</tr>
			<tr>
				<tr>
					<td width="35%">Last Name<font color="red">*</font></td width="35%">
					<td><input type="text" name="last" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">Employee ID<font color="red">*</font></td width="35%">
					<td><input type="text" name="empid" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">Designation<font color="red">*</font></td width="35%">
					<td><select name="designation">
						<option value="">Select</option>
						<option value="ASE-TRAINEE">ASE-TRAINEE</option>
						<option value="ASE">ASE</option>
						<option value="System Engineer">System Engineer</option>
						<option value="Assistant Consultant">Assistant Consultant</option>
					</select></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">Start Date(dd-mm-yyyy)<font color="red">*</font>
					</td width="35%">
					<td><input type="text" name="start" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">End Date(dd-mm-yyyy)<font color="red">*</font>
					</td width="35%">
					<td><input type="text" name="end" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">Leave Type<font color="red">*</font></td width="35%">
					<td><select name="type">
						<option value="">Select</option>
						<option value="casual">Casual</option>
						<option value="sick">Sick</option>
						<option value="earned">Earned</option>
						<option value="maternity">Maternity</option>
					</select></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td>Reason<font color="red">*</font></td>
					<td><textarea rows="4" name="reason"></textarea></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%">Phone Number<font color="red">*</font></td width="35%">
					<td><input type="text" name="phonenumber" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td width="35%"><input type="submit" name="submit"
						value="Submit" /></td width="35%">
					<td><input type="reset" name="reset" value="Reset"
						onclick="clearMessage()" /></td>
					<td width="30%"></td>
				</tr>
		</table>
		</form>

		</td>
	</tr>
</table>
<hr>
<p align="center"><b> Copyright &copy LRMS </b></p>

</body>
</html>