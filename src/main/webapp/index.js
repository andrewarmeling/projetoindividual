function loginSubmit() {
    var dados = {
        login: $('#login').val(),
        senha: btoa($('#senha').val())
    };

    $.post("login", dados,
        function(data, status) {
            window.location = data.url;
        }
    );

    return false;
}