$("#create-course").click(function () {
    var image = $('#url').val();
    var title = $('#title').val();
    var description = $('#description').val();
    var nbExercices = $('#nbExercices').val();
    if (image == null || description == null || title == null) {
        Materialize.toast('Veuillez remplir tous les champs', 4000);
        return;
    }
    if (image.trim() === '' || description.trim() === '' || title.trim() === '') {
        Materialize.toast('Veuillez remplir tous les champs', 4000);
        return;
    }
    $.post('/cours', {
        image,
        title,
        description,
        nbExercices
    }, function (msg) {
        console.log(msg)
        window.location = "/cours"
    })
});