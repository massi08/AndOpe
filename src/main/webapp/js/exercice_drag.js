$(function () {
    $("#sortable").sortable();
    $("#submit-drag").click(function () {
        $(".card-panel").removeClass("show");
        var sortedIDs = $("#sortable").sortable("toArray");
        var messages = new Array();
        var path = window.location.pathname;
        var splittedPath = path.split("/");
        var splitLength = splittedPath.length
        var idExercice = splittedPath[splitLength - 1]
        var idCours = splittedPath[splitLength - 2]
        API.get("/exercice/drag/"+idCours+"/"+idExercice,{},function (data) {
            var dataMessage = JSON.parse(data.message)
            messages = dataMessage.answer
            for (var i = 0; i < sortedIDs.length; i++) {
                if (i + 1 !== parseInt(sortedIDs[i])) {
                    console.log(messages[parseInt(sortedIDs[i])]);
                    $(".card-panel.red .white-text span").html(messages[parseInt(sortedIDs[i])-1]);
                    $(".card-panel.red").addClass("show");
                    return;
                }
            }
            $(".card-panel.teal").addClass("show");
            API.post("/exercice/done/"+idExercice,{},function () {
                setTimeout(function () {
                    window.location = "/exercice/cours/" + idCours
                }, 3000)
            })
        })

    });
});


