<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pets List</title>

</head>
<body>	
	
	<h1>Pets List</h1>
	
	<div><a href="">Add Pet</a></div>
	
	<div>
		<table>
			<thead>
				<tr>
					<td scope="col">ID</td>
					<td scope="col">Name</td>
					<td scope="col">Type</td>
					<td scope="col">Specie</td>
					<td scope="col">Age</td>
				</tr>
			</thead>	
			
			<c:forEach items="${pet}" var="pets">
				<tr>
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