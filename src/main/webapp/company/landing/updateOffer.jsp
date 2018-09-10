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
        $("#offerId").val(<%=offer.getOfferId()%>);
        $("#productName").val("<%=offer.getProductName()%>");
        $("#maxPublishers").val(<%=offer.getMaxPublishers()%>);
        $("#points").val(<%=offer.getPoints()%>);
        $("#timeToDelete").prop('disabled', true);
        $("#uploadOfferForm").prop('action', "/updateOffer");
    }

    populateFields();
</script>
</body>
</html>
