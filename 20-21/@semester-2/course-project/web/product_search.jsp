<%--
  Created by IntelliJ IDEA.
  User: mail
  Date: 7/13/2020
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>Search for product</h2>
    <form method="get" action="http://localhost:8182/JavaWebShop2_war_exploded/base/product/q">
        <input type="text" name="product_name">
        <input type="submit">
    </form>


</body>
</html>
