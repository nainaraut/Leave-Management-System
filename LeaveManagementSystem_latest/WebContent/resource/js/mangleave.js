function validationform()
{
		
	   var userid=document.forms["myform"]["lt"].value;
	   var pwdd=document.forms["myform"]["maxd"].value;
	
	if (userid==null || userid==""|| pwdd==null || pwdd=="" )
	{
		alert("Mandatory field is missing");
		return false;
	}
	if(isNaN(pwdd))
	{
	alert("only numeric value allowed");
	return false;
	}
	}
      function fun1()
	{
	document.forms["myform"]["lt"].disabled=false;
	document.forms["myform"]["maxd"].disabled=false;
	}
	function fun2()
	{
	document.forms["myform"]["lt"].disabled=true;
	document.forms["myform"]["maxd"].disabled=true;
	}
 