$(document).ready(function(){
	
	
	$('#prazo').datepicker({
		uiLibrary: 'bootstrap4',
		locale: 'pt-br',
		format: 'dd/mm/yyyy'
	});
	$('#dataInicio').datetimepicker({
		uiLibrary: 'bootstrap4',
		locale: 'pt-br',
		format: 'dd/mm/yyyy - HH:MM'
	});
	$('#dataFim').datetimepicker({
		uiLibrary: 'bootstrap4',
		locale: 'pt-br',
		format: 'dd/mm/yyyy - HH:MM'
	});

});

function salvarOs() {
	var dados = coletarDadosFormulario();
	if(validarCampos()) {
		var dados = coletarDadosFormulario();
		$.ajax({
			url: '../api/ordemDeServico' + dados.numeroOs,
			type: 'PUT',
			data: JSON.stringify(dados),
			contentType: 'application/json; charset="utf-8"',
			dataType: 'json',
			success: function (data) {
				console.log("ok");
			},
			error: function (data) {
				console.log("falha ao salvar OS");
			}
		});
	} else {
		console.log("erro ao salvar OS");
	}
}

function validarCampos() {
	//impedir que formulário salve sem status selecionados
	//impedir desconto maior que valores
}

function coletarDadosFormulario() {
	var dados = {
		tipoEquipamento: $('#tipo').val(),
		senhaEquipamento: $('#senha').val(),
		condicoesEquipamento: $('#condicoes').val(),
		marcaEquipamento: $('#marca').val(),
		corEquipamento: $('#cor').val(),
		modeloEquipamento: $('#modelo').val(),
		serialEquipamento: $('#serial').val(),
		solicitacao: $('#solicitacao').val(),
		observacoesInternas: $('#observacoes').val(),
		statusOs: $('#statusOs').val(),
		statusAprovacao: $('#statusAprovacao').val(),
		prazoEstimado: $('#prazo').val(),
		descricaoServicos: $('#servico').val(),
		dataInicio: $('#dataInicio').val(),
		dataFim: $('#dataFim').val(),
		valorServico: $('#valorServico').val(),
		desconto: $('#desconto').val(),
		acrescimo: $('#acrescimo').val()
	}
	
	return dados;
}