<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.Form" %><%--
  Created by IntelliJ IDEA.
  User: mail
  Date: 7/13/2020
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../../components/header.jsp"></jsp:include>

    <h2>Search for product</h2>
    <form method="get" action="http://localhost:8182/JavaWebShop2_war_exploded/base/product/q">
        <input type="text" name="product_name">
        <input type="submit">
    </form>
    <hr>

    <%
        ArrayList<Product> productCollection = (ArrayList<Product>) session.getAttribute("product_q_result");

        if(productCollection != null) {

            for(Product element : productCollection) {
                Form.div(out, element.getTitle());
                Form.div(out, element.getDescription());
            }
        }
    %>

<jsp:include page="../../components/footer.jsp"></jsp:include>