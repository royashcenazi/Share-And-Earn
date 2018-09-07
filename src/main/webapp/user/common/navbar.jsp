<%@ page import="model.User" %>
<%@ page import="utils.SessionUtils" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
      integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<%SessionUtils.getUserFromSession(request); %>

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
    <div class="navbar-header">
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#bs-nav-demo"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="/user/landing/userLandingPage.jsp" class="navbar-brand">
            <span class="glyphicon glyphicon-picture"></span>
            <%= SessionUtils.getUserFromSession(request).getName() %>
        </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-nav-demo">
        <ul class="nav navbar-nav">
            <li class="nav-item active"><a class="nav-link" href="/user/landing/userLandingPage.jsp">Home <span class="sr-only">(current)</span></a></li>
            <li class="nav-item"><a class="nav-link" href="/user/earns/earnsPage.jsp">Earns</a></li>
            <li class="nav-item"><a class="nav-link" href="/user/settings/settings.jsp" onclick="navBarLinkClickHandler(this)">Settings</a></li>
            <li class="nav-item"><a class="nav-link" href="/user/help/helpPage.jsp">Help</a></li>
        </ul>
    </div>
</nav>