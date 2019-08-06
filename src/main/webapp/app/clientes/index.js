$(document).ready(function() {
//	Esconde a div qual deve ser mostrada apenas quando os dados do formulário são trazidos do back-end
	$('#botoesFormularioCarregado').hide();

//	Esconde os botões de pesquisar, quais devem aparecer apenas ao selecionar o campo pertinente
	$('.input-group-append').hide();
	
//	Validação de campos destinados apenas a valores numéricos
    $('.numerico').on('input', function() {
        this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
    });    
    
//	Pesquisar por alternativa para a solução abaixo
//    Mostra e Esconde os botões de pesquisar
	$('#cpf').focus(function() {
		$('#buscarPorCpf').show(200);
	});
	$('#cpf').focusout(function() {
		$('#buscarPorCpf').hide(400);
	});
	
	$('#id').focus(function() {
		$('#buscarPorId').show(200);
	});
	$('#id').focusout(function() {
		$('#buscarPorId').hide(400);
	});
	
	$('#nome').focus(function() {
		$('#buscarPorNome').show(200);
	});
	$('#nome').focusout(function() {
		$('#buscarPorNome').hide(400);
	});
});

function incluirCliente() {	
	if (validarCamposNecessarios()) {
		$.ajax({
			url: '../api/clientes',
			type: 'POST',
			data: JSON.stringify(coletarDadosFormulario()),
			contentType: 'application/json; charset="utf-8"',
			dataType: 'json',
			success: function () {
				console.log("cliente cadastrado com sucesso")
			},
			error: function() {
				console.log("erro ao cadastrar cliente");
			}
		});
	}
}

function buscarPorId(){	
	var dados = {
			id: $('#id').val()
	}
	
	$.ajax({
		url: '../api/clientes/',
		type: 'GET',
		data: dados,
		contentType: 'application/json; charset="utf-8"',
		dataType: 'json',
		success: function(dados) {
			atualizarCampos(dados);
			mostrarBotoesFormularioCarregado();
			console.log("contato trazido com sucesso");
		},
		error: function(){
			console.log("erro ao buscar id");
		}
	});
}

function buscarPorCpf() {
	var dados = {
			cpf: $('#cpf').val()
	}
	
	$.ajax({
		url: '../api/clientes/',
		type: 'GET',
		data: dados,
		contentType: 'application/json; charset="utf-8"',
		dataType: 'json',
		success: function(dados) {
			atualizarCampos(dados);
			mostrarBotoesFormularioCarregado();
			console.log("contato trazido com sucesso");
		},
		error: function(){
			console.log("erro ao buscar cpf");
		}
	});
}

function buscarPorNome(callback) {
	var dados = {
			nome: $('#nome').val()
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

function excluirCliente() {	
	$.ajax({
		url: '../api/clientes',
		type: 'DELETE',
		data: JSON.stringify(coletarDadosFormulario()),
		contentType: 'application/json; charset="utf-8"',
		dataType: 'json',
		success: function () {
			console.log("excluído com sucesso");
		},
		error: function () {
			console.log("erro ao excluir cliente");
		}
	})
}

function modificarCliente() {
	if (validarCamposNecessarios()) {
		$.ajax({
			url: '../api/clientes',
			type: 'PATCH',
			data: JSON.stringify(coletarDadosFormulario()),
			contentType: 'application/json; charset="utf-8"',
			dataType: 'json',
			success: function () {
				console.log("alterado com sucesso");
			},
			error: function () {
				console.log("erro ao alterar cliente");
			}
		});	
	}
}

function validarCamposNecessarios() {
	if (($('#cpf').val().length == 11) || $('#cpf').val().length == 14) {
		if (($('#nome').val().length > 5)) {
			return true;
		} else {
			$('#nome').focus();
			$('#nome').select();
		}
	} else {
		$('#cpf').focus();
		$('#cpf').select();
		return false;
	};
}

function exibirModalBuscaPorNome() {
	$('#modal').load("clientes/modalBuscarCliente", function() {
		$('#modal').modal();
	});
}

function limparFormulario() {
	$('#id').val("");
	$('#cpf').val("");
	$('#nome').val("");
	$('#apelido').val("");
	$('#telefoneprincipal').val("");
	$('#telefonesecundario').val("");
	$('#email').val("");
	$('#cep').val("");
	$('#cidade').val("");
	$('#uf').val("");
	$('#endereco').val("");
	$('#complemento').val("");
	$('#bairro').val("");
	
	mostrarBotoesFormularioLimpo();
}

function coletarDadosFormulario() {
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
	};
	
	return dados;
}

function atualizarCampos(dados) {
	$('#id').val(dados.id);
	$('#cpf').val(dados.cpf);
	$('#nome').val(dados.nome);
	$('#apelido').val(dados.apelido);
	$('#telefoneprincipal').val(dados.telefonePrincipal);
	$('#telefonesecundario').val(dados.telefoneSecundario);
	$('#email').val(dados.email);
	$('#cep').val(dados.cep);
	$('#cidade').val(dados.cidade);
	$('#uf').val(dados.uf);
	$('#endereco').val(dados.endereco);
	$('#complemento').val(dados.complemento);
	$('#bairro').val(dados.bairro);
}

function mostrarBotoesFormularioLimpo() {
	$('#botoesFormularioLimpo').show();
	$('#botoesFormularioCarregado').hide();
}

function mostrarBotoesFormularioCarregado() {
	$('#botoesFormularioLimpo').hide();
	$('#botoesFormularioCarregado').show();	
}