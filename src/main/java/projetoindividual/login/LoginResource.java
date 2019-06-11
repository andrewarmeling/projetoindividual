package projetoindividual.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import projetoindividual.usuarios.Usuario;

@Path("login")
public class LoginResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario) {
		
//		Usuario usuario = new Gson().fromJson(credenciais, Usuario.class);
//		System.out.println(usuario);
		
		System.out.println(usuario.getLogin() + usuario.getSenha());
		
		return null;
	}

}
