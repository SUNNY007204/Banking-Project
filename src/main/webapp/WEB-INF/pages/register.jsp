<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form:form action="registerCustomer" method="post" modelAttribute="customer">
				<div> Name : <form:input path="name"/> </div>
				<div> Username : <form:input path="username"/> <p style = color:red>${userExistsError}</p> </div > 
				<div> Password : <form:input path="password"/> </div>
				<div> Mobile No. : <form:input path="phNo"/> </div>
				<div> Address : <form:input path="address"/> </div>
				<div> PAN No. : <form:input path="panNo"/> </div>
				<div> AADHAR No. : <form:input path="aadharNo"/> </div>		
		<form:button>Submit</form:button>
		<a href="/login">Login</a> again
	
	</form:form>

</body>
</html>