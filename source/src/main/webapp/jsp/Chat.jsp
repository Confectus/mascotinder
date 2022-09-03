<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<!-- CSS style sheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
	
<!-- Font Awesome -->
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

</head>
<body>
	<nav class="navbar navbar-dark banner-config rad-border">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1  app-title"> MascoTinder <i
				class="fas fa-dog" style="font-size: 34px"></i>
			</span> <span class="navbar-brand mb-0 h3">
				<button onclick="myFunction()" class="text-light dropbtn">
					<i class="bi bi-person-circle" style="font-size: 24px"></i>
					${sessionScope.loggedOwner.getName()}
				</button> <span id="myDropdown" class="dropdown-content"> <a
					class="" href="ListPetsController"> My pets </a> <a
					class="" href="LoginController"> Logout </a>
			</span>
			</span>
		</div>
	</nav>
	<div class="container-conf">
		<div class="list-title" style="width: 100%">
			<p class="h1 my-pets-text" style="width: 100%">Register my Pet</p>
		</div>
	</div>
	
	<div class="card-total-container">
		<c:forEach items="${messages}" var="message">
			<div class="row card-container border-conf">
			
				<div>
					<p>${message.sender}:</p>
				</div>
					
				<div>
					<p>${message.content}</p>
				</div>
				
			</div>
		</c:forEach>
		
	</div>
	
	<div>
		<input type="text" name="message_content" class="form-content-name" required>
		<input type="submit" value="Send" id="submit-btn" class="text-light save-text">
	</div>

	<script>
		/* Toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}
	
		/* Close the dropdown menu whenever the user clicks outside of it */
		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {
				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
	</script>
</body>
</html>