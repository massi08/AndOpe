$(function () {
    $('div#froala-editor').froalaEditor({
        height: 500,
        language: 'fr'
    });

    $("#create-course").click(function () {
        var title = $('#title').val();
        var cours = $('div#froala-editor').froalaEditor('html.get');
        var path = window.location.pathname;
        var splittedPath = path.split("/");
        var splitLength = splittedPath.length
        var idCours = splittedPath[splitLength-1]
        console.log(idCours);
        if (title.trim() !== '' && cours.trim !== '') {
            var cours = {
                title,
                cours,
                idCours
            };
            API.post("/chapitre",cours,function() {
                window.location = "/chapitre/cours/" + idCours
            })
            console.log(cours);
        } else {
            Materialize.toast('Veuillez remplir tous les champs', 4000);
        }
    })
});
