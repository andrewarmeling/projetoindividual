package projetoindividual.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Reescrever e padronizar todas as requisições e respostas
// Implementar chamadas rest de alteração e exclusão para chamar por ID

@Path("clientes")
public class ClienteResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirCliente(Cliente cliente) {		
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.inserirCliente(cliente);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}	
	
	//Esse método tá muito feio
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCliente(@QueryParam("id") String id, @QueryParam("cpf") String cpf, @QueryParam("nome") String nome) {
		try {
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			if (id != null) {
				cliente.setId(id);
				cliente = dao.buscarPorId(cliente);
			}
			if (cpf != null) {
				cliente.setCpf(cpf);
				cliente = dao.buscarPorCpf(cliente);
			}
			if (nome != null) {
				List<Cliente> listaDeClientes = new ArrayList<Cliente>();
				listaDeClientes = dao.buscarPorNome(nome);
				return Response.ok().entity(listaDeClientes).build();
			}
			return Response.ok().entity(cliente).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirCliente(Cliente cliente) {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.excluirCliente(cliente);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modificarCliente(Cliente cliente) {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.modificarCliente(cliente);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
