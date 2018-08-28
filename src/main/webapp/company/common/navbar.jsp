<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %>

<% Company companyFromSession = SessionUtils.getCompanyFromSession(request); %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-nav-demo"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/company/landing/companyLandingPage.jsp" class="navbar-brand"><span class="glyphicon glyphicon-picture"></span> <%= companyFromSession.getName() %>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="nav navbar-nav">
                <li><a href="/index.html">Home</a></li>
                <li><a href="/company/landing/companyLandingPage.jsp">Offers</a></li>
                <li><a href="/company/analytics/productsAndPublishers.jsp">Analytics</a></li>
                <li><a href="/company/settings/companySettingsPage.jsp">Settings</a></li>
                <li><a href="/company/help/help.jsp">Help</a></li>
            </ul>
        </div>
    </div>
</nav>