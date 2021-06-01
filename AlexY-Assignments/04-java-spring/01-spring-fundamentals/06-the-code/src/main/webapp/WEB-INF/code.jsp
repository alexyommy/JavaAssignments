<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
</head>
<body>
	<ul>
	<c:forEach items="${ commandments }" var="commandment">
		<li><c:out value="${ commandment }"/></li>	
	</c:forEach>
	</ul>
</body>
</html>