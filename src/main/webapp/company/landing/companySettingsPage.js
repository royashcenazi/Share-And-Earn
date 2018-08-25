function companySettingSubmit() {
    var settings = {
        'companyName': $("#companyName").val(),
        'phone': $("#phone").val(),
        'address': $("#address").val(),
        'email': $("#email").val(),
        'about': $("#about").val()
    };
    sendJsonSoServer(settings, "/updateCompany");
    window.location.replace("/company/landing/companyLandingPage.jsp");
}