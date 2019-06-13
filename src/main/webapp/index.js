function loginSubmit() {
    var dados = {
        login: $('#login').val(),
        senha: btoa($('#senha').val())
    };
    
    $.ajax({
    	url: 'app/login',
    	type: 'POST',
    	data: JSON.stringify(dados),
    	contentType: 'application/json; charset=utf-8',
    	dataType: 'json',
    	async: false,
    	success: function(data) {
    		window.location = data.url;
    	}
    });

    return false;
}