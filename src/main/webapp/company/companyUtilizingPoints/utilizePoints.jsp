<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>

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
<%@ include file="/company/common/navbar.jsp" %>
<link rel="stylesheet" type="text/css" href="utilizePoints.css">

<%Company company = SessionUtils.getCompanyFromSession(request);%>

<div>
    <img src="<%=company.getLogoUrl()%>" alt="Company Logo" class="company-logo center">
    <h1 class="center">Utilizing Points</h1>
    <hr>

    <div class="customer-details center">
        <div class="block">
            <label>Share Code: </label>
            <input type="text" name="share-code" id="share-code">
        </div>


        <div class="block">
            <label>Points to utilize: </label>
            <input type="text" name="points" id="points">
        </div>
        <br>

        <button type="button" class="btn btn-primary" id="btnSubmit">Submit</button>
    </div>
</div>

<script type="text/javascript" src="utilizePoints.js"></script>

</body>
</html>