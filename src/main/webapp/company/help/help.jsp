<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/company/common/assertCompanyConnected.jsp" %>

<html>
<head>
    <title>Help</title>
    <title>Settings</title>
</head>
<body style="padding-top: 70px; padding-bottom: 45px;">
<jsp:include page="/company/common/navbar.jsp"/>
<div class="container">
    <div class="jumbotron">
        <h1><i class="fas fa-question"></i></span> Help</h1>
        <p>See what you have earned with us</p>
    </div>

    <%@ include file="../common/help_company.jsp" %>

</div>
<%@ include file="../../common/jsp/footer.jsp" %>
</body>
</html>
