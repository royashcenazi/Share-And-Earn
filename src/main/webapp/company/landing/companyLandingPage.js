$(function () {
    $("#myModal").on('shown.bs.modal', function () {
        $(".offerForm > input[type='text']").prop('disabled', true);
    });
    $(".offerForm").submit(function (e) {
        e.preventDefault();
        var url = $(this).closest('form').attr('action'),
            data = $(this).closest('form').serialize();
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            success: function () {
                alert("Form Sent!");
            }
        });
        $(".offerForm > input[type='text']").prop('disabled', true);
    });
})

function OfferEditButtonClickedEventHandler() {
    $(".offerForm > input[type='text']").prop('disabled', false);
}

function offerSaveButtonClickedEventHandler(elem) {
    $(".offerForm > input[type='text']").prop('disabled', true);
    var form = $(this).parent("modal-footer").siblings(".modal-body").children(".offerForm");
    $(elem).parent().parent().children(".offerForm").submit();
    // $(".offerForm").submit();

    var a = $(elem).parent(".modal-footer").siblings(".modal-body")[0];
    var form = $(a).children("div").children("div").children("form")[0];
    form.submit();
}