<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TransferMoney</title>
</head>
<body>

	<form action="transferByAccountNo">
		<input type="text" name="accountNo"></input>
		<button>Search</button>
	</form>
	${accountNoNotFound}
	<table>
		<tr>
			<th>Customoer ID</th>
			<th>Customer Name</th>
			<th>Customer Username</th>
			<th>Transfer</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.name}</td>
				<td>${customer.username }</td>
				<td><a href="/transfer/${customer.customerId}">Transfer</a></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>