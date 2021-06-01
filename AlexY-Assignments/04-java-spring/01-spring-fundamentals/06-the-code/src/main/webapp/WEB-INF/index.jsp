<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>The Code</title>
	<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<form action="/tryCode" method="post">
		<span><c:out value="${ error }" /></span>
		<input type="text" name="guess" placeholder="What is the code?" />
		<button>Try Code</button>
	</form>
</body>
</html>