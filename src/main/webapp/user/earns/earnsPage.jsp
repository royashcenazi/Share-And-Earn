<%@ page import="model.Earn" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 28/08/18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Earns</title>
    <script src="earnsPage.js"></script>
</head>
<body>
<%@ include file="/user/common/navbar.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h1><i class="fas fa-award"></i></span> Earns</h1>
        <p>See what you have earned with us</p>
    </div>
    <% List<Earn> earnList = user.getEarnList();
        if (earnList != null) {
            for (Earn earn : user.getEarnList()) { %>
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="..." alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title"><%=earn.getProductName()%>
            </h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </div>

    <div id="earnModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">

                <div class="modal-header">
                    <h4 class="modal-title" style="text-align: center">Earn Details</h4>
                </div>
                <div class="modal-body">
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick=" showEarnCode(<%=earn.getCode()%>)">Get Code</button>
                    <label id="earnCodeLabel" for="earnCode" hidden>Code:</label>
                    <p id="earnCode"></p>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    <% }
    } else { %>
        <h2 style="text-align: center">No earns exist </h2>
    <% } %>

</div>
</body>
</html>
