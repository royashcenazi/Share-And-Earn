<%@ page import="utils.Constants" %>
<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %>
<%@ page import="model.Offer" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 13/08/18
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./companyLandingPage.css">
    <script src="./companyLandingPage.js"></script>
</head>

<body>
<%@ include file="../common/navbar.jsp" %>

<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-gift"></i></span> Your offers</h1>
        <p>click on a picture to see more details</p>
        <a href="./newOffer/newOffer.jsp" class="btn btn-success pull-right">New Offer</a>
    </div>
    <% Company company = SessionUtils.getCompanyFromSession(request); %>
    <%@ include file="/company/landing/offersGrid.jsp" %>

</div>


</body>
</html>
