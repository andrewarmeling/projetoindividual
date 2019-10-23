$(document).ready(function(){
	
//	Verifica se há uma OS selecionada a ser carregada (uma OS fica selecionada ao buscar ou abrir)
	if($('#OSAtual').val() != "") {
		buscarOs();
		
		$('#tituloPaginaOS').html("Ordem de Serviço nº " + $('#OSAtual').val());
	}	
	
//	Innicializa os campos de seleção de Data e Hora
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
	
//	Validação de campos destinados apenas a valores numéricos
    $('.numerico').on('input', function() {
        this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
    });
});

function salvarOs() {
	var dados = coletarDadosFormulario();
	if(validarCampos()) {
		var dados = coletarDadosFormulario();
		$.ajax({
			url: '../api/ordemDeServico/' + dados.numeroOs,
			type: 'PATCH',
			data: JSON.stringify(dados),
			contentType: 'application/json; charset="utf-8"',
			dataType: 'json',
			success: function (dados) {
				atualizarCampos(dados);
			},
			error: function (dados) {
				console.log("falha ao salvar OS");
			}
		});
	} else {
		console.log("erro ao salvar OS");
	}
}

function buscarOs() {
	$.ajax({
		url: '../api/ordemDeServico/' + $('#OSAtual').val(),
		type: 'GET',
		success: function (dados) {
			atualizarCampos(dados);
			console.log("Ordem de Serviço carregada com sucesso");
		},
		error: function() {
			console.log("Erro ao buscar OS");
		}
		
	});
}

function validarCampos() {
	//impedir que formulário salve sem status selecionados
	//impedir desconto maior que valores
	
	return true;
}

function atualizarCampos(dados) {
	$('#idcliente').val(dados.idCliente);
	$('#nomeCliente').val(dados.nomeCliente);
	$('#tipo').val(dados.tipoEquipamento);
	$('#marca').val(dados.marcaEquipamento);
	$('#cor').val(dados.corEquipamento);
	$('#modelo').val(dados.modeloEquipamento);
	$('#serial').val(dados.serialEquipamento);
	$('#solicitacao').val(dados.solicitacao);
	$('#condicoes').val(dados.condicoesEquipamento);
	$('#senha').val(dados.senhaEquipamento);
	$('#observacoes').val(dados.observacoesInternas);
	$('#statusOs').val(dados.statusOs);
	$('#statusAprovacao').val(dados.statusAprovacao);
	$('#prazo').val(dados.prazoEstimado);
	$('#servico').val(dados.descricaoServico);
	$('#dataInicio').val(dados.dataInicio);
	$('#dataFim').val(dados.dataFim);
	$('#valorServico').val(dados.valorServico);
	$('#desconto').val(dados.desconto);
	$('#acrescimo').val(dados.acrescimo);
	$('#total').val(dados.total);
	
	/* Atualiza novamente a Ordem de Serviço atual, para evitar possíveis conflitos*/
	$('#OSAtual').val(dados.numeroOs);
}

function coletarDadosFormulario() {
	var dados = {
		numeroOs: $('#OSAtual').val(),	
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
		descricaoServico: $('#servico').val(),
		dataInicio: $('#dataInicio').val(),
		dataFim: $('#dataFim').val(),
		valorServico: $('#valorServico').val(),
		desconto: $('#desconto').val(),
		acrescimo: $('#acrescimo').val()
	}
	
	return dados;
}