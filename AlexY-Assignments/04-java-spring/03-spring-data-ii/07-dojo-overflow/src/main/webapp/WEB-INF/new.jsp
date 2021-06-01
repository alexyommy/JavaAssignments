<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>New Question</title>
</head>
<body>
<div class="container">
	<h1>What is your question?</h1>
	<nav>
		<h3><a href="/">Go Home</a></h3>
	</nav>
	<form:form action="/question/new" method = "post" modelAttribute="newQuestion">
		<p class="form-group">
		<form:label path="question">Question</form:label>
		<form:errors path="question"/>
		<form:input path="question" type="text"/>
		</p>
		<p class="form-group">
		<form:label path="tags">Tags</form:label>
		<form:errors path="tags"/>
		<form:input path="tags" type="text"/>
		</p>
		<input type="submit" value="Add Question"/>
	</form:form>
</div>
</body>
</html>