<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Offer" %>

<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-2.1.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>Products Quick View</title>
</head>
<body>
<%@ include file="../../common/navbar.jsp" %>

<%--<%Company company = MongoInteractor.getInstance().getCompanyByName(request.getParameter("companyName"));%>--%>
<%--for debug only!--%>
<%Company company = MongoInteractor.getInstance().getCompanyByName("Test Company");%>

<%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 28/08/18
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
      integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

<%@include file="offerUserGrid.jsp"%>

<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<%--<script src="../../../company/js/jquery-2.1.1.js"></script>--%>
<%--<script src="../../../company/js/velocity.min.js"></script>--%>
<%--<script src="../../../company/js/main.js"></script> <!-- Resource jQuery -->--%>
<%--<script src="companiesProducts.js"></script>--%>
</body>
</html>
