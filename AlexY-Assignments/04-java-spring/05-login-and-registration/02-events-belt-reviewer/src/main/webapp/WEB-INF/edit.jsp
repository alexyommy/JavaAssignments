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
<title>Edit Event</title>
</head>
<body>
<div class="container">
	<!--  Navigation Bar -->
	<div class="card">
		<h1>Edit Event</h1>
		<nav>
			<h3><a href="/dashboard">Home</a></h3>
			<h3><a href="/link2">Link2</a></h3>
		</nav>
	</div>
	
	<!--  Update Form -->
	<div class="card">
		<h1>${event.name}</h1>
		<!--  Set up Update Forms this way -->
		<form:form action="/events/${event.id}/editEvent" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
		<!--  Don't forget form:hidden -->
		<form:hidden value="${user}" path="planner"/>
		<div class="form-group">
			<form:label path="name">Name: </form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="eventDate">Event Date: </form:label>
			<form:errors path="eventDate"/>
			<form:input type="date" class="form-control" path="eventDate"/>
		</div>
		<div class="form-group">
			<form:label path="city">City: </form:label>
			<form:errors path="city"/>
			<form:input class="form-control" path="city"/>
		</div>
		<div class="form-group">
			<form:label path="state">State: </form:label>
			<form:errors path="state"/>
			<form:select class="form-control" path="state">
				<c:forEach items="${states}" var="state" varStatus="loop">
				<c:choose>
        			<c:when test="${state.equals(event.state)}">
        				<option selected value="${state}">${state}</option>
        			</c:when>
        			<c:otherwise>
        				<option value="${state}">${state}</option>
        			</c:otherwise> 
        		</c:choose>
        		</c:forEach>		
			</form:select>
		</div>
		<button class="btn btn-primary">Update Event</button>
		</form:form>
	</div> 
</div>
</body>
</html>