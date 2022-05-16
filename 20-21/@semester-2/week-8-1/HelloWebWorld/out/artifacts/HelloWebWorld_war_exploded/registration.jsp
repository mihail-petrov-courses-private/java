<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        input {
            display: block;
        }

        .input--wrapper {
            display: block;
            border: solid #ff0000 1px;
            margin-top: 15px;
            margin-bottom: 15px;
            width: 170px;
        }

        .input--radio {
            width: 12px;
            display: inline;
        }

    </style>
</head>
<body>
    <h1> Registration page</h1>

    <%
            ArrayList<String> collection = (ArrayList<String>)request.getAttribute("messageCollection");
            System.out.println(("Error message collection"));
            out.print("<h1>Hello world</h1>");
            //for(int i = 0; i < collection.size(); i++) {

                //System.out.println(collection.get(i));
            //}

    %>


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

        <div class="input--wrapper">
            <input class="input--radio" type="radio" name="sex" value="M">
            <span>male</span>
        </div>

        <div class="input--wrapper">
            <input class="input--radio" type="radio" name="sex" value="F">
            <span>female</span>
        </div>

        <input type="hidden" name="form_id" value="8888">

        <input type="submit">
    </form>
</body>
</html>