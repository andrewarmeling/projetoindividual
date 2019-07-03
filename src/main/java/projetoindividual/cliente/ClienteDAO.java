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
}
