$('input[type="radio"]').click(function () {
    $(".card-panel").removeClass("show");
    var id = $(this).attr('id');
    $("#m" + id).addClass("show");
    var path = window.location.pathname;
    var splittedPath = path.split("/");
    var splitLength = splittedPath.length
    var idExercice = splittedPath[splitLength - 1]
    var idCours = splittedPath[splitLength - 2]

    if($("#m" + id + " i").html() === "done"){
        API.post("/exercice/done/"+idExercice,{},function () {

        })
    }
});