package agendas.servicio;

import java.time.LocalDateTime;

import agendas.dominio.Agenda;
import repositorio.EntidadNoEncontrada;

public interface IServicioAgendas {

	// Método que crea una agenda
	public String crearAgenda();

	// Método para recuperar una agenda
	public Agenda recuperarAgenda(String idAgenda) throws EntidadNoEncontrada;

	// Método para añadir una cita a una agenda
	public void añadirCita(String idAgenda, String descripcion, LocalDateTime inicio, int duracion)
			throws EntidadNoEncontrada;

	// Método para eliminar una agenda
	public void eliminarAgenda(String idAgenda) throws EntidadNoEncontrada;
}