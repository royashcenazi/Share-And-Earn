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
            <a href="./companyLandingPage.jsp" class="navbar-brand"><span class="glyphicon glyphicon-picture"></span> <%= companyFromSession.getName() %>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-nav-demo">
            <ul class="nav navbar-nav">
                <li><a href="/index.html">Home</a></li>
                <li><a href="./about.jsp">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="./companySettingsPage.jsp">Settings</a></li>
            </ul>
        </div>
    </div>
</nav>