function loginSubmit() {
    var dados = {
        login: $('#login').val(),
        senha: btoa($('#senha').val())
    };

    $.post("app/login", JSON.stringify(dados),
        function(data, status) {
            window.location = data.url;
        }, 'json'
    );

    return false;
}