<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>

<%@ include file="/user/common/assertUserConnected.jsp" %>

<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <title>Products Quick View</title>
</head>
<body style="padding-top: 70px; ">
<%@ include file="/user/common/navbar.jsp" %>

<div class="container">
    <%Company company = MongoInteractor.getInstance().getCompanyByName(request.getParameter("companyName"));
    if(company == null){
        response.sendRedirect("/index.html");
    }
    %>

    <%@include file="userOfferGrid.jsp" %>
</div>

<div hidden id="companyName"><%=company.getName()%></div>

</body>
</html>
