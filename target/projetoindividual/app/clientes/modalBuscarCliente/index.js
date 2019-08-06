$('#modal').on('shown.bs.modal', function(){
	buscarPorNome(function(dados){
		$('#tabela').DataTable({
			"ajax": dados,
			"columns": [
				{"data": "ID"},
				{"data": "Nome"},
				{"data": "CPF"}
			]
		});
	});
});