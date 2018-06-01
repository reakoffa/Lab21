<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name="updForm" action="/update/form" onsubmit="return regValidation()" method="post">
		<br> Name: <input type="text" name="name" value="${item.name }"> <br>
		<br> Description: <input type="text" name="description" value="${item.description }"> <br>
		<br> Quantity: <input type="text" name="quantity" value="${item.quantity }"> <br>
		<br> Price: <input type="text" name="price" value="${item.price }"> <br>
		<br> 
		<input type="submit" value="Submit">
	</form>

</body>
</html>