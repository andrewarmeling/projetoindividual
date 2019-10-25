$(document).ready(function(){

//	Inicializa os campos de seleção de data
	$('#dataInicio').datepicker({
		uiLibrary: 'bootstrap4',
		locale: 'pt-br',
		format: 'yyyy-mm-dd'
	});
	$('#dataFim').datepicker({
		uiLibrary: 'bootstrap4',
		locale: 'pt-br',
		format: 'yyyy-mm-dd'
	});
	
//	Configura as datas para o intervalo dos últimos 7 dias
	$('#dataInicio').val(
			moment().subtract(7, 'days').format('YYYY-MM-DD')
			);
	$('#dataFim').val(
			moment().format('YYYY-MM-DD')
			);
	
//	Configura a busca para ser realizada assim que a data for mudada
	$('#dataInicio').change(function(){
		if ($('#dataInicio').val().length == 10) {
			exibirTabela();
		}
	});
	$('#dataFim').change(function(){
		if ($('#dataFim').val().length == 10) {
			exibirTabela();
		}
	});
	
//	Realiza a busca inicial
	exibirTabela();
});

function buscarOs(callback){
	var datas = coletarDatas();
	$.ajax({
		url: '../api/ordemDeServico/porData/' + datas.dataInicio + '/' + datas.dataFim,
		type: 'GET',
		success: function (dados) {
			console.log("ordens trazidas com sucesso");
			callback(dados);
		},
		error: function() {
			console.log("erro ao buscar OSs")
		}
	});
}

function coletarDatas() {
	var datas = {
			dataInicio: $('#dataInicio').val() + " 00:00:00",
			dataFim: $('#dataFim').val() + " 23:59:59"
	}
	
	return datas;
}

function exibirTabela() {
	buscarOs(function(dados){		
		$('#tabela').dataTable({
//			DataTables mantém dados de configuração mesmo quando o modal é fechado,
//			Esta opção deve limpar todos os parâmetros antes de abrir outra instância.
			destroy: true,
			data: dados,
			columns: [
				{"data": "numeroOs"},
				{"data": "nomeCliente"},
				{"data": "modeloEquipamento"},
				{"data": "total"}
			],
			searching: true,
			paging: true,
			info: false,
			select: {
				style: 'single'
			},
			language: {
//				É uma boa ideia ter este pacote de tradução disponível localmente, pois atrasa o carregamento da tabela significantemente
//				Solução provisória
				url: "https://cdn.datatables.net/plug-ins/1.10.20/i18n/Portuguese-Brasil.json"
			}
		}).on('select.dt', function(e, dt, type, indexes) {			
			$('#OSAtual').val((dt.row({selected: true}).data()).numeroOs);
			$('.conteudo').load("ordemdeservico");			
		});
	});
}