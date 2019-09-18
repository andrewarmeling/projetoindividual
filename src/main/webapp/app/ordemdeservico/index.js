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