<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
</head>
<body>
<p><c:out value="${error }"></c:out></p>
	<h1>What is the code?</h1>
	<form action="/submit" method="POST">
		<input type="text" name="code" placeholder="Enter code here">
	<input type="submit">
	</form>
</body>
</html>