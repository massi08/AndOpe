$('input[type="radio"]').click(function () {
    $(".card-panel").removeClass("show");
    var id = $(this).attr('id');
    $("#m" + id).addClass("show");
});