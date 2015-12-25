function validate() 
{
	var a = document.getElementById("name");
	var c = a.options[a.selectedIndex].value;
	if(c==0)
	{
		alert("Please select the name");
		document.f1.emp.focus();
		return false;

	}
	
	if(d.equals("sick"))
	{
		if(e>30)
		{
			alert("Sick leaves can be maximum 30 days");
			document.f1.res.focus();
			return false;
		}
	}
	if(d.equals("Flexible"))
	{
		if(e>=2)
		{
			alert("Flexible leaves can be maximum 2 days");
			document.f1.res.focus();
			return false;
		}
	}
	if(d.equals("Casual"))
	{
		if(e>8)
		{
			alert("Casual leaves can be maximum 8 days");
			document.f1.res.focus();
			return false;
		}
	}
	if(d.equals("Earned"))
	{
		if(e>3)
		{
			alert("Earned leaves can be maximum 3 days");
			document.f1.res.focus();
			return false;
		}
	}
	if(d.equals("Maternity"))
	{
		if(e>100)
		{
			alert("Maternity leaves can be maximum of 100 days");
			document.f1.res.focus();
			return false;
		}
	}
	
	if(isNaN(e))
	{
		alert("Please enter the valid days or years");
		document.f1.days.value="";
		document.f1.days.focus();
		return false;
	}
	if(e=="")
	{
		alert("Please enter the days");
		document.f1.days.focus();
		return false;
	}
	if(e>200)
	{
		alert("Please enter the days");
		document.f1.days.focus();
		return false;
	}
	var f = document.f1.comments.value;
	if(f==0)
	{
		alert("Please enter your comments");
		document.f1.comments.focus();
		return false;
     }
	
}
	
	
	