<jsp:include 
	page="header.jsp"/>

	<div id="form-container">
				
		<form 
			method="post" 
			action="registration">

			<label>User E-mail</label>
			<input 
				name="user_email"
				class="input"
				type="text" 
				placeholder="E-mail"/>	
		
			<label>User name</label>
			<input 
				name="user_name"
				class="input"
				type="text" 
				placeholder="Say your name"/>
				
			<label>User password</label>
			<input 
				name="user_pass"
				class="input"
				type="password" 
				placeholder="password"/>
				
			<label>User first name</label>
			<input 
				name="user_first_name"
				class="input"
				type="text" 
				placeholder="Say your first name"/>
				
			<label>User last name</label>
			<input 
				name="user_last_name"
				class="input"
				type="text" 
				placeholder="Say your last name"/>								
				
			<input 
				name="user_age"
				class="input"
				type="text" 
				placeholder="age"/>
				
			<input 
				name="user_city"
				class="input"
				type="text" 
				placeholder="city"/>
				
			<input 
				name="user_address"
				class="input"
				type="text" 
				placeholder="Address"/>				
				
			<input 
				type="submit" 
				value="Login">
		</form>
	</div>
	
<jsp:include 
	page="footer.jsp"/>