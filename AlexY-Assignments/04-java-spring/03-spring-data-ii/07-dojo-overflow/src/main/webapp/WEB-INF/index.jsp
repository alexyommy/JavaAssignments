<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Question</title>
</head>
<body>
<div class="container">
	<nav>
		<h3><a href="/question">Add New Question</a></h3>
	</nav>
	<h1>Questions Dashboard</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${questions}" var="question" varStatus="loop">
			<tr>
				<td><a href="/question/${question.id}">${question.question}</a></td>
				<td>
					<c:forEach items="${ question.tags }" var="tag">
						<span>
							${ tag.subject }<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1 }">, </c:if>
						</span>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>