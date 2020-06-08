<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello Web World</title>
  </head>
  <body>

    <jsp:include page="/init"></jsp:include>

    <h1>${message}</h1>
    <%
      ArrayList<String> collection = (ArrayList<String>) request.getAttribute("web_collection");

      for(int i = 0; i < collection.size(); i++) {
        out.print("<br>" + collection.get(i));
      }
    %>

    <br>

    <jsp:include page="section.jsp"></jsp:include>

      <br>
      Hi my name is Mihail Petrov
      <a href="registration.jsp">Registration</a>
      <a href="login.jsp">Login into system</a>
    <a href="users.jsp">User system info</a>
  </body>
</html>
