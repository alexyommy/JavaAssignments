<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title><c:out value="${task.name}"/></title>
</head>
<body>
<div class="container">
	<div class="card">
		<nav>
			<a href="/tasks" class="btn btn-success">Go Home</a>
		</nav>
	</div>
	<div class="card">
		<h1>Task: ${task.name}</h1>
		<p>Creator: ${task.creator.name}</p>
		<p>Assignee: ${task.assignee}</p>
		<p>Priority: ${task.priority}</p>		
	</div>
	<div class="card">
		<c:if test="${task.creator.equals(user)}">
			<td>
			<a href="/tasks/${task.id}/edit">Edit</a> 
			<form action ="/tasks/${task.id}/delete" method ="POST">
			<input class="btn btn-danger" type="submit" value="Delete">
			</form>
			</td>	
		</c:if>
	</div>
	<div class="card">
		<c:if test="${task.assignee.equals(user.name)}">
			<td>
			<form action ="/tasks/${task.id}/complete" method ="POST">
			<input class="btn btn-success" type="submit" value="Complete">
			</form> 
			</td>
		</c:if>
	</div>
</div>
</body>
</html>