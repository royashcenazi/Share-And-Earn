<%@ page import="utils.Constants" %>
<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %>
<%@ page import="model.Offer" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 13/08/18
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% Company company = SessionUtils.getCompanyFromSession(request); %>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="./companyLandingPage.css">
</head>

<body>
<%@ include file="navbar.jsp" %>

<div class="container">

    <div class="jumbotron">
        <h1><i class="fas fa-gift"></i></span> Your offers</h1>
        <p>click on a picture to see more details</p>
        <jsp:forward page="newOffer.jsp">
        <a href="./newOffer.jsp" class="btn btn-success pull-right">New Offer</a>
    </div>
    <% if (company.getOffers() != null) { %>
    <% for (Offer offer : company.getOffers()) { %>
    <div class="col-sm-4">
        <label>Name:</label> <%=offer.getProductName()%> <br>
        <div class="thumbnail">
            <img src=<%=offer.getPictureURL()%> data-toggle="modal" data-target="#myModal">
        </div>
    </div>

    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">

                <div class="modal-header">
                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                    <h4 class="modal-title" style="text-align: center"><%=offer.getProductName()%>
                    </h4>
                </div>
                <div class="modal-body">
                    <div style="display: flex" class="flex-container">
                        <div>
                            <img width="150px" height="150px" src=<%=offer.getPictureURL()%>>
                        </div>
                        <div>
                            <form class="offerForm" action="/uploadOffer">
                                <label> Time To publish: </label> <%=offer.getTimeToPublishAsString()%><br>
                                <label> Time To delete: </label> <%=offer.getTimeToDeleteAsString()%><br>
                                <label> Points:</label> <%=offer.getPoints()%><br>
                                <label> Max num of publishers: </label> <%=offer.getMaxPublishers()%><br>
                                <label> Current num of publishers: </label> <%=offer.getCurrentPublisherNumber()%>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
    <% }
    } %>

</div>

<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="./companyLandingPage.js"></script>

</body>
</html>
