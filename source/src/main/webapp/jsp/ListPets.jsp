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
	
	<div class="container-conf">
		<div class="list-title">
			<p class="h1 text-dark">
				My pets
			</p>
		</div>

		<div class="add-btn">
			<a href="" class="text-light new-pet-text">
				New pet
			</a>
		</div>
	</div>

	
	<div class="wrapper">
		<div class="table-container">
			<table class="center-table table">
				<thead class="thead-dark">
					<tr class="h6">
						<td scope="col">ID</td>
						<td scope="col">Name</td>
						<td scope="col">Type</td>
						<td scope="col">Sex</td>
						<td scope="col">Age</td>
						<td scope="col">Actions</td>
					</tr>
				</thead>	
			
				<c:forEach items="${pets}" var="pet">
					<tr class="text-muted">
						<td>${pet.id}</td>
						<td>${pet.name}</td>
						<td>${pet.type}</td>
						<td>${pet.sex}</td>
						<td>${pet.age}</td>
						<td><a href="PreferenceController?petId=${pet.id}">Set Preference</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<!-- Pets cards -->
	<div class="container card-container">
		<div class="row">
			<div class="col-3">
				<div class="profile-pet-photo">
				</div>
			</div>
			<div class="col">
				<div class="row">Firulais</div>
				<div class="row">Owner description goes here</div>
				<div class="row">
					<div class="col">PREFERENCES</div>
					<div class="col">MATCHS</div>
					<div class="col">SEARCH</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>