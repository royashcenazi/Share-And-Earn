<%@ page import="model.User" %>
<%@ page import="utils.SessionUtils" %>
<% User user = SessionUtils.getUserFromSession(request); %>

<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-nav-demo"aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/user/landing/userLandingPage.jsp" class="navbar-brand"><span class="glyphicon glyphicon-picture"></span> <%= user.getName() %>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="nav navbar-nav">
                <li><a href="/index.html">Home</a></li>
                <li><a href="/user/landing/userLandingPage.jsp">Offers</a></li>
                <li><a href="/user/earns/earnsPage.jsp">Earns</a></li>
                <li><a href="/user/settings/settings.jsp">Settings</a></li>
                <li><a href="/user/help/helpPage.jsp">Help</a></li>
            </ul>
        </div>
</nav>