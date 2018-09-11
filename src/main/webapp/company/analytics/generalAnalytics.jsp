<%@ page import="model.Company" %>
<%@ page import="utils.SessionUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Offer" %><%--
  Created by IntelliJ IDEA.
  User: rashcena
  Date: 9/9/18
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/company/common/assertCompanyConnected.jsp" %>
<%Company company = SessionUtils.getCompanyFromSession(request);%>

<html>
<head>
    <jsp:include page="/company/common/navbar.jsp"/>
    <!-- JQuery -->
    <%--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.10/js/mdb.min.js"></script>
    <script src="/common/js/utils.js"></script>
    <script src="analytics.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<div class  ="col-md-5">
    <canvas id="myChart"></canvas>
</div>

<%List<String> products = new ArrayList<String>();
    for (Offer offer : company.getOffers()) {
        products.add(offer.getProductName());
    }%>
<script>
    var productNames = [];
    <%
    for (String product : products) {
        %>
        productNames.push("<%=product.toString()%>");

    <%}%>

    var currentPublishers = [];
    <%
    for (Offer offer : company.getOffers()) {
        %>
    currentPublishers.push(<%=offer.getCurrentPublisherNumber()%>);
    <%}%>
    var ctx = document.getElementById("myChart").getContext('2d');
    populateChartTable(ctx, productNames, currentPublishers);
</script>
</body>
</html>