<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pets List</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<!-- CSS style sheet -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>	
	<%@include file="../templates/banner.html" %>
	
	<h1 class="list-title">
		My pets
	</h1>
	
	<div class="left-margin">
		<a href="" class="text-dark">
			Add Pet
		</a>
	</div>
	
	<div class="wrapper">
		<table class="center-table table">
			<thead class="thead-dark">
				<tr class="h6">
					<td scope="col">ID</td>
					<td scope="col">Name</td>
					<td scope="col">Type</td>
					<td scope="col">Species</td>
					<td scope="col">Age</td>
				</tr>
			</thead>	
			
			<c:forEach items="${pets}" var="pet">
				<tr class="text-muted">
					<td>${pet.id}</td>
					<td>${pet.name}</td>
					<td>${pet.type}</td>
					<td>${pet.specie}</td>
					<td>${pet.age}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>