package projetoindividual.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import projetoindividual.jdbc.Conexao;

public class LoginDAO {

	private Connection conexao;

	public LoginDAO() {
		Conexao c1 = new Conexao();
		this.conexao = c1.abrirConexao();
	}

	public boolean validarLogin(String login, String senha) {
		try {
			String comando = "SELECT login FROM usuarios WHERE login = '" + login + "' AND senha = '" + senha + "';";
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
