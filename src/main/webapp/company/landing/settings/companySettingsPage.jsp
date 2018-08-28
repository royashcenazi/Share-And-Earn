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
    <link rel="stylesheet" href="../companyLandingPage.css">
    <link rel="stylesheet" href="companySettingsPage.css">

    <% Company company = SessionUtils.getCompanyFromSession(request); %>
    <title>Settings</title>
</head>
<body>
<%@ include file="../../common/navbar.jsp" %>

<div class="container">

    <div id="headlineDiv">
        <i id="settingsLogo" class="fas fa-sliders-h fa-9x"></i>
        <h1>Settings</h1>
    </div>

    <div id="editDiv">
        <label for="phone">Phone number: </label>
        <p id="Phone" class="form-control" contenteditable="true"><%=company.getPhoneNumber()%></p>
        <label for="address">Adress: </label>
        <p id="address" class="form-control" contenteditable="true"><%=company.getAddress()%></p>
        <label for="email">Email: </label>
        <p id="email" class="form-control" contenteditable="true"><%=company.getEmail()%></p>
        <textarea id="about" class="form-control" name="about" cols="40" rows="7"
                  placeholder="About ..."><%=company.getAbout()%></textarea>
        <button type="button" class="btn btn-success form-control" data-dismiss="modal" onclick="companySettingSubmit()">Save</button>
        <input id="companyName" type="hidden" name="companyName" value="<%=company.getName()%>">
    </div>

    <%--<div id="editDiv" class="form-group">--%>
    <%--<form id="uploadOfferForm" action="/companySettings">--%>
    <%--<input id="phone" class="form-control" type="number" placeholder="Phone number" name="phone">--%>
    <%--<input id="address" class="form-control" type="text" placeholder="Address" name="address">--%>
    <%--<input id="email" class="form-control" type="email" placeholder="Email" name="email">--%>
    <%--<input id="psw" class="form-control" type="password" placeholder="Password (Required)" name="psw" required>--%>
    <%--<input id="psw-repeat" class="form-control" type="password" placeholder="Repeat Password (Required)"--%>
    <%--name="psw-repeat"--%>
    <%--oninput="validateRepeatPassword(this)" required>--%>
    <%--<input id="newPsw" class="form-control" type="password" placeholder="New Password (Optional)" name="newPsw">--%>
    <%--<textarea id="about" class="form-control" name="about" cols="40" rows="7"--%>
    <%--placeholder="About ..."></textarea>--%>
    <%--<button type="submit" class="btn btn-success form-control" data-dismiss="modal">Submit</button>--%>
    <%--</form>--%>
    <%--</div>--%>

</div>

<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/common/js/utils.js"></script>
</body>
</html>
