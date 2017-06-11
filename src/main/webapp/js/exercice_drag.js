$(function () {
    $("#sortable").sortable();
    $("#submit-drag").click(function () {
        $(".card-panel").removeClass("show");
        var sortedIDs = $("#sortable").sortable("toArray");

        //Remplacer par un appel AJAX
        var messages = ["beforeCreate() est appelée avant la création d'une vue",
            "beforeCreate() est appelée avant la création d'une vue",
            "created() est appelée dès que la vue est créé avant d'entamer le processus de montage",
            "beforeMount() est appelée avant le montage d'une vue",
            "mounted() est appelée une fois que la vue est montée",
            "beforeUpdate() est appelée quand un changement va arriver",
            "updated() est appelée après le changemente",
            "beforeDestroy() est appelée avant la destrution d'une vue",
            "destroyed() est appelée après la destruction d'une vue"]

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


