<%@ page import="model.Company" %>
<%@ page import="utils.SessionUtils" %>
<%@ page import="static utils.SessionUtils.isCompanyConnected" %>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
      integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

<% Company company = SessionUtils.getCompanyFromSession(request); %>

<nav class="navbar navbar-inverse navbar-fixed-top">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-nav-demo"
                aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="/company/landing/companyLandingPage.jsp" class="navbar-brand"><span
                class="glyphicon glyphicon-picture"></span> <%= company.getName() %>
        </a>
    </div>

    <div class="collapse navbar-collapse" id="bs-nav-demo">
        <ul class="nav navbar-nav">
            <li><a href="/company/landing/companyLandingPage.jsp">Home</a></li>
            <li><a href="/company/analytics/generalAnalytics.jsp">Analytics</a></li>
            <li><a href="/company/companyUtilizingPoints/utilizePoints.jsp">Utilize Points</a></li>
            <li><a href="/company/settings/companySettingsPage.jsp">Settings</a></li>
            <li><a href="/company/help/help.jsp">Help</a></li>
        </ul>
        <form action="/logout">
            <input type="submit" class="btn btn-danger pull-right" value="logout" style="margin-top: 10px;margin-right: 10px;">
        </form>
    </div>

</nav>
