<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date and Time</title>
<link rel="stylesheet" href = "css/style.css">
</head>

<body onload = "alertClient('<c:out value="${dt}"/>')">
	<h1 class=<c:out value="${ dt }"/>><c:out value="${ dtFormat }" /></h1>
	<script defer type="text/javascript" src="js/app.js"></script>
</body>
</html>