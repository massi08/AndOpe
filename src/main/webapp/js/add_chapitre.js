$(function () {
    $('div#froala-editor').froalaEditor({
        height: 500,
        language: 'fr'
    });

    $("#create-course").click(function () {
        var title = $('#title').val();
        var cours = $('div#froala-editor').froalaEditor('html.get');
        if (title.trim() !== '' && cours.trim !== '') {
            var cours = {
                title,
                cours
            };
            // Appel Ajax REST
            console.log(cours);
        } else {
            Materialize.toast('Veuillez remplir tous les champs', 4000);
        }
    })
});
