package propietarios.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import propietarios.servicio.IServicioPropietarios;

@Path("/propietarios")
@Stateless
public class PropietariosREST {

	@EJB(beanName = "ServicioPropietarios")
	private IServicioPropietarios servicioPropietarios;

	@POST
	@Path("/{usuario}/agendas/{idAgenda}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response asociarPropietarioaAgenda(@PathParam("usuario") String usuario,
			@PathParam("idAgenda") String idAgenda) {
		try {
			servicioPropietarios.asociarPropietarioaAgenda(usuario, idAgenda);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/{usuario}/agendas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgendasPropietario(@PathParam("usuario") String usuario) {
		try {
			List<String> ids = servicioPropietarios.getAgendasPropietario(usuario);
			return Response.ok(ids).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
}