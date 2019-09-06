function abrirOS() {
	if(validarCamposNecessarios()) {
		$.ajax({
			url: '../api/ordemDeServico/',
			type: 'POST',
			data: JSON.stringify(coletarDadosFormulario()),
			contentType: 'application/json; charset="utf-8"',
			dataType: 'json',
			success: function () {
				console.log("os cadastrada com sucesso")
			},
			error: function() {
				console.log("erro ao cadastrar os");
			}
		});
	}
}

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

function atualizarCampos(dados) {
	$('#id').val(dados.id);
	$('#cliente').val(dados.nome);
}


//Revisar
function validarCamposNecessarios() {
	if ($('#id').val() != null) {
		if (($('#serial').val().length > 3)) {
			if (($('#solicitacao').val().lenght > 10)){
				return true;
			} else {
				$('#solicitacao').focus();
				$('#solicitacao').select();
				return false;
			}			
		} else {
			$('#serial').focus();
			$('#serial').select();
			return false;
		}
	} else {
		$('#id').focus();
		$('#id').select();
		return false;
	};
}

function coletarDadosFormulario() {
	var dados = {
	idcliente: $('#id').val(),
	tipoEquipamento: $('#tipo').val(),
	marcaEquipamento: $('#marca').val(),
	corEquipamento: $('#cor').val(),
	modeloEquipamento: $('#modelo').val(),
	serialEquipamento: $('#serial').val(),
	solcitacao: $('#solicitacao').val(),
	condicoesEquipamento: $('#condicoes').val(),
	senhaEquipamento: $('#senha').val(),
	observacoesInternas: $('#observacoes').val()
	}
	
	return dados;
}

function limparFormulario() {
	$('#id').val("");
	$('#cliente').val("");
	$('#tipo').val("");
	$('#marca').val("");
	$('#cor').val("");
	$('#modelo').val("");
	$('#serial').val("");
	$('#solicitacao').val("");
	$('#condicoes').val("");
	$('#senha').val("");
	$('#observacoes').val("");
}