<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Offer" %>

<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Fira+Sans:300,700" rel="stylesheet">

    <link rel="stylesheet" href="../../company/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="../../company/css/style.css"> <!-- Resource style -->
    <script src="../../company/js/modernizr.js"></script> <!-- Modernizr -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


    <title>Products Quick View</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Share&Earn</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
            </li>
        </ul>
    </div>
</nav>

<%Company company = MongoInteractor.getInstance().getCompanyByName(request.getParameter("companyName"));%>
<%--for debug only!--%>
<%--<%Company company = MongoInteractor.getInstance().getCompanyByName("Test Company");%>--%>

<p id="companyName" hidden><%=company.getName()%></p>

<ul class="photo-items photo-container">
    <!-- COMPANY'S LOGO GOES HERE -->
    <div><img src="<%=company.getLogoUrl()%>" class="company-logo"></div>
    <br>
    <div>
        <h3>About us:</h3>
        <div id="about-company">Our mission lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
            ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
    </div>
    <br>

    <%for (Offer offer : company.getOffers()) {%>

    <li class="photo-item">
        <img src="<%=offer.getPictureURL()%>" alt="Item-Preview">
        <a href="#0" class="photo-trigger">View product</a>
    </li> <!-- photo-item -->
    <%}%>

</ul> <!-- photo-items -->


<div class="photo-quick-view">

    <%for (Offer offer : company.getOffers()) {%>

    <div class="photo-slider-wrapper">
        <ul class="photo-slider">
            <li class="selected"><img src="<%=offer.getPictureURL()%>" alt="Product 1"></li>
        </ul> <!-- photo-slider -->

    </div> <!-- photo-slider-wrapper -->

    <div class="photo-item-info">
        <h2>Product Title</h2>
        <p><%=offer.toString()%>
        </p>
        <ul class="photo-item-action">
            <li>
                <button class="post" onclick="postShare('<%=offer.getPictureURL()%>', <%=offer.getOfferId()%>)">Post</button>
            </li>
        </ul> <!-- photo-item-action -->
    </div> <!-- photo-item-info -->
    <a href="#0" class="photo-close">Close</a>
    <%}%>
</div> <!-- photo-quick-view -->


<script src="../../company/js/jquery-2.1.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="../../company/js/velocity.min.js"></script>
<script src="../../company/js/main.js"></script> <!-- Resource jQuery -->
<script src="companiesProducts.js"></script>
</body>
</html>
