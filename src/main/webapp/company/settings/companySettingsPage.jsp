<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/company/common/assertCompanyConnected.jsp" %>

<html>
<head>
    <link rel="stylesheet" href="../landing/companyLandingPage.css">
    <link rel="stylesheet" href="companySettingsPage.css">
    <script src="/common/js/utils.js"></script>

    <% Company company = SessionUtils.getCompanyFromSession(request); %>
    <title>Settings</title>
</head>
<body>
<jsp:include page="/company/common/navbar.jsp"/>

<div class="container">

    <div id="headlineDiv">
        <i id="settingsLogo" class="fas fa-sliders-h fa-9x"></i>
        <h1>Settings</h1>
    </div>

    <div id="editDiv">
        <label for="phone">Phone number: </label>
        <p id="Phone" class="form-control" contenteditable="true"><%=company.getPhoneNumber()%>
        </p>
        <label for="address">Address: </label>
        <p id="address" class="form-control" contenteditable="true"><%=company.getAddress()%>
        </p>
        <label for="email">Email: </label>
        <p id="email" class="form-control" contenteditable="true"><%=company.getEmail()%>
        </p>
        <textarea id="about" class="form-control" name="about" cols="40" rows="7"
                  placeholder="About ..."><%=company.getAbout()%></textarea>
        <button type="button" class="btn btn-success form-control" data-dismiss="modal"
                onclick="companySettingSubmit()">Save
        </button>
        <input id="companyName" type="hidden" name="companyName" value="<%=company.getName()%>">
    </div>

</div>
</body>
</html>
