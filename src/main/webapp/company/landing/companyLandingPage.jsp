<%@ page import="static utils.SessionUtils.*" %>

<%--Mandatory in each company page !!!--%>
<%@ include file="/company/common/assertCompanyConnected.jsp" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./companyLandingPage.css">
    <script src="/common/js/utils.js"></script>
    <script src="./companyLandingPage.js"></script>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<jsp:include page="/company/common/navbar.jsp"/>
<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-gift"></i></span> Your offers</h1>
        <p>click on a picture to see more details</p>
        <a href="./newOffer/newOffer.jsp" class="btn btn-success pull-right">New Offer</a>
    </div>
    <jsp:include page="/company/landing/offersGrid.jsp"/>

</div>
</body>
</html>
