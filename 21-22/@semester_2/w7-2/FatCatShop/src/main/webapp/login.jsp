<jsp:include 
	page="header.jsp"/>
	
	<div id="form-container">
		
		<form 
			method="post" 
			action="login">
		
			<label>User name</label>
			<input 
				name="user_email"
				class="input"
				type="text" 
				placeholder="Say your E-mail"/>
				
			<label>User password</label>
			<input 
				name="user_pass"
				class="input"
				type="password" 
				placeholder="password"/>				
			
			<input 
				type="submit" 
				value="Login">
		</form>

<jsp:include 
	page="footer.jsp"/>