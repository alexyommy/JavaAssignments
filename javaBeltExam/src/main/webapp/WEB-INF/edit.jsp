<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Edit Task</title>
</head>
<body>
<div class="container">
	<div class="card">
		<nav>
			<a href="/tasks" class="btn btn-success">Go Home</a>
		</nav>
		<!--  Update Form -->
	<div class="card">
		<h1>${task.name}</h1>
		<!--  Set up Update Forms this way -->
		<form:form action="/tasks/${task.id}/editTask" method="post" modelAttribute="task">
		<input type="hidden" name="_method" value="put">
		<!--  Don't forget form:hidden -->
		<form:hidden value="${user}" path="creator"/>
		<div class="form-group">
			<form:label path="name">Task Name: </form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="assignee">Assignee: </form:label>
			<form:errors path="assignee"/>
			<form:select path="assignee">
				<c:forEach items="${assignees}" var="assignee" varStatus="loop">
					<c:choose>
	       			<c:when test="${assignee.name.equals(task.assignee)}">
	       				<option selected value="${assignee.name}">${assignee.name}</option>
	       			</c:when>
	       			<c:otherwise>
	       				<option value="${assignee.name}">${assignee.name}</option>
	       			</c:otherwise>
	       			</c:choose> 
       			</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="priority">Priority: </form:label>
			<form:errors path="priority"/>
			<form:select path="priority">
				<c:choose>
	       			<c:when test="${task.priority.equals('high')}">
	       				<option selected value="high">High</option>
	       				<option value="medium">Medium</option>
						<option value="low">Low</option>
	       			</c:when>
	       			
	       			<c:otherwise>
	       				<c:choose>
			       			<c:when test="${task.priority.equals('medium')}">
			       				<option selected value="medium">Medium</option>
			       				<option value="high">High</option>
								<option value="low">Low</option>
			       			</c:when>
			       			
			       			<c:otherwise>
			       				<option selected value="low">Low</option>
			       				<option value="medium">Medium</option>
								<option value="high">High</option>
			       			</c:otherwise>
		       			</c:choose>
	       			</c:otherwise>
	       			
       			</c:choose>
			</form:select>
		</div> 
		<button class="btn btn-primary">Update Task</button>
		</form:form>
	</div> 
	</div>
</div>
</body>
</html>