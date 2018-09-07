var finishUploadImg = false;

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

window.onload = function () {
    setFileUploadHandler();
}

function goBack() {
    window.history.back()
}

//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
let FILEUPLOAD_INDEX = 2;

$(".next").click(function () {
    if (!$("form")[0].checkValidity()) {
        $(':submit').click(); // "Submit" the Form for the 'Please fill all form before submit msg'
    } else {
        // Go to next step
        current_fs = $(this).parent();
        if (current_fs.index() !== FILEUPLOAD_INDEX || finishUploadImg) {
            if (animating) return false;
            animating = true;
            next_fs = current_fs.next();
            //activate next step on progressbar using the index of next_fs
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
            //show the next fieldset
            next_fs.show();
            //hide the current fieldset with style
            current_fs.animate({opacity: 0}, {
                step: function (now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale current_fs down to 80%
                    scale = 1 - (1 - now) * 0.2;
                    //2. bring next_fs from the right(50%)
                    left = (now * 50) + "%";
                    //3. increase opacity of next_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({
                        'transform': 'scale(' + scale + ')',
                        'position': 'absolute'
                    });
                    next_fs.css({'left': left, 'opacity': opacity});
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                //this comes from the custom easing plugin
                easing: 'easeInOutBack'
            });
        }
    }
});

$(".previous").click(function () {
    if (animating) return false;
    animating = true;

    current_fs = $(this).parent();
    previous_fs = current_fs.prev();

    if (current_fs.index() > 1) {
        //de-activate current step on progressbar
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
        //show the previous fieldset
        previous_fs.show();
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function (now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale previous_fs from 80% to 100%
                scale = 0.8 + (1 - now) * 0.2;
                //2. take current_fs to the right(50%) - from 0%
                left = ((1 - now) * 50) + "%";
                //3. increase opacity of previous_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({'left': left});
                previous_fs.css({'transform': 'scale(' + scale + ')', 'opacity': opacity});
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    }
});

$("#file-upload");