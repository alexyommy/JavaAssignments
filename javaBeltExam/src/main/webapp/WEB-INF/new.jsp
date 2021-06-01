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
<title>Create Task</title>
</head>
<body>
<div class="container">
	<nav>
		<a href="/tasks" class="btn btn-success">Go Home</a>
	</nav>
	<div class="card">
	<form:form action="/add" method="post" modelAttribute="task">
		<!--  Don't forget hidden input type for form:form -->
		<form:input type="hidden" path="creator" value="${user.id}"/>
		<div class="form-group">
			<form:label path="name">Task: </form:label>
			<form:errors path="name"/>
			<form:textarea class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="assignee">Assignee: </form:label>
			<form:errors path="assignee"/>
			<form:select path="assignee">
				<c:forEach items="${ assignees }" var="assignee">
					<option value="${ assignee.name }">${ assignee.name }</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="priority">Priority: </form:label>
			<form:errors path="priority"/>
			<form:select path="priority">
				<option value="high">High</option>
				<option value="medium">Medium</option>
				<option value="low">Low</option>
			</form:select>
		</div>
		<button class="btn btn-primary">Create</button>
	</form:form>	
	</div>
</div>
</body>
</html>