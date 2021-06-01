 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Add a New Language</h1>
	<form:form method="POST" action="/add" modelAttribute="language">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div class="form-group">
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</div>
		<div class="form-group">
			<form:label path="version">Version</form:label>
			<form:errors path="version"/>
			<form:input path="version"/>
		</div>
	<button>Add Language!</button>
	</form:form>
	<hr/>
	<h2>Add HTML Forms Way</h2>
	<c:forEach items="${errors}" var = "error">
	<p>${error}</p>
	</c:forEach>
	<form action="/add" method="POST">
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" name="name">
		</div>
		<div class="form-group">
			<label for="creator">Creator</label>
			<input type="text" name="creator">
		</div>
		<div class="form-group">
			<label for="version">Version</label>
			<input type="text" name="version">
		</div>
		<button>Submit</button>
	</form>
</div>
</body>
</html>