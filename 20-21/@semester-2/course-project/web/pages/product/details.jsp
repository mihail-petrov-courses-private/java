<%@ page import="model.Product" %><%--
  Created by IntelliJ IDEA.
  User: mail
  Date: 7/13/2020
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../../components/header.jsp"></jsp:include>
    <h2>Product Details REQUEST SESSION</h2>
    <%
        Product detailsProduct =  (Product)request.getSession().getAttribute("product_details_product");
        out.print(detailsProduct.getDescription());
    %>

    <h2>Product Details HTTP Session</h2>
    <%
        Product sessionProduct = (Product)session.getAttribute("product_details_product");
        out.print(sessionProduct.getDescription());

    %>
<jsp:include page="../../components/footer.jsp"></jsp:include>