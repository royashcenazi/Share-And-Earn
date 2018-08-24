<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 24/08/18
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="./companyLandingPage.css">
    <% Company company = SessionUtils.getCompanyFromSession(request); %>
    <title>About</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
    <h1>Company Details:</h1>
    <h2>Name: <%=company.getName()%></h2>
    <p><%=company.getAbout()%></p>

<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
