$(function () {
    $("#sortable").sortable();
    $("#submit-drag").click(function () {
        $(".card-panel").removeClass("show");
        var sortedIDs = $("#sortable").sortable("toArray");
        var messages = new Array();
        API.get("/exercice/qcm/message",{},function (data) {
            messages = JSON.parse(data)
        })
        console.log(messages)
        for (var i = 0; i < sortedIDs.length; i++) {
            if (i + 1 !== parseInt(sortedIDs[i])) {
                console.log(messages[parseInt(sortedIDs[i])]);
                $(".card-panel.red .white-text span").html(messages[parseInt(sortedIDs[i])]);
                $(".card-panel.red").addClass("show");
                return;
            }
        }
        $(".card-panel.teal").addClass("show");
    });
});


