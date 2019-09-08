package projetoindividual.ordemDeServico;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("ordemDeServico")
public class OrdemDeServicoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response abrirOS(OrdemDeServico ordemDeServico) {
		try {
			OrdemDeServicoDAO dao = new OrdemDeServicoDAO();			
			String numeroOS = dao.abrirOrdemDeServico(ordemDeServico);
			
			return Response.ok().entity(numeroOS).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	
}
