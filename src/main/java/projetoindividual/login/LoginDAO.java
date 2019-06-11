package projetoindividual.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

	private Connection conexao;

	public LoginDAO(Connection conexao) {
		this.conexao = conexao;
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
