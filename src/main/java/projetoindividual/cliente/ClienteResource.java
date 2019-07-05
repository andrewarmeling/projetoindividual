package projetoindividual.cliente;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("clientes")
public class ClienteResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		dao.inserirCliente(cliente);
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaPorId(@QueryParam("id") String id) {
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.buscarPorId(Integer.parseInt(id));		
		return Response.ok().entity(cliente).build();
	}
}
