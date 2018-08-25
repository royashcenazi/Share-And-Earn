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
    const CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/shareandearn/upload'
    const CLOUDINARY_UPLOAD_PRESET = 'odpbbrff';
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
        var json = {'secureUrl :': res.data.secure_url}
        sendJsonSoServer(json, url);
    }).catch(function (err) {
        console.log(err);
    });

}

function validateRepeatPassword(input) {
    if (input.value != document.getElementById('psw').value) {
        input.setCustomValidity('Password Must be Matching.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}