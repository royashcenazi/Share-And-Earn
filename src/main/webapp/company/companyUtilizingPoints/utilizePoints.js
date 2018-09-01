var code = document.getElementById("share-code");
var inputPoints = document.getElementById("points");
var submitButton = document.getElementById("btnSubmit");
var url = "https://localhost:8443/utilizePoints";

submitButton.addEventListener("click", function () {
    if (code.value != '' && inputPoints.value != '') {
        $.ajax({
            url: url,
            type: 'post',
            data: {"code": code.value, "inputPoints": inputPoints.value},
            success: function (response) {
                var json = JSON.parse(response)
                if (response.success === true)
                    alert("points utilized!");
                else
                    alert("an error occcured, points were not utilized.");
            }
        });
    }


});
