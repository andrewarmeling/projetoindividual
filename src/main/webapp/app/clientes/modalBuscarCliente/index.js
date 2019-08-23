$('#modal').on('shown.bs.modal', function(){
	buscarPorNome(function(dados){		
		$('#tabela').dataTable({
			data: dados,
			columns: [
				{"data": "id"},
				{"data": "nome"},
				{"data": "cpf"}
			],
			searching: false,
			paging: false,
			info: false,
			select: {
				style: 'single'
			}
		}).on('select.dt', function(e, dt, type, indexes) {			
			atualizarCampos(dt.row({selected: true}).data());
			$('#modal').modal('hide');
		});
	});
});