var API = {
    get: function (url, body, onSuccess) {
        $.ajax({
            method: "GET",
            url: '/api/' + url,
            dataType: "json",
            data: body,
            success: function (data) {
                if(data.status === 'error'){
                    console.log(data.message)
                    return
                }
                onSuccess(data);
            },

        }).fail(function (err) {
            console.log(err)
        });
    },

    post: function (url, body, onSuccess) {
        console.log("post is being made ...")
        $.ajax({
            method: "POST",
            url: '/api/' + url,
            dataType: "json",
            data: body,
            success: function (data) {
                if(data.status === 'error'){
                    console.log(data.message)
                    return
                }
                onSuccess(data);
            },
        }).fail(function (err) {
            console.log(err)
        });
    }
};