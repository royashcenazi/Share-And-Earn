function setFileUploadHandler() {
    var CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/shareandearn/upload'
    var CLOUDINARY_UPLOAD_PRESET = 'odpbbrff';
    var fileUpload = document.getElementById('file-upload');

    fileUpload.addEventListener('change', function function_name(event) {
        var file = event.target.files[0];
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
            console.log(res);
        }).catch(function (err) {
            console.log(err);
        });

    });
}

window.onload = function () {
    setFileUploadHandler();
}

function goBack() {
    window.history.back()
}

function validateRepeatPassword(input) {
    if (input.value != document.getElementById('psw').value) {
        input.setCustomValidity('Password Must be Matching.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}

