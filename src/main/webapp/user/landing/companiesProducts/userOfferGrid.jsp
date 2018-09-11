<%@ page import="model.Offer" %>

<script src="./companiesProducts.js"></script>

<% if (company.getOffers() != null) { %>
<% for (Offer offer : company.getOffers()) { %>
<div class="col-sm-4" style="text-align: center">
    <div class="thumbnail" style="border: none;">
        <label>Name:</label> <%=offer.getProductName()%> <br>
        <img src=<%=offer.getPictureURL()%> data-toggle="modal" data-target="<%="#Modal" + offer.getOfferId()%>" style="cursor: pointer" >
    </div>
</div>

<div id="<%="Modal" + offer.getOfferId()%>" class="modal fade" role="dialog">
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
                    <div style="margin-left: 15px;">
                        <form class="offerForm" action="/uploadOffer">
                            <label> Time To publish: </label> <%=offer.getTimeToPublishAsString()%><br>
                            <label> Time To delete: </label> <%=offer.getTimeToDeleteAsString()%><br>
                            <label> Points:</label> <%=offer.getPoints()%><br>
                            <label> Max num of publishers: </label> <%=offer.getMaxPublishers()%><br>
                            <label> Current num of publishers: </label> <%=offer.getCurrentPublisherNumber()%><br>
                            <strong><p style="color: red">please use #ShareNEarn Hashtag when posting</p></strong>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success"
                        onclick="postShare('<%=offer.getPictureURL()%>', <%=offer.getOfferId()%>)">Post
                </button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<% }
} %>