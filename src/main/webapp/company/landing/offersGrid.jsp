<%@ page import="model.Offer" %>
<%@ page import="model.Company" %>
<%@ page import="utils.SessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 28/08/18
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%Company company = SessionUtils.getCompanyFromSession(request);%>
<% if (company.getOffers() != null) { %>
<% for (Offer offer : company.getOffers()) { %>
<div class="col-sm-4" style="text-align: center">
    <label>Name:</label> <%=offer.getProductName()%> <br>
    <div class="thumbnail" style="border: none;">
        <img src=<%=offer.getPictureURL()%> data-toggle="modal" data-target="#myModal<%=offer.getOfferId()%>" style="cursor: pointer">
    </div>
</div>

<div id="myModal<%=offer.getOfferId()%>" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title" style="text-align: center"><%=offer.getProductName()%></h4>
            </div>
            <div class="modal-body">
                <div style="display: flex" class="flex-container">
                    <div>
                        <img width="150px" height="150px" src=<%=offer.getPictureURL()%>>
                    </div>
                    <div style="margin-left: 20px">
                        <form class="offerForm" action="/uploadOffer">
                            <label> Time To publish: </label> <%=offer.getTimeToPublishAsString()%><br>
                            <label> Time To delete: </label> <%=offer.getTimeToDeleteAsString()%><br>
                            <label> Points:</label><p class="editable<%=offer.getOfferId()%>" style="display: inline" contenteditable="true"><%=offer.getPoints()%></p><br>
                            <label> Max num of publishers: </label> <p class="editable<%=offer.getOfferId()%>" style="display: inline" contenteditable="true"><%=offer.getMaxPublishers()%></p><br>
                            <label> Current num of publishers: </label> <p class="editable<%=offer.getOfferId()%>" style="display: inline" contenteditable="true"><%=offer.getCurrentPublisherNumber()%></p><br>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger pull-right" data-dismiss="modal">Close</button>
                <a href="/company/landing/updateOffer.jsp?offerId=<%=offer.getOfferId()%>"><button class="btn btn-warning pull-left">Update</button></a>
                <form action="/deleteOffer" method="post">
                    <input type="hidden" name="offerId" value="<%=offer.getOfferId()%>">
                    <input type="hidden" name="companyName" value="<%=company.getName()%>">
                    <input type="submit" class="btn btn-info pull-left" value="Delete" style="margin-left: 10px;">
                </form>
            </div>
        </div>

    </div>
</div>
<% }
} %>