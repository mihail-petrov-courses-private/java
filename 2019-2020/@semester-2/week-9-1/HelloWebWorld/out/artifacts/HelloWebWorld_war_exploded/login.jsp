<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> Login page</h1>

    <h2>Message with string interpolation : ${message}</h2>
    <h2>Message with string interpolation : <%= message %></h2>
    <h2>Message with JSP specific tags    : <%= request.getAttribute("message")  <%=request.getAttribute("message")  %> ${message} %> </h2>

    <%--   http://localhost:8182/HelloWebWorld_war_exploded/login --%>
    <form action="login"
          method="post">

        <input type="text"
               name="user_name">
        <input type="password"
               name="user_pass">
        <input type="submit">
    </form>
</body>
</html>
