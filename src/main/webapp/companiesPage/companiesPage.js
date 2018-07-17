var refreshRate = 200; //mili seconds
var USERINFO_URL = buildUrlWithContextPath("userInfo");
var picture_url = buildUrlWithContextPath("getAllPictures");


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


    $.ajax({
        url: picture_url,
        datatype: 'json',
        success: function (data) {
            if (data) {
                var imgSrc = $.parseJSON(data);
            }
        }
    });


var img = document.createElement("img");

img.onclick = function() {
    window.location.href = '../castroPage/castroPage.html';};

var element = $("div.thumbnail")[0];
element.appendChild(img);

}