package projetoindividual.ordemDeServico;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
			
			return Response.status(201).entity(numeroOS).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{numeroOs}")
	public Response buscarOS(@PathParam("numeroOs") int numeroOs) {
		try {
			OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
			OrdemDeServico os = dao.buscarOrdemDeServico(numeroOs);
			
			return Response.status(200).entity(os).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{numeroOs}")
	public Response atualizarOs(@PathParam("numeroOs") int numeroOs, OrdemDeServico ordemDeServico) {
		try {
			OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
			ordemDeServico = dao.atualizarOs(ordemDeServico);
			
			return Response.status(200).entity(ordemDeServico).build();
		} catch (Exception e){
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("porData/{dataInicio}/{dataFim}")
	public Response buscarPorData(@PathParam("dataInicio") String dataInicio, @PathParam("dataFim") String dataFim) {
		try {
			OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
			List<OrdemDeServico> ordens = new ArrayList<OrdemDeServico>(dao.buscarOsPorData(dataInicio, dataFim));
			
			return Response.status(200).entity(ordens).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
