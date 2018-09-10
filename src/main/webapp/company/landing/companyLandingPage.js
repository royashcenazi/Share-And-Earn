function deleteOffer(offerId, companyName) {
    var json = {
        "offerId": offerId,
        "companyName": companyName
    };
    sendJsonSoServer(json, "/deleteOffer");

    location.replace("/company/landing/companyLandingPage.jsp");
}