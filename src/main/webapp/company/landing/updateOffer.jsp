<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Offer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Offer</title>
</head>
<body>
<%@ include file="./newOffer/newOffer.jsp" %>
<script>
    function populateFields() {
        <% Offer offer = SessionUtils.getCompanyFromSession(request).getOfferById(Integer.parseInt(request.getParameter("offerId"))); %>
        $("#uploadOfferForm").append($("<input type='hidden' name='offerId' value='<%=offer.getOfferId()%>' >"));
        $("#productName").val("<%=offer.getProductName()%>");
        $("#maxPublishers").val(<%=offer.getMaxPublishers()%>);
        $("#points").val(<%=offer.getPoints()%>);
        $("#timeToDelete").prop('disabled', true);
        $("#uploadOfferForm").prop('action', "/updateOffer");
        $("#file-upload").removeAttr('required');
        finishUploadImg = true;
    }

    populateFields();
</script>
</body>
</html>
