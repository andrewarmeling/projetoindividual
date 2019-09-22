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

	public OrdemDeServico buscarOrdemDeServico(int numeroOs) {
		try {
			String comando = "SELECT "
					+ "ordemdeservico.numeroOs, "
					+ "ordemdeservico.idcliente, "
					+ "ordemdeservico.tipoEquipamento, "
					+ "ordemdeservico.marcaEquipamento, "
					+ "ordemdeservico.corEquipamento, "
					+ "ordemdeservico.modeloEquipamento, "
					+ "ordemdeservico.serialEquipamento, "
					+ "ordemdeservico.condicoesEquipamento, "
					+ "ordemdeservico.senhaEquipamento, "
					+ "ordemdeservico.solicitacao, "
					+ "ordemdeservico.observacoesInternas, "
					+ "ordemdeservico.statusOs, "
					+ "ordemdeservico.statusAprovacao, "
					+ "ordemdeservico.prazoEstimado, "
					+ "ordemdeservico.descricaoServico, "
					+ "ordemdeservico.dataInicio, "
					+ "ordemdeservico.dataFim, "
					+ "ordemdeservico.valorServico, "
					+ "ordemdeservico.desconto, "
					+ "ordemdeservico.acrescimo, "
					+ "ordemdeservico.total, "
					+ "clientes.nome "
					+ "FROM ordemdeservico "
					+ "JOIN clientes ON ordemdeservico.idcliente = clientes.idcliente "
					+ "WHERE numeroOs = '"
					+ numeroOs
					+ "';";
			
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			OrdemDeServico os = new OrdemDeServico();
			
			if (rs.next()) {
				if (rs.getString("numeroOs") != null) {
					os.setNumeroOs(rs.getString("numeroOs"));
				}
				if (rs.getString("idcliente") != null) {
					os.setIdCliente(rs.getString("idcliente"));
				}
				if (rs.getString("tipoEquipamento") != null) {
					os.setTipoEquipamento(rs.getString("tipoEquipamento"));
				}
				if (rs.getString("marcaEquipamento") != null) {
					os.setMarcaEquipamento(rs.getString("marcaEquipamento"));
				}
				if (rs.getString("corEquipamento") != null) {
					os.setCorEquipamento(rs.getString("corEquipamento"));
				}
				if (rs.getString("modeloEquipamento") != null) {
					os.setModeloEquipamento(rs.getString("modeloEquipamento"));
				}
				if (rs.getString("serialEquipamento") != null) {
					os.setSerialEquipamento(rs.getString("serialEquipamento"));
				}
				if (rs.getString("condicoesEquipamento") != null) {
					os.setCondicoesEquipamento(rs.getString("condicoesEquipamento"));
				}
				if (rs.getString("senhaEquipamento") != null) {
					os.setSenhaEquipamento(rs.getString("senhaEquipamento"));
				}
				if (rs.getString("solicitacao") != null) {
					os.setSolicitacao(rs.getString("solicitacao"));
				}
				if (rs.getString("observacoesInternas") != null) {
					os.setObservacoesInternas(rs.getString("observacoesInternas"));
				}
				if (rs.getString("statusOs") != null) {
					os.setStatusOs(rs.getString("statusOs"));
				}
				if (rs.getString("statusAprovacao") != null) {
					os.setStatusAprovacao(rs.getString("statusAprovacao"));
				}
				if (rs.getString("prazoEstimado") != null) {
					os.setPrazoEstimado(rs.getString("prazoEstimado"));
				}
				if (rs.getString("descricaoServico") != null) {
					os.setDescricaoServico(rs.getString("descricaoServico"));
				}
				if (rs.getString("dataInicio") != null) {
					os.setDataInicio(rs.getString("dataInicio"));
				}
				if (rs.getString("dataFim") != null) {
					os.setDataFim(rs.getString("dataFim"));
				}
				if (rs.getString("valorServico") != null) {
					os.setValorServico(rs.getString("valorServico"));
				}
				if (rs.getString("desconto") != null) {
					os.setDesconto(rs.getString("desconto"));
				}
				if (rs.getString("acrescimo") != null) {
					os.setAcrescimo(rs.getString("acrescimo"));
				}
				if (rs.getString("total") != null) {
					os.setTotal(rs.getString("total"));
				}
				if (rs.getString("nome") != null) {
					os.setNomeCliente(rs.getString("nome"));
				}
			}
			
			return os;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public OrdemDeServico atualizarOs(OrdemDeServico os) {
		try {
			String comando = "UPDATE ordemdeservico SET";
			
			if (!os.getTipoEquipamento().isEmpty()) {
				comando += " tipoEquipamento = '" + os.getTipoEquipamento() + "'";
			}
			if (!os.getSenhaEquipamento().isEmpty()) {
				comando += ", senhaEquipamento = '" + os.getSenhaEquipamento() + "'";
			}
			if (!os.getCondicoesEquipamento().isEmpty()) {
				comando += ", condicoesEquipamento = '" + os.getCondicoesEquipamento() + "'";
			}
			if (!os.getMarcaEquipamento().isEmpty()) {
				comando += ", marcaEquipamento = '" + os.getMarcaEquipamento() + "'";
			}
			if (!os.getCorEquipamento().isEmpty()) {
				comando += ", corEquipamento = '" + os.getCorEquipamento() + "'";
			}
			if (!os.getModeloEquipamento().isEmpty()) {
				comando += ", modeloEquipamento = '" + os.getModeloEquipamento() + "'";
			}
			if (!os.getSerialEquipamento().isEmpty()) {
				comando += ", serialEquipamento = '" + os.getSerialEquipamento() + "'";
			}
			if (!os.getSolicitacao().isEmpty()) {
				comando += ", solicitacao = '" + os.getSolicitacao() + "'";
			}
			if (!os.getObservacoesInternas().isEmpty()) {
				comando += ", observacoesInternas = '" + os.getObservacoesInternas() + "'";
			}
			if (!os.getStatusOs().isEmpty()) {
				comando += ", statusOs = '" + os.getStatusOs() + "'";
			}
			if (!os.getStatusAprovacao().isEmpty()) {
				comando += ", statusAprovacao = '" + os.getStatusAprovacao() + "'";
			}
			if (!os.getPrazoEstimado().isEmpty()) {
				comando += ", prazoEstimado = '" + os.getPrazoEstimado() + "'";
			}
			if (!os.getDescricaoServico().isEmpty()) {
				comando += ", descricaoServico = '" + os.getDescricaoServico() + "'";
			}
			if (!os.getDataInicio().isEmpty()) {
				comando += ", dataInicio = '" + os.getDataInicio() + "'";
			}
			if (!os.getDataFim().isEmpty()) {
				comando += ", dataFim = '" + os.getDataFim() + "'";
			}
			if (!os.getValorServico().isEmpty()) {
				comando += ", valorServico = '" + os.getValorServico() + "'";
			}
			if (!os.getDesconto().isEmpty()) {
				comando += ", desconto = '" + os.getDesconto() + "'";
			}
			if (!os.getAcrescimo().isEmpty()) {
				comando += ", acrescimo = '" + os.getAcrescimo() + "'";
			}
			
//			Condicionamento do valor da OS
			if (!os.getValorServico().isEmpty()) {
				int total = Integer.parseInt(os.getValorServico());
				if (!os.getDesconto().isEmpty()) {
					total -= Integer.parseInt(os.getDesconto());
				}
				if (!os.getAcrescimo().isEmpty()) {
					total += Integer.parseInt(os.getAcrescimo());
				}
				
				os.setTotal(Integer.toString(total));
			}
			
			if (!os.getTotal().isEmpty()) {
				comando += ", total = '" + os.getTotal() + "'";
			}
			
			comando += " WHERE numeroOs = " + os.getNumeroOs() + ";";
			
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate(comando);
			
			return buscarOrdemDeServico(Integer.parseInt(os.getNumeroOs()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
