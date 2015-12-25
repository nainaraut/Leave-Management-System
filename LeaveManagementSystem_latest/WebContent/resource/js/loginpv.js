function validationform() {

	var ud = document.forms["pvform"]["username"].value;
	var pd = document.forms["pvform"]["password"].value;
	if (ud == null || ud == "") {
		document.getElementById("luid").innerHTML = "Please enter user ID";

		return false;
	} else {
		document.getElementById("luid").innerHTML = " ";

	}
	if (isNaN(ud)) {
		document.getElementById("luid").innerHTML = "Only digits are allowed";

		return false;
	} else {
		document.getElementById("luid").innerHTML = " ";
	}
	if (ud.length != 3) {
		document.getElementById("luid").innerHTML = "ID should be of 3 digits";
		return false;
	} else {
		document.getElementById("luid").innerHTML = " ";
	}
	if (pd == null || pd == "") {
		document.getElementById("lpwd").innerHTML = "Please enter Password";

		return false;
	} else {
		document.getElementById("lpwd").innerHTML = " ";

	}
}
