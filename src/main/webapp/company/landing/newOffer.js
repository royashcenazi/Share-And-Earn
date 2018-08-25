var finishUploadImg = false;

window.onload = function () {
    setFileUploadHandler();
}

function setFileUploadHandler() {
    var CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/shareandearn/upload'
    var CLOUDINARY_UPLOAD_PRESET = 'odpbbrff';
    var fileUpload = document.getElementById('file-upload');

    fileUpload.addEventListener('change', function function_name(event) {
        var spinner = $("#uploadFileSpinner");

        spinner.text("uploading ...")
        spinner.removeClass("btn-success");
        spinner.addClass("btn-warning")
        spinner.show();

        //Debugging Only
        /* $("#logoUrlInput").val("https://res.cloudinary.com/shareandearn/image/upload/v1532805917/wavhyxknhvesvrpixmfq.jpg")
                finishUploadImg = true;*/

        //UnComment Next Block for Real Use
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
            $("#logoUrlInput").val(res.data.secure_url);
            finishUploadImg = true;
            spinner.text("uploaded")
            spinner.removeClass("btn-warning")
            spinner.addClass("btn-success")
            console.log(res);
        }).catch(function (err) {
            console.log(err);
        });

    });
}

function validateFileUploaded() {
    return finishUploadImg;
}