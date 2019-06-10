package projetoindividual.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("version")
public class VersionReturn {

	@GET
	public String version() {
		return "v1.0";
	}
}
