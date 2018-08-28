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
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-2.1.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>Products Quick View</title>
</head>
<body style="padding-top: 65px; ">
<%@ include file="../../common/navbar.jsp" %>
<div class="container">
    <%--<%Company company = MongoInteractor.getInstance().getCompanyByName(request.getParameter("companyName"));%>--%>
    <%--for debug only!--%>
    <%Company company = MongoInteractor.getInstance().getCompanyByName("Test Company");%>

    <%@include file="offerUserGrid.jsp" %>
</div>
</body>
</html>
