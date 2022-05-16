<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        input {
            display: block;
        }

    </style>
</head>
<body>
    <h1> Registration page</h1>

    <form action="registration"
          method="post">

        <input type="text"
               name="user_name"
               placeholder="Username">
        <input type="text"
               name="user_email"
               placeholder="E-mail">
        <input type="password"
               name="user_pass"
               placeholder="Password">
        <input type="password"
               name="user_pass_repeat"
               placeholder="Repeat password">
        <input type="text"
               name="user_age"
               placeholder="User age">
        <input type="submit">
    </form>

</body>
</html>