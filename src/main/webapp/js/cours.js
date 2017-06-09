$(document).ready(function () {
    console.log("cours.js loading ...")
    API.get('/cours',
        {},
        function (response) {
            var message = JSON.parse(response.message)
            for(var i = 0; i < message.length; i++){
                console.log(JSON.parse(message[i]))
            }
            console.log(message)
    })
    $("#cours").click(function () {
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

});