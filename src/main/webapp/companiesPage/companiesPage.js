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
            var companiesLogosContainer = document.getElementById("companiesLogos");
            if (data) {
                companisPictures = $.parseJSON(data);
                var divRow = document.createElement("div");
                var i = 0;
                for (var url in companisPictures) {
                    //Create img
                    var img = document.createElement("img");
                    img.src = "../" + companisPictures[url]
                    //Create Cul
                    var divCol = document.createElement("div");
                    divCol.className = "col-lg-4 col-sm-6 thumbnail";
                    // divCol.className = "thumbnail";
                    divCol.appendChild(img);
                    if (i % 4 == 0) {
                        divRow = document.createElement("div");
                        divRow.className = "row";
                    }

                    //Append to row
                    divRow.appendChild(divCol);
                    //Append all element to outer div
                    companiesLogosContainer.appendChild(divRow);

                    i++;
                }

            }
        }
    });
}