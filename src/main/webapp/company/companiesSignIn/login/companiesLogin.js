$(function () {
    // this is the id of the form
    $("#loginForm").submit(function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.
        var form = $(this);

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            datatype: 'json',
            success: function (data) {
                if (data.loginSuccess) {
                    window.location.replace(data.url)
                }
                else if (!data.companyExist) {
                    alert("Company do not exist, please signup or type an existing company name");
                } else if (!data.correctPassword) {
                    alert("Invalid password, please enter the password you have been register with");
                }
            }

        });
    });

});