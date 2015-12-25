function validate()
	{
		var uname1 = document.myform.uname.value;
		if(uname1=="")   
		{   
		
		alert('UserName is employeeId');  
		document.myform.uname.focus(); 
		return false;
		   
		}   
		if(isNaN(uname1))
		{
			alert("Please enter the employeeId");
			document.myform.uname.value="";
			document.myform.uname.focus();
			return false;
		}
	/*	var pwd1 = document.myform.pwd.value;
		var pwd1_len = pwd1.length;
		if (pwd1 == "" )   
		{   
			alert("Password should not be empty / length be between 7 to 12");   
			document.myform.pwd.focus();   
			return false;   
		}   
	*/
	
	

	}