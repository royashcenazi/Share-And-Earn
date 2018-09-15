<%@ include file="/user/common/assertUserConnected.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="userLandingPage.css">
    <meta charset="utf-8">
    <title>Companies Page</title>
</head>
<body>
<%@ include file="/user/common/navbar.jsp" %>

<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-award"></i></span> Companies</h1>
        <p>Click on a picture to see more details.</p>
    </div>

    <%@ include file="./companiesGrid.jsp" %>
</div>

<%@ include file="../../common/jsp/footer.jsp" %>
</body>
</html>