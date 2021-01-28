<jsp:include page="components/header.jsp"></jsp:include>
<%

//    if((boolean)request.getAttribute("is_loged_in")) {
//
//    }
%>

${pageContext.request.contextPath}

<%= request.getAttribute("login_message") %>


<div class="form">
    <form method="POST">
        <input class="input" type="text" name="user_name" placeholder="Username">
        <input class="input" type="text" name="user_pass"  placeholder="Password">
        <input class="input" type="text" name="user_pass_repeat"  placeholder="Repeat password">
        <input class="input" type="text" name="user_email" placeholder="E-mail">
        <input class="input" type="text" name="user_fname" placeholder="First name">
        <input class="input" type="text" name="user_lname" placeholder="Last name">
        <input class="input-submit" type="submit">
    </form>

</div>


<jsp:include page="components/footer.jsp"></jsp:include>