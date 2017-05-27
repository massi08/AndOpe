$(document).ready(function () {
    console.log("login.js loading ...")
    $("#login").click(function () {
        var user = $('#user').val();
        console.log(user)
        var password = $('#password').val();
        console.log(password)
        if (user.trim() === '' || password.trim() === '') {
            return;
        }
        var request = $.ajax({
            method: "POST",
            url: "http://localhost:9999/api/login",
            dataType: "json",
            data: {
                user: user,
                password: password
            }
        });
        request.done(function (msg) {
            console.log(msg)
            //window.location = '/cours/vuejs/exercice/2'
        });
        request.fail(function (jqXHR, textStatus) {
            Materialize.toast("Echec de la connexion", 4000);
        });
    });
});