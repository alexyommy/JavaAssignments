<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2>Add a New Song</h2>
	<form:form action="/songs" method="POST" modelAttribute="song">
			<div class="form-group">
		        <form:label path="name">Song Title</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:input class="form-control" path="artist"/>
		    </div>
		    <div class="form-group">
		        <form:label path="rating">Rating</form:label>
		        <form:errors path="rating"/>
		        <form:input type="number" class="form-control" path="rating"/>
		    </div>
		    <button>Add Song</button>
		</form:form>
</div>
</body>
</html>