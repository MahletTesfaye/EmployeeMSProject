<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>
	<h1>Welcome to our registration page!</h1>
	<h2>Registration Form</h2>
	<form action="register" method="post">
		Name: <input type="text" name= "name" placeholder="Alex"/><br>
		Email: <input type="email" name="email" placeholder="alex@gmail.com" /><br>
		Password: <input type="password" name="password"/><br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>