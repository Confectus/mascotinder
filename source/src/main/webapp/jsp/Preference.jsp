<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pet_preference" scope="request" value="${pet_preference}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preference</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<!-- Font Awesome -->
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<!-- CSS style sheet -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

	<%@include file="../templates/banner.html" %>
	
	<div class="container-conf">
		<div class="list-title">
			<p class="h1 my-pets-text">
				Preferences
			</p>
		</div>
	</div>
	<form method="post" action="PreferenceController" class="form-table-config">
		<div class="container mw-90 w-90 flex-column" style="border: 1px solid red;">
			<div class="row">
				<h3>Search pets with the next characteristics:</h3>
			</div>
			<div class="row">
				Type
			</div>
			<div class="row">
				Type options
			</div>
			<div class="row">
				Sex
			</div>
			<div class="row">
				Sex options
			</div>
			<div class="row">
				Age range
			</div>
			<div class="row">
				<div class="col">
					Max age
				</div>
				<div class="col">
					Min age
				</div>
			</div>
			<div class="row">
				<div class="col">
					Max age options
				</div>
				<div class="col">
					Min age options
				</div>
			</div>
		</div>
	</form>

	<form method="post" action="PreferenceController">
	
		<label for="pet_type">Type:</label>
	
		<select name="pet_type" id="pet_type">
			<c:forEach items="${types}" var="types">
				<option value="${types}" ${(pet_preference != null && pet_preference.type == types) ? 'selected' : ''}>${types}</option>
			</c:forEach>	 
		</select><br>
		
		<label for="pet_sex">Sex:</label>
		
		<select name="pet_sex" id="pet_sex">	
			<option value="male" ${(pet_preference != null && pet_preference.sex == 'male') ? 'selected' : ''}>Male</option>	 
			<option value="female" ${(pet_preference != null && pet_preference.sex == 'female') ? 'selected' : ''}>Female</option>
		</select>
		
		<h2>Age Range:</h2><br>
		
		<label for="pet_minimum_age">Minimum Age:</label>
		
		<select name="pet_minimum_age" id="pet_minimum_age">	
			<c:forEach begin="1" end="20" varStatus="loop">
			    <option value="${loop.index}" ${(pet_preference != null && pet_preference.minimumAge == loop.index) ? 'selected' : ''}>${loop.index}</option>
			</c:forEach>
		</select>
		
		<label for="pet_maximum_age">Maximum Age:</label>
		
		<select name="pet_maximum_age" id="pet_maximum_age">	
			<c:forEach begin="1" end="20" varStatus="loop">
			    <option value="${loop.index}" ${(pet_preference != null && pet_preference.maximumAge == loop.index) ? 'selected' : ''}>${loop.index}</option>
			</c:forEach>			
		</select><br>
		
		<input type="hidden" name="petId" value="${petId}">
		
		<input type="submit" value="Save">
	
	</form>	

</body>
</html>