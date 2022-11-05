<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
</head>
<body>

	${Beneficiary_Name} | ${Beneficiary_PhNo} | ${Beneficiary_AccNo}

	<form:form action="/transfer/${beneficiaryId}" method="post">
		<input type="number" name="transferAmount" />
		<button>Confirm</button>
	</form:form>

</body>
</html>