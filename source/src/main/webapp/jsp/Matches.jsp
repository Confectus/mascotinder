<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matches</title>

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
	
	<div class="card-total-container">
		<c:forEach items="${matches}" var="match">
			<h1 id="pet-title">${pet.name}</h1>
		</c:forEach>
	</div>

</body>
</html>