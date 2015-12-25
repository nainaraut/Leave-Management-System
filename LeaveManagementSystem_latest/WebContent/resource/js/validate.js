function validate()
 {
	
	// Validation for parameter name
	if(  (document.getElementById('pname').value) =='' ||  trim(document.getElementById('pname').value) == "" )
		{ 
		 alert("Please fill the parameter name!");
		
		document.getElementById('pname').focus();
		return false;
		} 
	if( !(document.getElementById('pname').value.match(/^[A-Za-z ]+$/)))
		{
		alert("Enter only characters");
		return false;
	    }
		//dropdown validation
		if( document.getElementById('ptype').value =='00')
		{ 
		 alert("Please select parameter type!");
		 document.getElementById('ptype').focus();
		 return false;
		} 
		//value validation
	if(document.getElementById('value1').value =='' ||  trim(document.getElementById('value1').value) == "")
		{ 
		 alert("Please fill the value!");
		 document.getElementById('value1').focus();
		 return false;
		} 
	//radio button validation	

	
if(  !document.getElementById('admin').checked && !document.getElementById('hr').checked && !document.getElementById('technical').checked && !document.getElementById('bskills').checked)
		{ 
		 alert("Please select department!");
		
		return false;
		} 
		//date validation
		if(document.getElementById('SelectedDate').value =='' )
		{ 
		 alert("Please fill the date!");
		 document.getElementById('SelectedDate').focus();
		 return false;
		} 
		//dropdown validation
		if( document.getElementById('modifiedBy').value =='a')
		{ 
		 alert("Please select modified by!");
		 document.getElementById('modifiedBy').focus();
		 return false;
		} 
		if(  !document.getElementById('alert1').checked && !document.getElementById('alert2').checked && !document.getElementById('alert3').checked && !document.getElementById('alert4').checked)
		{ 
		 alert("Please select alert type!");
		
		return false;
		} 
 
 }

function check()
{
	var a=document.getElementById('value1').value;
	var b=document.getElementById('ptype').value;
	
	if(b==02)
	{
		 if(!(a.match(/^\d{2}-\d{2}-\d{4}$/)) || ! checkDate(a))
		 {
		alert("enter a valid date in dd-mm-yyyy format");
		return false;
		 }
		 else if( isFutureDate(a) ){
		alert("date can not be future date");
		}
	}

	if(b== 01 )
	{
		if( !(a.match(/^[A-Za-z ]+$/)))
		{
		alert("Value should be string");
		return false;
	    }
	}
	
	if(b== 03 )
	{
		  if(!isNaN(a))
		  {
		alert("Value should be number");
		return false;
	    }
	}
		return false;
	
}
function checkDate(stringDate){//DD-MM-YYYY
	
	var day = stringDate.substring(0,2);
	var month = stringDate.substring(3,5);
	var year = stringDate.substring(6);
	if (month > 12 || day >31) {
		return false;
	}else if (month == 2) {
        if (day == 29) {
            if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0) {
                return false;
            }
        }else if (day > 28) {
        	return false;
        }
    }else if (month == 4 || month == 6 || month  == 9 || month == 11) {
        if (day > 30) {
        	return false;
        }
    } else {
        if (day > 31) {
        	return false;
        }
    }
	
	return true;
}
    

//compare the given date with current date, to check if its future date

function isFutureDate(stringDate){//DD-MM-YYYY
	
	var day = stringDate.substring(0,2);
	var month = stringDate.substring(3,5);
	var year = stringDate.substring(6);	
	
	var inputDate = new Date();
	inputDate.setFullYear(year,month-1,day); //set year,month(range is 0-11),day(range is 1-31)

	var currentDate = new Date(); 
	
	if( inputDate > currentDate ){
		return true;
	}

	return false;
	
}
//function of trim
function trim(str) {
	if (!str || typeof str != 'string')
		return str;
	return str.replace(/^[\s]+/, '').replace(/[\s]+$/, '').replace(/[\s]{2,}/,
			' ');
}

