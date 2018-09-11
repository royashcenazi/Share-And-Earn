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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
    <script src="/common/js/utils.js"></script>
    <script src="analytics.js"></script>
</head>
<body style="padding-top: 70px;">
<jsp:include page="/company/common/navbar.jsp"/>
<div class="col-md-5" style="margin: 0 auto;">
    <canvas id="myChart"></canvas>
</div>
<%
    List<String> products = new ArrayList<String>();
    for (Offer offer : company.getOffers()) {
        products.add(offer.getProductName());
    }
%>
<script>
    var productNames = [];
    <%
    for (String product : products) {
        %>
    productNames.push("<%=product%>");

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