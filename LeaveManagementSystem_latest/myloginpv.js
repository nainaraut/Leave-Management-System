function validateForm()
		{
		alert("hi");
	var username = document.getElementById('uname').value ;
	if ( "" == username)	
	{
		alert("Username cant be null !!");
		return false;
		//msg += "<br><label style='color:yellow;'><h2>First name must be filled out.</h2></label>";
	}
	
	if(isNaN(username)){
		//msg += "<br><label style='color:yellow;'><h2>Please enter letters only in First name.</h2></label>";
		alert("Please, Enter valid employee id !!");
		return false;
	
	}
	
return true;	
	
}