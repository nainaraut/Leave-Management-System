<html>
<head>
<title>sample webpage</title>
<link href="resource/mystyle.css" rel="stylesheet" type="text/css">
<script src="resource/test2.js" language="JavaScript"
	type="text/javascript"></script>


</head>
<body class="mainbody">
<table border="0" align=center width="80%">
	<tr>
		<td colspan="2"><img src="resource/3.jpg" width="100%"
			height="200px" /></td>
	</tr>
	<tr>
		<th colspan="2" background="resource/wrapper-bg.jpg">
		<h3>LEAVE MANAGMENT SYSTEM</h3>
		</th>
		<tr>
			<td colspan="2">
			<div class="navbar"><a class="navbartitle" id="t1"
				href="a.html" onMouseOut="HideItem('home_submenu');"
				onMouseOver="ShowItem('home_submenu');"> Home </a> <a
				class="navbartitle" id="t2" href=""
				onMouseOut="HideItem('Emp_submenu');"
				onMouseOver="ShowItem('Emp_submenu');">Employee Management </a> <a
				class="navbartitle" id="t3" href=""
				onMouseOut="HideItem('Leave_submenu');"
				onMouseOver="ShowItem('Leave_submenu');">Leave Management</a>
			<a class="navbartitle" id="t3" href=""
				onMouseOut="HideItem('gdm_submenu');"
				onMouseOver="ShowItem('gdm_submenu');">Global Data
			Management</a> <!-- Home sub-menu, shown as needed  -->
			<div class="submenu" id="home_submenu"
				onMouseOver="ShowItem('home_submenu');"
				onMouseOut="HideItem('home_submenu');">
			<div class="submenubox">
			<ul>
				<li><a href="Megawareinfo.html " class="submenlink"
					target="myframe">Introduction</a></li>
				<li><a href="AboutUs.html" class="submenlink" target="myframe">About
				Us</a></li>
				<li><a href="AboutUs.html" class="submenlink" target="myframe">Purpose</a></li>
				<li><a href="" class="submenlink">Help</a></li>
			</ul>
			</div>
			</div>

			<!-- Emp sub-menu, shown as needed  -->
			<div class="submenu" id="Emp_submenu"
				onMouseOver="ShowItem('Emp_submenu');"
				onMouseOut="HideItem('Emp_submenu');">
			<div class="submenubox">
			<ul>
				<li><a href="" class="submenlink">Employee Details</a></li>
				<li><a href="" class="submenlink">Role Details</a></li>
				<li><a href="" class="submenlink">Timesheet Details</a></li>

			</ul>
			</div>
			</div>


			<!-- Leave sub-menu, shown as needed  -->
			<div class="submenu" id="Leave_submenu"
				onMouseOver="ShowItem('Leave_submenu');"
				onMouseOut="HideItem('Leave_submenu');">
			<div class="submenubox">
			<ul>
				<li><a href="LeaveRequest.jsp" class="submenlink" target="myframe">Leave Request</a></li>
				<li><a href="login.jsp" class="submenlink" target="myframe">Leave Approval</a></li>
				<li><a href="AllocationLogin.jsp" class="submenlink"
					target="myframe">Leave Allocation</a></li>

			</ul>
			</div>
			</div>

			<!-- gdm sub-menu, shown as needed  -->
			<div class="submenu" id="gdm_submenu"
				onMouseOver="ShowItem('gdm_submenu');"
				onMouseOut="HideItem('gdm_submenu')";;
>
			<div class="submenubox">
			<ul>
				<li><a href="mangholiday.jsp" class="submenlink"
					target="myframe">Holiday Details</a></li>
				<li><a href="Mangleave.jsp" class="submenlink" target="myframe">Leave
				Details</a></li>
				<li><a href="gdm.jsp" class="submenlink" target="myframe">System
				Global Parameters</a></li>

			</ul>
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan="2"><iframe height="575" width="1060"
				src="Megawareinfo.jsp" name="myframe"></iframe></td>

		</tr>
		<tr>
			<td colspan=2 align="center">
			<div id="footer" style="color: #FFFFFF; background-color: #8B7355;">
			<h3 style="margin-bottom: 0;">
			<center>for more detail log on on to www.mWare.com<br>
			copyright@Megaware</center>
			</h3>
			</div>
			</td>
		</tr>
</table>


</body>
</html>



