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