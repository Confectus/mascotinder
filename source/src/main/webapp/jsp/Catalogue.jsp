<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pets Catalogue</title>
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
			<p class="h1 my-pets-text">
				Posible Matchs
			</p>
		</div>
	</div>
	<div class="container bg-danger" >
	<div class="carousel-item">
	 <c:forEach items="${catalogue}" var="pet">
	  <img src="data:image/png;base64,${pet.images[0].base64Image}" alt="${pet.name}" width="500px" height="200px">
	  <div class="carousel-caption d-none d-md-block">
	    <h5>${pet.name}</h5>
	    <p>My pet ${pet.name} is a ${pet.age} year old ${pet.sex}, looking for a match in Mascotinder.</p>
	  </div>
	  </c:forEach>
	</div>
	</div>
</body>
</html>