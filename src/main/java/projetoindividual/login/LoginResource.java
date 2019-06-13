package projetoindividual.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import projetoIndividual.util.ConversorBase64;
import projetoIndividual.util.ConversorMD5;
import projetoindividual.usuarios.Usuario;

@Path("login")
public class LoginResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario) {

		ConversorBase64 conv = new ConversorBase64();
		String b64 = conv.paraBase64(usuario.getLogin());
		String senha = conv.paraString(usuario.getSenha());
		
//		ConversorBase64 conv = new ConversorBase64();
//		String decodificada = conv.paraString(usuario.getLogin());
//		ConversorMD5 conv2 = new ConversorMD5();
//		String md5 = conv2.paraMD5(decodificada);
		
		System.out.println(b64);
		System.out.println(senha);
		
		return null;
	}

}
