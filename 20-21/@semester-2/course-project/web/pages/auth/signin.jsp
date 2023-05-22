<jsp:include page="../../components/header.jsp"></jsp:include>
<hr>
<%= request.getSession().getAttribute("message") %>
<hr>
${message}
<hr>

<div class="form">
    <form method = "POST">

        <input class="input"
               type ="text"
               name ="user_email">
        <input class="input"
               type="password"
               name="user_password">
        <input type="submit">
    </form>

</div>


<jsp:include page="../../components/footer.jsp"></jsp:include>