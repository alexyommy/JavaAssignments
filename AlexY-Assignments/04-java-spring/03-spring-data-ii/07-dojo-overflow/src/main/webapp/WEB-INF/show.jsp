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
<title>Question Profile</title>
</head>
<body>
<div class="container">
	<nav>
		<h3><a href="/">Go Home</a></h3>
	</nav>
	<h1>${question.question}</h1>
	<h2>Tags:</h2>
	<ul>	
		<c:forEach items="${question.tags}" var="tag" varStatus="loop">
			<li><span>${tag.subject}</span></li>
		</c:forEach>
	</ul>
	<form:form action="/answer" method="post" modelAttribute="answerout">
		<div class="form-group">
			<form:label path="answer">Add your answer</form:label>
			<form:errors path="answer"/>
			<form:input path="answer" type="text"/>
		</div>
		<form:hidden path="question" value="${ question.id }"/>
		<input type="submit" value="Answer"/>
	</form:form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${question.answers}" var="answer" varStatus="loop">
				<tr>
					<td>${answer.answer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>