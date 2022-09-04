<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="5">
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
	
<script src="https://code.jquery.com/jquery-3.6.1.min.js" 
	    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
	    crossorigin="anonymous"></script>

<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
		
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>	

<!-- Font Awesome -->
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

</head>
<body>
	
	<script>
		function processMessage(sendFlag) {
			var content = document.querySelector("#input_value").value;
			var senderEmail = document.querySelector("#senderEmail").textContent;
			var receiverEmail = document.querySelector("#receiverEmail").textContent;
			
			$.ajax({
				url: "/mascotinder/ChatController",
				type: "POST",
				data: {
					send_flag: sendFlag,
					content: content,
					sender_email: senderEmail,
					receiver_email: receiverEmail,
				},
				success: function(result) {
					console.log("ChatController received the data correctly");	
					content.value = "";
				}
			});	
			
			
		}
	</script>

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
			<p class="h1 my-pets-text" style="width: 100%"></p>
		</div>
	</div>
	
	<!-- HIDDEN DATA TO HANDLE THE MESSAGES -->
	<p style='display: none' id='senderEmail'>${sender_owner_email}</p>
	<p style='display: none' id='receiverEmail'>${receiver_owner_email}</p>
	
	<div class="card-total-container">
		<c:forEach items="${messages}" var="message">
			<div class="row card-container border-conf">
			
				<div class="col-1">
					<p>${message.sender.name}:</p>
				</div>
					
				<div class="col-5">
					<p>${message.content}</p>
				</div>
				
			</div>
		</c:forEach>
		
	</div>
	
	<div class="col-5"> 
		<input type="text" id="input_value" name="message_content" class="form-content-name" required>
	</div>
	<div class="col-1"> 
		<input type="button" value="Send" id="submit-btn" class="text-light save-text" onclick="processMessage(true);">
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