package agendas.servicio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agendas.dominio.Agenda;
import agendas.dominio.Cita;
import agendas.repositorio.RepositorioAgendas;
import repositorio.EntidadNoEncontrada;

@Service
public class ServicioAgendas implements IServicioAgendas {

	private RepositorioAgendas repositorio;

	@Autowired
	public ServicioAgendas(RepositorioAgendas repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public String crearAgenda() {
		Agenda agenda = new Agenda();
		String id = repositorio.save(agenda).getId();
		return id;
	}

	@Override
	public Agenda recuperarAgenda(String idAgenda) throws EntidadNoEncontrada {
		Agenda agenda = repositorio.findById(idAgenda).get();
		if (agenda == null) {
			throw new EntidadNoEncontrada("No se encuentra una agenda con el id: " + idAgenda);
		}
		return agenda;
	}

	@Override
	public void añadirCita(String idAgenda, String descripcion, LocalDateTime inicio, int duracion)
			throws EntidadNoEncontrada {
		if (duracion <= 0 || inicio.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Los parámetros no son correctos");
		}
		Cita cita = new Cita();
		cita.setDescripcion(descripcion);
		cita.setDuracion(duracion);
		cita.setInicio(inicio);
		Agenda agenda = repositorio.findById(idAgenda).get();
		if (agenda == null) {
			throw new EntidadNoEncontrada("No se encuentra una agenda con el id: " + idAgenda);
		} else {
			agenda.addCita(cita);
			repositorio.save(agenda);
		}
	}

	@Override
	public void eliminarAgenda(String idAgenda) throws EntidadNoEncontrada {
		Agenda agenda = repositorio.findById(idAgenda).get();
		if (agenda == null) {
			throw new EntidadNoEncontrada("No se encuentra una agenda con el id: " + idAgenda);
		}
		repositorio.deleteById(idAgenda);
	}

}
