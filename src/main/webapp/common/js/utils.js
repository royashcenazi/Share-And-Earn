var CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/shareandearn/upload'
var CLOUDINARY_UPLOAD_PRESET = 'odpbbrff';



function sendJsonSoServer(json, url, callbackFunction) {
    $.ajax({
        type: "POST",
        url: url,
        data: json,
        datatype: 'json',
        success: function (data) {
            if (typeof callbackFunction !== undefined) {
                var dataJson = JSON.parse(data);
                callbackFunction(dataJson);
            }
        }
    });
}

function uploadImgAndSendUrlToServer(file, url) {
    var formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

    axios({
        url: CLOUDINARY_URL,
        method: 'POST',
        headers: {
            'content-Type': 'application/x-www-form-urlencoded'
        },
        data: formData
    }).then(function (res) {
        sendJsonSoServer(JSON.parse(res.data.secure_url), url);
    }).catch(function (err) {
        console.log(err);
    });

}