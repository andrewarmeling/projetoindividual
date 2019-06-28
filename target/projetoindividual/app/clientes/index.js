function clienteSubmit() {
	
	var dados = {
			cpf: $('#cpf').val(),
			id: $('#id').val(),
			nome: $('#nome').val(),
			apelido: $('#apelido').val(),
			telefonePrincipal: $('#telefoneprincipal').val(),
			telefoneSecundario: $('#telefonesecundario').val(),
			email: $('#email').val(),
			cep: $('#cep').val(),
			cidade: $('#cidade').val(),
			uf: $('#uf').val(),
			endereco: $('#endereco').val(),
			complemento: $('#complemento').val(),
			bairro: $('#bairro').val()
	}
	
	$.ajax({
		url: '/api/clientes',
		type: 'POST',
		data: JSON.stringify(dados),
		contentType: 'application/json; charset=utf-8',
		dataType: 'json',
		succes: function (data) {
			alert(data)
		}
	});
}