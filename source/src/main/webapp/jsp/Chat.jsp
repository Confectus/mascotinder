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

</head>
<body>
	<%@include file="../templates/banner.html"%>
	
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
		<input type="submit" value="Send" id="submit-btn">
	</div>

</body>
</html>