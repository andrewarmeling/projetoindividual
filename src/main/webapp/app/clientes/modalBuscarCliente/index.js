$('#modal').on('shown.bs.modal', function(){
	buscarPorNome(function(dados){		
		$('#tabela').dataTable({
//			DataTables mantém dados de configuração mesmo quando o modal é fechado,
//			Esta opção deve limpar todos os parâmetros antes de abrir outra instância.
			destroy: true,
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

