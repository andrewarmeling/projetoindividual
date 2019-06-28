package projetoindividual.cliente;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("clientes")
public class ClienteResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarCliente(Cliente cliente) {
		System.out.println(cliente.getCpf());
	}
}
