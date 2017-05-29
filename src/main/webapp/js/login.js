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
        API.post('/login', {
            user: user,
            password: password
        }, function (msg) {
            console.log(msg)
        })
    });
});