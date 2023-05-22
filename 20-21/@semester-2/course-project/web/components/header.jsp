<%@ page import="service.Auth" %>
<%@ page import="service.Util" %>
<%@ page import="service.Form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- relative : no /    --%>
    <%-- absolute : /       --%>
    <link rel="stylesheet" href="http://localhost:8182/JavaWebShop2_war_exploded/style/style.css">
</head>
<body>
<div id="header">
    <div>Cat Shop</div>
    <div>Welcome : <% if(Auth.getUser() != null) out.print(Auth.getUser().getFullName()); %></div>

    <div>
        <ul>
            <li>
                <% if(Auth.isAuthenticated()) Form.href(out, "auth/signout", "Signout"); %>
            </li>

            <li>
                <% if(Auth.isNotAuthenticated()) Form.href(out, "auth/signin", "Sign In"); %>
                <% if(Auth.isNotAuthenticated()) Form.href(out, "auth/signup", "Sign up"); %>
            </li>
        </ul>
    </div>


</div>

