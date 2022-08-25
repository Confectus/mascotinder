<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<div>
		<div>		
			<form method="post" action="../LoginController">
				<fieldset>
					<legend>Login</legend>
				
					<p>Email:</p>
					<input type="email" name="txtEmail" placeholder="Enter your email" required><br>
					
					<p>Password:</p>
					<input type="password" name="txtPassword" placeholder="Enter your password" required><br><br>
					
					<input type="submit" value="Log In">
				</fieldset>
			</form>
		</div>		
	</div>

</body>
</html>