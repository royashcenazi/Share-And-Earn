<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>

<%@ include file="/company/common/assertCompanyConnected.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Utilizing Points</title>
    <link href="https://fonts.googleapis.com/css?family=Ubuntu+Condensed" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.3.1.slim.js"
            integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
            crossorigin="anonymous"></script>
</head>

<body>
<jsp:include page="/company/common/navbar.jsp"/>
<link rel="stylesheet" type="text/css" href="utilizePoints.css">

<%Company company = SessionUtils.getCompanyFromSession(request);%>

<img src="<%=company.getLogoUrl()%>" alt="Company Logo" class="company-logo center">
<h1 class="center">Utilizing Points</h1>
<hr>

<div class="customer-details center">
    <div>
        <label>Share Code: </label>
        <input type="text" name="share-code" id="share-code">
    </div>

    <div>
        <label>Points to utilize: </label>
        <input type="text" name="points" id="points">
    </div>
    <br>

    <button type="button" class="btn btn-primary center" id="btnSubmit">Submit</button>
</div>

<script type="text/javascript" src="utilizePoints.js"></script>
<%@ include file="../../common/jsp/footer.jsp" %>
</body>
</html>