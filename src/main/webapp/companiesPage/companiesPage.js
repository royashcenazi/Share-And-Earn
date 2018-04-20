var refreshRate = 200; //mili seconds
var USERINFO_URL = buildUrlWithContextPath("userInfo");

//activate the timer calls after the page is loaded
$(function () {

    //prevent IE from caching ajax calls
    $.ajaxSetup({cache: false});

    setUserInfo();

});

function setUserInfo() {

    $.ajax({
        url: USERINFO_URL,
        datatype: 'json',
        success: function (data) {
            if (data) {
                userInfo = $.parseJSON(data);
                alert("Hello " + userInfo.name);
                $("#userInfo").html(userInfo.name);
            }
        }
    });
}