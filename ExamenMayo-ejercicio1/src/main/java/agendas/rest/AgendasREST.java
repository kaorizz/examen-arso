package agendas.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import agendas.dominio.Agenda;
import agendas.dto.AgendaDTO;
import agendas.dto.CitaDTO;
import agendas.servicio.IServicioAgendas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import repositorio.EntidadNoEncontrada;

@RestController
@RequestMapping("/agendas")
@Tag(name = "Agendas", description = "Controlador para trabajar con Agendas")
public class AgendasREST {

	private IServicioAgendas servicio;

	@Autowired
	public AgendasREST(IServicioAgendas servicio) {
		this.servicio = servicio;
	}

	// crearAgenda
	// POST

	@Operation(summary = "Creación de una agenda", description = "Crear una nueva agenda")
	@PostMapping("")
	public ResponseEntity<Void> crearAgenda() {
		String idAgenda = servicio.crearAgenda();
		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idAgenda).toUri();
		return ResponseEntity.created(nuevaURL).build();
	}

	// recuperarAgenda
	// GET
	@Operation(summary = "Recuperación de una agenda", description = "Recuperar una agenda")
	@GetMapping("/{id}")
	public AgendaDTO recuperarAgenda(@PathVariable String id) throws EntidadNoEncontrada {
		Agenda agenda = servicio.recuperarAgenda(id);
		AgendaDTO agendaDTO = agenda.toDTO();
		return agendaDTO;
	}

	// addCita
	// POST
	@Operation(summary = "Adición de una cita", description = "Añadir una cita a una agenda")
	@PostMapping("/{idAgenda}/citas")
	public ResponseEntity<Void> addCita(@PathVariable String idAgenda, @RequestBody(required = true) CitaDTO citaDTO)
			throws EntidadNoEncontrada {
		servicio.añadirCita(idAgenda, citaDTO.getDescripcion(), citaDTO.getInicio(), citaDTO.getDuracion());
		return ResponseEntity.noContent().build();
	}

	// eliminarAgenda
	// DELETE
	@Operation(summary = "Eliminación de una agenda", description = "Eliminar una agenda")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAgenda(@PathVariable String id) throws EntidadNoEncontrada {
		servicio.eliminarAgenda(id);
		return ResponseEntity.noContent().build();
	}
}