<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>

<!DOCTYPE html>
<html>
<head>
    <title>Utilizing Points</title>
</head>

<body>
<%@ include file="/company/common/navbar.jsp" %>
<%Company company = MongoInteractor.getInstance().getCompanyByName("Test Company");%>

<div>
    <img src="<%=company.getLogoUrl()%>" alt="Company Logo" class="company-logo center">
    <h1 class="center">Utilizing Points</h1>
    <hr>

    <div class="customer-details center">
        <div class="block">
            <label>Customer ID: </label>
            <input type="text" name="customer-id" id="customer-id">
        </div>


        <div class="block">
            <label>Points to utilize: </label>
            <input type="text" name="points" id="points">
        </div>
        <br>

        <button type="button" class="btn btn-primary" id="btnSubmit">Submit</button>
    </div>
</div>

<script type="text/javascript" src="companyUtilizingPoints.js"></script>

</body>
</html>