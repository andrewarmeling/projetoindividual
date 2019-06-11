package projetoindividual.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("about")
public class About {

	@GET
	public String version() {
		return "v1.0";
	}
}
