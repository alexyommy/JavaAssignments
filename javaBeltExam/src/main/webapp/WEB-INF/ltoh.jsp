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
<title>Dashboard</title>
</head>
<body>
<div class="container">
	<div class="card">
		<h2>Welcome, <c:out value="${user.name}"/></h2>
	</div>
	<div class="card">
		<nav>
			<h5><a href="/hightolow">Priority High - Low</a></h5>
			<h5><a href="/lowtohigh">Priority Low - High</a></h5>
			<a href="/tasks" class="btn btn-secondary">Go Home</a>
			<a href="/logout" class="btn btn-danger">Log Out</a>
		</nav>
	</div>
	<div class="card">
		<h2>Tasks</h2>
		<table class="table table-dark table table-striped">
			<thead>
				<tr>
					<th>Task</th>
					<th>Creator</th>
					<th>Assignee</th>
					<th>Priority</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task" varStatus="loop">
					<c:if test = "${task.priority.equals('low')}">
						<tr>
							<td><a href="tasks/${task.id}">${task.name}</a></td>
							<td>${task.creator.name}</td>
							<td>${task.assignee}</td>
							<td>${task.priority}</td>
						</tr>
					</c:if>
				</c:forEach>
				<c:forEach items="${tasks}" var="task" varStatus="loop">
					<c:if test = "${task.priority.equals('medium')}">
						<tr>
							<td><a href="tasks/${task.id}">${task.name}</a></td>
							<td>${task.creator.name}</td>
							<td>${task.assignee}</td>
							<td>${task.priority}</td>
						</tr>
					</c:if>
				</c:forEach>
				<c:forEach items="${tasks}" var="task" varStatus="loop">
					<c:if test = "${task.priority.equals('high')}">
						<tr>
							<td><a href="tasks/${task.id}">${task.name}</a></td>
							<td>${task.creator.name}</td>
							<td>${task.assignee}</td>
							<td>${task.priority}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="/tasks/new" class="btn btn-success">Create Task</a>
</div>	
</body>
</html>