(function ($) {
    $(function () {

        /*$('.btn-submit').click(function (e) {
            $(".btn-submit").css("display", "none")
            $(".btn-reload").css("display", "block")

            setTimeout(function() {
                $(".btn-submit").css("display", "inline-block")
                $(".btn-reload").css("display", "none");
            }, 2000);
        })*/

        $('#exo1').click(function (e) {
            //$(".btn-submit").css("display", "none")
            //$(".btn-reload").css("display", "block")
            console.log("pro");
            API.post('vuejs/exercice1', {
                answer: 1
            }, function (data) {
                console.log(data);
                //$(".btn-submit").css("display", "inline-block")
                //$(".btn-reload").css("display", "none");
            })
            console.log("exo2")
        })

        $('#exo2').click(function (e) {
            //$(".btn-submit").css("display", "none")
            //$(".btn-reload").css("display", "block")
            API.post('vuejs/exercice2', {
                answer: $('.user-input').val()
            }, function (data) {
                console.log(data);
                //$(".btn-submit").css("display", "inline-block")
                //$(".btn-reload").css("display", "none");
            })
        })
    });
})(jQuery);