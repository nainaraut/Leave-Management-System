function validate() 
{
	clearMessage();
	var msg = "";
	var firstName = document.form.first.value;
	var lastName = document.form.last.value;
	if (firstName=="")	
	{
		msg += "<br><label style='color:red;'>First name must be filled.</label>";
	}
	else if(! firstName.match(/^[A-Za-z ]+$/))
	{
		msg += "<br><label style='color:red;'>Please enter only letters in First name.</label>";
	}
	if ( lastName=="")	
	{
		msg += "<br><label style='color:red;'>Last name must be filled.</label>";
	}
	else if(! lastName.match(/^[A-Za-z ]+$/))
	{
		msg += "<br><label style='color:red;'>Please enter only letters in Last name.</label>";
	}
	var emp = document.form.empid.value;
	if ( emp== "")	
	{
		msg += "<br><label style='color:red;'>Employee ID must be filled.</label>";
	}
	else if(emp.length!=6)
	{
		msg += "<br><label style='color:red;'>Please enter the valid Employee ID.</label>";
	}
	else if(! emp.match(/^[0-9 ]+$/))
	{
		msg += "<br><label style='color:red;'>Please enter the valid Employee ID.</label>";
	}
	var designation = document.form.designation.selectedIndex;
	if( null == designation || "" == designation || designation < 0 || designation > 4 ){
		msg += "<br><label style='color:red;'>Please select type of designation.</label>";
	}
	var startDate = document.form.start.value;
	if( startDate=="" || ! startDate.match(/^\d{2}-\d{2}-\d{4}$/) || ! checkDate(startDate))
	{
		msg += "<br><label style='color:red;'>Please enter valid Start date (dd-mm-yyyy).</label>";
	}
	var endDate = document.form.end.value;
	if( endDate=="" || ! endDate.match(/^\d{2}-\d{2}-\d{4}$/) || ! checkDate(endDate))
	{
		msg += "<br><label style='color:red;'>Please enter valid End date (dd-mm-yyyy).</label>";
	}
	if( startDate != "" && endDate != "" && startDate==endDate && startDate > endDate)
	{
		msg += "<br><label style='color:red;'>StartDate and EndDate should be different.</label>";
	}
	var leave = document.form.type.selectedIndex;
	if( null == leave || "" == leave || leave < 0 || leave > 4 ){
		msg += "<br><label style='color:red;'>Please select type of leave.</label>";
	}
	var reason = document.form.reason.value;
	if (reason=="")	
	{
		msg += "<br><label style='color:red;'>Reason must be filled.</label>";
	}
	var phoneNumber = document.form.phonenumber.value;
	if (phoneNumber=="")	
	{
		msg += "<br><label style='color:red;'>Phone number must be filled.</label>";
	}
	else if(phoneNumber.length!=10)
	{
		msg += "<br><label style='color:red;'>Please enter the valid phone number</label>";
	}
	else if(! phoneNumber.match(/^[0-9 ]+$/))
	{
		msg += "<br><label style='color:red;'>Please enter the valid phone number</label>";
	}
	if(msg.length > 0)
	{
		document.getElementById('msg').innerHTML = msg;
		return false;
	}
	else
	{
		return true;
	}
	
}


function checkDate(stringDate)
{
	var day = stringDate.substring(0,2);
	var month = stringDate.substring(3,5);
	var year = stringDate.substring(6);
	if (month > 12 || day >31) 
	{
		return false;
	}
	else if (month == 2) 
	{
        if (day == 29) 
		{
            if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0)
			{
                return false;
            }
        }
		else if (day > 28) 
		{
        	return false;
        }
    }
	else if (month == 4 || month == 6 || month  == 9 || month == 11) 
	{
        if (day > 30)
		{
        	return false;
        }
    }
	else if (day > 31) 
	{
        	return false;
    }
	
	return true;
}
    
function clearMessage() 
{
	document.getElementById('msg').innerHTML = "";
}
