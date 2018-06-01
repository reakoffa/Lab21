<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function regValidation() {
		var uName = document.forms["RegForm"]["uName"];
		var fName = document.forms["RegForm"]["fName"];
		var lName = document.forms["RegForm"]["lName"];
		var email = document.forms["RegForm"]["email"];
		var password = document.forms["RegForm"]["password"];

		if (fName.value == "") {
			alert("Please enter your name.");
			fName.focus();
			return false;
		}
		if (uName.value == "") {
			alert("Please enter your name.");
			fName.focus();
			return false;
		}
		if (lName.value == "") {
			alert("Please enter your name.");
			lName.focus();
			return false;
		}

		if (email.value == "") {
			alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}

		if (email.value.indexOf("@", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}

		if (email.value.indexOf(".", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}

		if (password.value == "") {
			window.alert("Please enter your password");
			password.focus();
			return false;
		}

		return true;
	}
</script>
</head>
<body>
<h1 style="text-align: left"> REGISTRATION FORM </h1> 
	<form name="RegForm" action="/successful" onsubmit="return regValidation()" method="post">
		Username: <input type="text" name="uName"> <br>
		<br> First Name: <input type="text" name="fName"> <br>
		<br> Last Name: <input type="text" name="lName"> <br>
		<br> Email: <input type="text" name="email"> <br>
		<br> Password: <input type="text" name="password"> <br>
		<br> 
		<input type="submit" value="Submit">
	</form>

</body>
</html>