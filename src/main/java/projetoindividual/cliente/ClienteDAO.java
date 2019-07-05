package projetoindividual.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import projetoindividual.jdbc.Conexao;

public class ClienteDAO {

	private Connection conexao;

	public ClienteDAO() {
		Conexao c1 = new Conexao();
		this.conexao = c1.abrirConexao();
	}

	public boolean inserirCliente(Cliente cliente) {
		try {
			String comando = "INSERT INTO clientes(";
			String comando2 = " VALUES(";

			if (!cliente.getCpf().isEmpty()) {
				comando += "cpf";
				comando2 += "'" + cliente.getCpf() + "'";
			}
			if (!cliente.getNome().isEmpty()) {
				comando += ", nome";
				comando2 += ", '" + cliente.getNome() + "'";
			}
			if (!cliente.getApelido().isEmpty()) {
				comando += ", apelido";
				comando2 += ", '" + cliente.getApelido() + "'";
			}
			if (!cliente.getTelefonePrincipal().isEmpty()) {
				comando += ", telefonePrincipal";
				comando2 += ", '" + cliente.getTelefonePrincipal() + "'";
			}
			if (!cliente.getTelefoneSecundario().isEmpty()) {
				comando += ", telefoneSecundario";
				comando2 += ", '" + cliente.getTelefoneSecundario() + "'";
			}
			if (!cliente.getEmail().isEmpty()) {
				comando += ", email";
				comando2 += ", '" + cliente.getEmail() + "'";
			}
			if (!cliente.getCep().isEmpty()) {
				comando += ", cep";
				comando2 += ", '" + cliente.getCep() + "'";
			}
			if (!cliente.getCidade().isEmpty()) {
				comando += ", cidade";
				comando2 += ", '" + cliente.getCidade() + "'";
			}
			if (!cliente.getUf().isEmpty()) {
				comando += ", uf";
				comando2 += ", '" + cliente.getUf() + "'";
			}
			if (!cliente.getEndereco().isEmpty()) {
				comando += ", endereco";
				comando2 += ", '" + cliente.getEndereco() + "'";
			}
			if (!cliente.getComplemento().isEmpty()) {
				comando += ", complemento";
				comando2 += ", '" + cliente.getComplemento() + "'";
			}
			if (!cliente.getBairro().isEmpty()) {
				comando += ", bairro";
				comando2 += ", '" + cliente.getBairro() + "'";
			}

			comando += ")" + comando2 + ");";

			Statement stmt = conexao.createStatement();
			stmt.execute(comando);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cliente buscarPorId(int id) {
		try {
			String comando = "SELECT * FROM clientes WHERE idcliente='" + id + "';";
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);

			Cliente cliente = new Cliente();

			if (rs.next()) {
				if (rs.getString("idcliente") != null) {
					cliente.setId(rs.getString("idcliente"));
				}
				if (rs.getString("cpf") != null) {
					cliente.setCpf(rs.getString("cpf"));
				}
				if (rs.getString("nome") != null) {
					cliente.setNome(rs.getString("nome"));
				}
				if (rs.getString("apelido") != null) {
					cliente.setApelido(rs.getString("apelido"));
				}
				if (rs.getString("telefonePrincipal") != null) {
					cliente.setTelefonePrincipal(rs.getString("telefonePrincipal"));
				}
				if (rs.getString("telefoneSecundario") != null) {
					cliente.setTelefoneSecundario(rs.getString("telefoneSecundario"));
				}
				if (rs.getString("email") != null) {
					cliente.setEmail(rs.getString("email"));
				}
				if (rs.getString("cep") != null) {
					cliente.setCep(rs.getString("cep"));
				}
				if (rs.getString("cidade") != null) {
					cliente.setCidade(rs.getString("cidade"));
				}
				if (rs.getString("uf") != null) {
					cliente.setUf(rs.getString("uf"));
				}
				if (rs.getString("endereco") != null) {
					cliente.setEndereco(rs.getString("endereco"));
				}
				if (rs.getString("complemento") != null) {
					cliente.setComplemento(rs.getString("complemento"));
				}
				if (rs.getString("bairro") != null) {
					cliente.setBairro(rs.getString("bairro"));
				}

				return cliente;
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
