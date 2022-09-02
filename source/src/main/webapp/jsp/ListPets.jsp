<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
	<%@include file="../templates/banner.html"%>

	<div class="container-conf">
		<div class="list-title">
			<p class="h1 my-pets-text">My pets</p>
		</div>

		<div class="add-btn">
			<a href="RegisterController" class="text-light new-pet-text"> New pet </a>
		</div>
	</div>

	<div class="card-total-container">
		<c:forEach items="${pets}" var="pet">
			<!-- Pets cards -->
			<div class="row card-container border-conf">
				<!-- Pet profile photo -->
				<div class="col-3 profile-pet-photo">
					<img src="data:image/png;base64,${pet.images[0].base64Image}" />
				</div>
				<!-- Pet description -->
				<div class="col mh-100">
					<div class="row mh-100 ht-100">
						<h1 id="pet-title">${pet.name}</h1>
					</div>
					<div class="row mh-100 ht-100 color-blue">
						<div class="center-description">
							<p>My pet ${pet.name} is a ${pet.age} year old ${pet.sex}
								looking for a partner in MascoTinder.</p>
						</div>
					</div>
					<div class="row mh-100 pet-options-row ht-100">
						<div class="col">
							<div class="preferences-text">
								<a href="PreferenceController?pet_id=${pet.id}"> PREFERENCES
								</a>
							</div>
						</div>
						<div class="col color-blue">
							<p class="center-text">
								<a href="MatchesController?pet_id=${pet.id}"> MATCHES </a><i
									class="bi bi-heart-fill"></i> ${pet.matches.size()}
							</p>
						</div>
						<div class="col color-blue">
							<p class="center-text">
								<a href="CatalogueController?pet_id=${pet.id}">SEARCH</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>