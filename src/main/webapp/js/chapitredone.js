$(function () {
    var path = window.location.pathname;
    var splittedPath = path.split("/");
    var splitLength = splittedPath.length
    var idChapitre = splittedPath[splitLength - 1]
    var idCours = splittedPath[splitLength - 2]
    API.post("/chapitre/done/" + idChapitre, {}, function () {

    })

    $(".precedent-chapitre").click(function () {
        window.location = "/chapitre/cours/" + idCours;
    })
})