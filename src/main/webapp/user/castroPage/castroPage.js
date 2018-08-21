(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.12&appId=223473395065781&autoLogAppEvents=1';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


window.onload = function () {
    $(document).ready(function() {
        $('img.imgShare').click(function() {
            FB.ui({
                method: 'share',
                display: 'popup',
                href: this.src
            }, function (response) {
                $.ajax({
                    url: "/OnSharedPost",
                    type: 'POST',
                    data: {"postId": response.post_id, "companyName": "Test Company", "offerId": "1"},
                    dataType: "text",
                    success: function (data) {
                        alert(data + "\n");
                    }
                });
            });
        });
    });
};