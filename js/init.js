(function ($) {
    $(function () {

        // Responsive sidebar
        $('.button-collapse').sideNav();

        // Selects
        $('select').material_select();
        
        $('.btn-submit').click(function (e) {
            $(".btn-submit").css("display", "none")
            $(".btn-reload").css("display", "block")

            setTimeout(function() {
                $(".btn-submit").css("display", "inline-block")
                $(".btn-reload").css("display", "none");
            }, 2000);
        })

        $('#exo1').click(function (e) {
            console.log("exo2")
        })

        $('#exo2').click(function (e) {
            if($('.user-input').val() === "{{message}}")
                console.log("hurray")
            else
                console.log("wrong answer")
        })
    });
})(jQuery);