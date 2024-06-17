package agendas.eventos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agendas.servicio.IServicioAgendas;
import repositorio.EntidadNoEncontrada;

@Component
public class ProcesadorEventos implements IProcesadorEventos {

	private IServicioAgendas servicio;
	
	@Autowired
	public ProcesadorEventos(IServicioAgendas servicio) {
		this.servicio = servicio;
	}
	
	@Override
	public void procesarAgregarCita(String idAgenda, String descripcion, String inicio, int duracion) throws EntidadNoEncontrada {
        servicio.añadirCita(idAgenda, descripcion, LocalDateTime.parse(inicio, DateTimeFormatter.ISO_DATE_TIME), duracion);
	}
}
