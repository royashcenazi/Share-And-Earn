(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.12&appId=223473395065781&autoLogAppEvents=1';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function postShare(pictureUrl, offerId) {
    FB.ui({
        method: 'share',
        display: 'popup',
        href: pictureUrl
    }, function (response) {
        $.ajax({
            url: "/OnSharedPost",
            type: 'POST',
            data: {"postId": response.post_id, "companyName": $("#companyName").text(), "offerId": offerId},
            dataType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.isPosted === true) {
                    alert("you posted a valid share :)" + "\n");
                }
                else {
                    alert(json.failureReason + ":( " + "\n");
                }

            }
        });
    });
};