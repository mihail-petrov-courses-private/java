<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <jsp:include page="sections/header.jsp"></jsp:include>

<%--    <div id="content">--%>
<%--      Hi my name is Mihail Petrov--%>
<%--    </div>--%>

    <form method="post" action="nameinput">
        <input type="text" name="username" placeholder="Enter username">
        <input type="submit">
    </form>



    <jsp:include page="sections/footer.jsp"></jsp:include>