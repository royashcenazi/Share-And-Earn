<!DOCTYPE html>
<html>

<% final String picture_url = "https://localhost:8443/getAllPictures"; %>

<head>
    <meta charset="utf-8">
    <title>companies Page</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-2.1.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>

<body>
<%@ include file="../common/navbar.jsp" %>

<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-award"></i></span> Companies</h1>
        <p>click on a picture to see more details</p>
    </div>

    <%@ include file="./companiesGrid.jsp" %>

</div>
</body>
</html>