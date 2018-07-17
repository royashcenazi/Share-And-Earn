var refreshRate = 200; //mili seconds
var USERINFO_URL = buildUrlWithContextPath("userInfo");
var picture_url = "https://localhost:8443/getAllPictures";

//activate the timer calls after the page is loaded
$(function () {

    //prevent IE from caching ajax calls
    $.ajaxSetup({cache: false});

    setUserInfo();
    getAllPictures();

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


function getAllPictures() {
    $.ajax({
        url: picture_url,
        datatype: 'json',
        success: function (data) {
            var element = $("div.thumbnail")[0];
            if (data) {
                companisPictures = $.parseJSON(data);
                var i = 0;
                for (var url in companisPictures)
                {
                    var divCol = document.createElement("img");
                    divCol.addClass("col-lg-4 col-sm-6");
                    divCol.addClass("thumbnail");
                    var img = document.createElement("img");
                    img.src = "../" + companisPictures[url]
                    element.appendChild(img);
                    if (i % 4 == 0)
                    {
                        var divRow = document.createElement("div");
                        divRow.addClass("row");
                    }

                    i++;
                }

            }
        }
    });
}