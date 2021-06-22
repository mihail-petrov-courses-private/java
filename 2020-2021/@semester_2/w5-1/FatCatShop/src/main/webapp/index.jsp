<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fat Cat Web App</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>

	<div id="form-container">
		<form method="post" action="home">
		
			<label>User name</label>
			<input 
				name="user_name"
				class="input"
				type="text" 
				placeholder="Say your name"/>
			
			<label>User age</label>	
			<input
				name="user_age" 
				class="input"
				type="number" 
				placeholder="my age">
				
			<label>Gender</label>
			
			Male	
			<input
				name="user_gender" 
				class="input"
				type="radio"
				value="male" 
				placeholder="my age">
				
			Fimale
			<input
				name="user_gender" 
				class="input"
				type="radio"
				value="fimale" 
				placeholder="my age">
			
			<label>Favorite color</label>
			<select
				class="input" 
				name="favorite_color">
				<option value="green">green</option>
				<option value="orange">orange</option>
				<option value="blue">blue</option>
				<option value="red">red</option>
				<option value="white">white</option>
				<option value="black">black</option>
				<option value="colorful">colorful</option>
			</select>
			
			
			<input type="submit" value="HI">
		</form>
	</div>



</body>
</html>