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
<body style="padding-top: 70px; padding-bottom: 40px;">
<jsp:include page="/company/common/navbar.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-6" style="margin: 0 auto;">
            <label>Current Amount Of Publishers</label><br>
            <canvas id="currentPublishersChart"></canvas>
        </div>

        <div class="col-md-6" style="margin: 0 auto;">
            <label>Maximum Amount Of Publishers</label><br>
            <canvas id="maxPublishersChart"></canvas>
        </div>
    </div>

    <br>
    <br>

    <div class="row">
        <br>
        <div class="col-md-6" style="margin: 0 auto;">
            <label>Points Worthy</label><br>
            <canvas id="pointWorthChart"></canvas>
        </div>
        <div class="col-md-6" style="margin: 0 auto;">
            <label>Current VS Maximum Amount Of Publishers</label><br>
            <canvas id="maxVsCurrentPublishersChart"></canvas>
        </div>
    </div>
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

    var numOfPoints = [];
    var cplegend = '# of Current Publishers';
    <%
    for (Offer offer : company.getOffers()) {
        %>
    numOfPoints.push(<%=offer.getPoints()%>);
    <%}%>


    var maxPublishers = [];
    <%
    for (Offer offer : company.getOffers()) {
        %>
    maxPublishers.push(<%=offer.getMaxPublishers()%>);
    <%}%>

    <%--Bar Chart--%>
    var ctx = document.getElementById("currentPublishersChart").getContext('2d');
    populateBarChart(ctx, productNames, currentPublishers, cplegend);

    <%--Pie Chart--%>
    var ctx2 = document.getElementById("pointWorthChart").getContext('2d');
    populatePieChart(ctx2, productNames, numOfPoints);

    var ctx3 = document.getElementById("maxPublishersChart").getContext('2d');
    populatePieChart(ctx3, productNames, maxPublishers);

    var ctx4 = document.getElementById("maxVsCurrentPublishersChart").getContext('2d');
    populateLineChart(ctx4, productNames, maxPublishers, currentPublishers, 'Maximum Publishers', 'Current Publishers');

</script>

<%@ include file="../../common/jsp/footer.jsp" %>
</body>
</html>