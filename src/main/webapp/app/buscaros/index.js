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
			buscarOs();
		}
	});
	$('#dataFim').change(function(){
		if ($('#dataFim').val().length == 10) {
			buscarOs();
		}
	});
	
//	Realiza a busca inicial
	buscarOs();
});

function buscarOs(){
	var datas = coletarDatas();
	$.ajax({
		url: '../api/ordemDeServico/porData/' + datas.dataInicio + '/' + datas.dataFim,
		type: 'GET',
		success: function (data) {
			console.log(data)
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