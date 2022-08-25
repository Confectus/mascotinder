<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pet_preference" scope="request" value="${pet_preference}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preference</title>
</head>
<body>

	<h1>Preference:</h1><br>
	<h3>Search pets with the next characteristics:</h3><br>

	<form method="get" action="PreferenceController">
	
		<label for="pet_type">Type:</label>
	
		<select name="pet_type" id="pet_type">
			<c:forEach items="${types}" var="types">
				<option value="${types}" ${(pet_preference != null && pet_preference.type == types) ? 'selected' : ''}>${types}</option>
			</c:forEach>	 
		</select><br>
		
		<label for="pet_sex">Sex:</label>
		
		<select name="pet_sex" id="pet_sex">	
			<option value="male" ${(pet_preference != null && pet_preference.sex == "male") ? 'selected' : ''}>Male</option>	 
			<option value="female" ${(pet_preference != null && pet_preference.sex == "female") ? 'selected' : ''}>Female</option>
		</select>
		
		<h2>Age Range:</h2><br>
		
		<label for="pet_minimum_age">Minimum Age:</label>
		
		<select name="pet_minimum_age" id="pet_minimum_age">	
			<option value="1">1</option>	 
			<option value="2" ${(pet_preference != null && pet_preference.maximumAge == 2) ? 'selected' : ''}>2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12" ${(pet_preference != null && pet_preference.maximumAge == 12) ? 'selected' : ''}>12</option>		
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
		</select>
		
		<label for="pet_maximum_age">Maximum Age:</label>
		
		<select name="pet_maximum_age" id="pet_maximum_age">	
			<option value="1">1</option>	 
			<option value="2" ${(pet_preference != null && pet_preference.maximumAge == 2) ? 'selected' : ''}>2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12" ${(pet_preference != null && pet_preference.maximumAge == 12) ? 'selected' : ''}>12</option>		
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
		</select><br>
		
		<input type="submit" value="Submit">
	
	</form>	

</body>
</html>