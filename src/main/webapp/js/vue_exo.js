$(function () {
    var path = window.location.pathname;
    var splittedPath = path.split("/");
    var splitLength = splittedPath.length
    var idExercice = splittedPath[splitLength - 1]
    var idCours = splittedPath[splitLength - 2]
    var nbErrorExo2 = 0
    var nbErrorExo3 = 0
    $(".precedent-exercice").click(function () {
        window.location = "/exercice/cours/" + idCours;
    })

    $("#vue-exo2").click(function () {
        $(".card-panel").removeClass("show");
        var answer = $('.user-input').val();
        if(answer == null || answer.trim()===''){
            return;
        }
        API.post("/api/vuejs/exercice2",{
            answer
        },function (data) {
            console.log(data.message)
            console.log(data.contenu)
            if(data.contenu === "done")
            {
                $(".card-panel.teal span").html(data.message);
                $("#m2").addClass("show");
                $("button").css("display","none")
                $('.after-answer').css("display","block")
                API.post("/exercice/done/"+idExercice,{},function () {

                })
            }
            else if(data.contenu === "almost"){
                API.get("/exercice/getchapitre/" + idExercice,{},function (chap) {
                    if(nbErrorExo2>2)
                        $(".card-panel.orange span").html(data.message + "<a href=\"/chapitre/contenu/"+idCours+"/" + chap.contenu + "\"> Vous pouvez consultez le cours içi.</a>");
                    else
                        $(".card-panel.orange span").html(data.message)
                    $("#m3").addClass("show");
                })
                console.log(data.message)

            }else {
                API.get("/exercice/getchapitre/" + idExercice,{},function (chap) {
                    if(nbErrorExo2 > 2)
                        $(".card-panel.red span").html(data.message + "<a href=\"/chapitre/contenu/"+idCours+"/" + chap.contenu + "\"> Vous pouvez consultez le cours içi.</a>");
                    else
                        $(".card-panel.red span").html(data.message);
                    $("#m1").addClass("show");
                })
            }
            nbErrorExo2++;
        })

    });

    $("#vue-exo3").click(function () {
        $(".card-panel").removeClass("show");
        var answer = $('#answer')[0].innerText;
        console.log("iciii", answer);
        var path = window.location.pathname;
        var splittedPath = path.split("/");
        var splitLength = splittedPath.length
        var idExercice = splittedPath[splitLength - 1]
        var idCours = splittedPath[splitLength - 2]
        console.log(splittedPath)
        console.log(idCours)
        if(answer == null || answer.trim()===''){
            return;
        }
        API.post("/api/vuejs/exercice3",{
            answer
        },function (data) {
            console.log(data.message)
            console.log(data.contenu)
            if(data.contenu === "done")
            {

                $(".card-panel.teal span").html(data.message);
                $("#m2").addClass("show");
                $("button").css("display","none")
                $('.after-answer').css("display","block")
                API.post("/exercice/done/"+idExercice,{},function () {

                })
            }
            else if(data.contenu === "almost"){
                API.get("/exercice/getchapitre/" + idExercice,{},function (chap) {
                    if(nbErrorExo3 > 2)
                        $(".card-panel.orange span").html(data.message + "<a href=\"/chapitre/contenu/"+idCours+"/" + chap.contenu + "\"> Vous pouvez consultez le cours içi.</a>");
                    else
                        $(".card-panel.orange span").html(data.message)
                    $("#m3").addClass("show");
                })
            }else {
                API.get("/exercice/getchapitre/" + idExercice,{},function (chap) {
                    if(nbErrorExo3 > 2)
                        $(".card-panel.red span").html(data.message + "<a href=\"/chapitre/contenu/"+idCours+"/" + chap.contenu + "\"> Vous pouvez consultez le cours içi.</a>");
                    else
                        $(".card-panel.red span").html(data.message);
                    $("#m1").addClass("show");
                })
            }
            nbErrorExo3++;
        })

    });
});


