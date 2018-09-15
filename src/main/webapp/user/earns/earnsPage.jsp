<%@ page import="model.Earn" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 28/08/18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/user/common/assertUserConnected.jsp" %>

<html>
<head>
    <title>Earns</title>
    <script src="earnsPage.js"></script>
</head>
<body style="padding-bottom: 40px;">
<%@ include file="/user/common/navbar.jsp" %>
<% User user = SessionUtils.getUserFromSession(request); %>
<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-award"></i></span> Earns</h1>
        <p>See what you have earned with us</p>
    </div>

    <% List<Earn> earnList = user.getEarnList();
        if (earnList != null) {
            for (Earn earn : user.getEarnList()) { %>
    <div class="col-sm-4">

        <div class="card" style="text-align:  center;">
            <img class="card-img-top" src="<%=earn.getPictureUrl()%>" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title bold"><%=earn.getProductName()%>
                </h5>
                <h6 class="card-subtitle mb-2 text-muted">Points:<%=earn.getAmount()%>
                </h6>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
                <button class="btn btn-primary" data-toggle="modal" data-target="<%="#earnmodal" + earn.getCode()%>"
                        style="background-color: #7633e2;">use
                </button>
            </div>
        </div>

    </div>

    <!-- Modal -->
    <div id="<%="earnmodal" + earn.getCode()%>" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">Earn Code</h4>
                </div>
                <div class="modal-body">
                    <strong><p class="font-weight-bold text-center">code: <%=earn.getCode()%>
                    </p></strong>
                    <p class="font-weight-bold text-center">*please show this code when you would like to use this
                        earn</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <% }
    } else { %>
    <h2 style="text-align: center">No earns exist </h2>
    <% } %>

</div>

<%@ include file="../../common/jsp/footer.jsp" %>

</body>
</html>
