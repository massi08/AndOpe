$(document).ready(function () {
    console.log("login.js loading ...")
    $("#login").click(function () {
        var pseudo = $('.pseudo').val();
        var password = $('.password').val();
        if(pseudo == null || password == null) {
            return;
        }
        if (pseudo.trim() === '' || password.trim() === '') {
            return;
        }
        API.post('/login', {
            pseudo: pseudo,
            password: password
        }, function (msg) {
            console.log(msg)
            window.location = "manage_project.html"
        })
    });

    $(".user-register").click(function () {
        var pseudo = $('.pseudo').val();
        var firstname = $('.firstname').val();
        var lastname = $('.lastname').val();
        var email = $('.email').val();
        var password = $('.password').val();
        var passwordConfirm = $('.confirm_password').val();
        if(pseudo == null || password == null || passwordConfirm == null) {
            return;
        }
        if (pseudo.trim() === '' || password.trim() === '' || passwordConfirm.trim() === '') {
            return;
        }
        if(password !== passwordConfirm){
            console.log("password do not match!")
        }
        API.post('/register', {
            pseudo: pseudo,
            password: password,
            firstname: firstname,
            lastname: lastname,
            email: email
        }, function (msg) {
            console.log(msg)
            window.location = "index.html"
        })
    });
});