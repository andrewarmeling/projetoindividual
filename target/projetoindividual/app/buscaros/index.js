

function exibirModalBuscaPorNome() {
	$('#modal').load("clientes/modalBuscarCliente", function() {
		$('#modal').modal();
	});
}

function buscarPorNome(callback) {
	var dados = {
			nome: $('#cliente').val()
	}
	
	$.ajax({
		url: '../api/clientes/',
		type: 'GET',
		data: dados,
		contentType: 'application/json; charset="utf-8"',
		dataType: 'json',
		success: function(dados) {
			console.log("contatos trazidos com sucesso");
			callback(dados);
		},
		error: function(){
			console.log("erro ao buscar clientes");
		}
	});
	
}