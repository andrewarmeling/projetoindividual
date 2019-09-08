package projetoindividual.ordemDeServico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import projetoindividual.jdbc.Conexao;
import projetoindividual.ordemDeServico.OrdemDeServico;

public class OrdemDeServicoDAO {
	
	private Connection conexao;

	public OrdemDeServicoDAO() {
		Conexao c1 = new Conexao();
		this.conexao = c1.abrirConexao();
	}

	public String abrirOrdemDeServico(OrdemDeServico ordemDeServico) {
		try {
			String comando = "INSERT INTO ordemdeservico(";
			String comando2 = " VALUES(";

			if (!ordemDeServico.getIdCliente().isEmpty()) {
				comando += "idcliente";
				comando2 += "'" + ordemDeServico.getIdCliente() + "'";
			}
			if (!ordemDeServico.getTipoEquipamento().isEmpty()) {
				comando += ", tipoEquipamento";
				comando2 += ", '" + ordemDeServico.getTipoEquipamento() + "'";
			}
			if (!ordemDeServico.getMarcaEquipamento().isEmpty()) {
				comando += ", marcaEquipamento";
				comando2 += ", '" + ordemDeServico.getMarcaEquipamento() + "'";
			}
			if (!ordemDeServico.getCorEquipamento().isEmpty()) {
				comando += ", corEquipamento";
				comando2 += ", '" + ordemDeServico.getCorEquipamento() + "'";
			}
			if (!ordemDeServico.getModeloEquipamento().isEmpty()) {
				comando += ", modeloEquipamento";
				comando2 += ", '" + ordemDeServico.getModeloEquipamento() + "'";
			}
			if (!ordemDeServico.getSerialEquipamento().isEmpty()) {
				comando += ", serialEquipamento";
				comando2 += ", '" + ordemDeServico.getSerialEquipamento() + "'";
			}
			if (!ordemDeServico.getSolicitacao().isEmpty()) {
				comando += ", solicitacao";
				comando2 += ", '" + ordemDeServico.getSolicitacao() + "'";
			}
			if (!ordemDeServico.getCondicoesEquipamento().isEmpty()) {
				comando += ", condicoesEquipamento";
				comando2 += ", '" + ordemDeServico.getCondicoesEquipamento() + "'";
			}
			if (!ordemDeServico.getSenhaEquipamento().isEmpty()) {
				comando += ", senhaEquipamento";
				comando2 += ", '" + ordemDeServico.getSenhaEquipamento() + "'";
			}
			if (!ordemDeServico.getObservacoesInternas().isEmpty()) {
				comando += ", observacoesInternas";
				comando2 += ", '" + ordemDeServico.getObservacoesInternas() + "'";
			}

			comando += ")" + comando2 + ");";
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate(comando);
			
			ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			String numeroOS = "";
			if (rs.next()) {
				numeroOS = rs.getString(1);
			}
			
			return numeroOS;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
