<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Pets Catalogue</title>
<!-- Bootstrap -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!-- CSS style sheet -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" ></script>
</head>
<body>

<!-- Nav -->
	<%@include file="../templates/banner.html" %>
	<%!
	public int count = 0;
	%>
	<div class="container-conf ">
		<div class="d-block text-center" style="margin-left: auto; margin-right: auto" >
			<p class="h2 my-pets-text " id="namePet">${catalogue[0].name}</p>
			<p class="h3 my-pets-text " id="agePet">${catalogue[0].age}</p>
		</div>
	</div>
	
	
<!-- Carousel -->	
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">   
    <c:forEach items="${catalogue[0].images}" var="img">
    	<c:choose>
    		<c:when test="${img.id == 1}">
    			<div class="carousel-item active catalogue-pet-photo">
			      <img class="rounded mx-auto d-block" height: 150px src="data:image/png;base64,${img.base64Image}" alt="First slide">
			    </div>
    		</c:when>
    		<c:otherwise>
    			<div class="carousel-item catalogue-pet-photo">
			      <img class="rounded mx-auto d-block" height: 150px src="data:image/png;base64,${img.base64Image}" alt="Second slide">
			    </div>
    		</c:otherwise>
    	</c:choose> 
	  	
	</c:forEach>
  
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls"  role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next " href="#carouselExampleControls"  role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
	
	<div class="position-relative nav-like">
	<!-- Like -->
	<a class="btn btn-primary position-absolute top-100 end-50 like" style="background-color: #319EFF; border: none;" href="#!" role="button" id="like_btn">
	  <i class="fa fa-thumbs-up prueba" ></i>
	</a>
	<!-- DisLike -->
	<a class="btn btn-primary position-absolute top-100 start-50 " style="background-color: #319EFF; border: none;" href="#!" role="button">
	  <i class="fa fa-thumbs-down"></i>
	</a>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
	var lenghtCatalogue = Object.keys("$(catalogue)").length
	$(document).ready(function(){ 
		$(".like").click(function(){
			const myJSON = JSON.stringify(${catalogue[1].name});
			$("#namePet").text('${catalogue[1].name}');
			console.log(myJSON);
				
				//${catalogue[0].name}
	
		})
		
	   
	});
	</script>
</body>
</html>