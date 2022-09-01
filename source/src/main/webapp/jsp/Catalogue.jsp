<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pet_id" scope="request" value="${pet_id}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Pets Catalogue</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- CSS style sheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<script type='text/javascript'
	src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


</head>
<body>

	<script>
	
		function addNode(id,name,age,image1,image2,image3) {
			
			var nodeHTML = document.createElement("div");
			
			nodeHTML.className = "carousel-item catalogue-pet-photo";
			var stringHTML = "<div class='container-conf '><div class='d-block text-center'" +
			" style='margin-left: auto; margin-right: auto'>"+
			"<p style='display: none' id='requesterId'>"+id+"</p>"+
			"<p style='display: none' id='imagePet1'>data:image/png;base64,"+image1+"</p>"+
			"<p style='display: none' id='imagePet2'>data:image/png;base64,"+image2+"</p>"+
			"<p style='display: none' id='imagePet3'>data:image/png;base64,"+image3+"</p>"+
			"<p class='h2 my-pets-text' id='namePet'>"+name+"</p><p class='h3 my-pets-text '"+
			"id='agePet'>"+age+"</p></div></div>" + 
			"<img class='rounded mx-auto d-block' height: 150px" +
			" src='data:image/png;base64,"+image1+"'> </div>";
			stringHTML = stringHTML.trim();
			nodeHTML.innerHTML = stringHTML;
			
			return nodeHTML;
			
		}
		window.ready = addNode;
		
		let photos = [
			"data:image/png;base64,${pets[id].images[0].base64Image}",
			"data:image/png;base64,${pets[id].images[1].base64Image}",
			"data:image/png;base64,${pets[id].images[2].base64Image}"]
		
		function prev(){
			var petPhotoPath = document.querySelector("#petCarouselInner > div.carousel-item.active.catalogue-pet-photo > img");
			var indexOfPhotos = document.querySelector("#actualPhoto").textContent;
			
			if(indexOfPhotos > 0){
				indexOfPhotos -= 1;
			}else{
				indexOfPhotos = 2;
			}
			document.querySelector("#actualPhoto").textContent = indexOfPhotos;
			
			switch(indexOfPhotos){
				case 0:
					console.log(indexOfPhotos);
					petPhotoPath.src=document.querySelector("#imagePet1").textContent;
					break;
				case 1:
					console.log(indexOfPhotos);
					petPhotoPath.src=document.querySelector("#imagePet2").textContent;
					break;
				case 2:
					console.log(indexOfPhotos);
					petPhotoPath.src=document.querySelector("#imagePet3").textContent;
					break;
			}
		}
		
		
		function next(){
			var petPhotoPath = document.querySelector("#petCarouselInner > div.carousel-item.active.catalogue-pet-photo > img");
			var indexOfPhotos = document.querySelector("#actualPhoto").textContent;
			indexOfPhotos = Number(indexOfPhotos);
			
			if(indexOfPhotos < 2){
				indexOfPhotos += 1;
			}else{
				indexOfPhotos = 0;
			}
			
			document.querySelector("#actualPhoto").textContent = indexOfPhotos;
			
			switch(indexOfPhotos){
				case 0:
					petPhotoPath.src=document.querySelector("#imagePet1").textContent;
				case 1:
					petPhotoPath.src=document.querySelector("#imagePet2").textContent;
				case 2:
					petPhotoPath.src=document.querySelector("#imagePet3").textContent;
			}
			
		}
		
		function processLike() {						
			var applicantId = document.querySelector("#requesterId").textContent;	
			var requesterId = urlParams.get("pet_id");
			
			applicantId = Number(applicantId);
			requesterId = Number(requesterId);
			
			$.ajax({
	            type : "POST",
	            data : {
	                value: 1
	            },
	            url : "/mascotinder/MatchesController"
	        });
		}
		
	</script>
		
		
	

	<!-- Nav -->
	<%@include file="../templates/banner.html"%>

	<!-- Carousel -->	
	<div id="petCarousel" class="carousel slide" data-interval="false">
		
		
		<div id="petCarouselInner" class="carousel-inner">
			<c:forEach items="${pets}" var="pet" varStatus="vs">
				<script>
					var bodyHTML = document.getElementById("petCarouselInner");
					var nodeHTML = addNode("${pet.id}","${pet.name}","${pet.age}","${pet.images[0].base64Image}","${pet.images[1].base64Image}","${pet.images[2].base64Image}");
					bodyHTML.appendChild(nodeHTML);
				</script>
			</c:forEach>

			
			<div class="carousel-item active catalogue-pet-photo">

				<div class="container-conf ">
					<div class="d-block text-center"
						style="margin-left: auto; margin-right: auto">
						<p style="display: none" id="idPet">${pets[0].id}</p>
						<p class="h2 my-pets-text " id="namePet">${pets[0].name}</p>
						<p class="h3 my-pets-text " id="agePet">${pets[0].age}</p>
					</div>
				</div>

				<img class="rounded mx-auto d-block" height: 150px
					src="data:image/png;base64,${pets[0].images[0].base64Image}"
					alt="Second slide">
							
			</div>
			
			

		</div>
		
		<a class="carousel-control-prev" href="#imageCarousel" role="button"> 
			<span class="carousel-control-prev-icon" aria-hidden="true" onclick="prev();"></span>
			<span class="sr-only">Previous</span>
		</a> 
		
		<a class="carousel-control-next " href="#imageCarousel" role="button"> 
			<span class="carousel-control-next-icon" aria-hidden="true" onclick="next();"></span> 
			<span class="sr-only">Next</span>
		</a>
		
	</div>

	<div class="position-relative nav-like">
		<!-- Like -->
		<a class="btn btn-primary position-absolute top-100 end-50 like"
			style="background-color: #319EFF; border: none;" href="#petCarousel"
			role="button" data-slide="next" onclick="processLike();"> <i
			class="fa fa-thumbs-up prueba"></i>
		</a>
		<!-- DisLike -->
		<a class="btn btn-primary position-absolute top-100 start-50 "
			style="background-color: #319EFF; border: none;" href="#petCarousel"
			role="button" data-slide="next"> <i class="fa fa-thumbs-down"></i>
		</a>
	</div>
	<div style="display: none" id="actualPhoto">0</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>