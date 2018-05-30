<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Our products</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Our inventory</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Item</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${item}">
					<tr>
						<td>${item.name}</a></td>
						<td>${item.description}</td>
						<td>${item.quantity}</td>
						<td>$${item.price}</a></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>