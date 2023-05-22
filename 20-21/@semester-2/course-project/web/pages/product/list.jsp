<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<%@ page import="service.Auth" %>
<%@ page import="service.Util" %>
<%@ page import="service.Form" %>
<jsp:include page="../../components/header.jsp"></jsp:include>

<h2>Search for product</h2>
<form method="get" action="http://localhost:8182/JavaWebShop2_war_exploded/base/product/q">
    <input type="text" name="product_name">
    <input type="submit">
</form>
<hr>

<h1> Product list</h1>
<%
    ArrayList<Product> productCollection = (ArrayList<Product>) request.getSession().getAttribute("product_list");

    for (Product element : productCollection) {

        out.print("<h3>" + element.getTitle() + "</h3>");
        out.print("<div>" + element.getDescription() + "</div>");
        out.print("<div>" + element.getPrice() + "</div>");
        out.print("<div>" + element.getPrice() + "</div>");
        Form.href(out, ("product/details?productid=" + element.getId()), "Product Details");

        if (Auth.isAuthenticated()) {

            String buyAction = Util.getFullPath("product/buy?id=" + element.getId());
            String buyComponent = "<a href=\"" + buyAction + "\">Buy</a>";
            out.print(buyComponent);
        }

        out.print("<hr>");
    }

    boolean hasNextPage = (boolean) request.getSession().getAttribute("product_list_has_next_page");
    boolean hasPrevPage = (boolean) request.getSession().getAttribute("product_list_has_prev_page");
    String pageLimit     = (String) request.getSession().getAttribute("product_list_page_limit");

    if(hasNextPage) {

        String nextPageIndex    = (String) request.getSession().getAttribute("product_list_next_page");
        Form.href(out, ("product/list?page_index=" + nextPageIndex + "&page_limit=" + pageLimit), "Next Page");
    }

    if(hasPrevPage) {

        String prevPageIndex    = (String) request.getSession().getAttribute("product_list_prev_page");
        Form.href(out, ("product/list?page_index=" + prevPageIndex + "&page_limit=" + pageLimit), "Prev Page");
    }
%>

<jsp:include page="../../components/footer.jsp"></jsp:include>