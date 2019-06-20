package projetoindividual.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import projetoindividual.usuarios.Usuario;
import projetoindividual.util.ConversorBase64;
import projetoindividual.util.ConversorMD5;

@Path("/login")
public class LoginResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario) {

		String retorno = "";
		
		try {
			ConversorBase64 b64 = new ConversorBase64();
			ConversorMD5 md5 = new ConversorMD5();
			usuario.setSenha(md5.paraMD5(b64.paraString(usuario.getSenha())));
			
			LoginDAO dao = new LoginDAO();
			if (dao.validarLogin(usuario.getLogin(), usuario.getSenha())) {
				retorno = "{\"url\": \"app/\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.ok(retorno).build();
	}

}
