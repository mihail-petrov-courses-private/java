<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello World</h1>
	<h2>Log in</h2>
	
	<form action="login">
		<input 	type="text" 
				placeholder="Как се казваш ?"
				name="user_name">
				
		<input 	type="number" 
				min="12" 
				placeholder="На колко си ?"
				name="user_age">
				
		<input type="submit" value="Изпрати">
	</form>

</body>
</html>