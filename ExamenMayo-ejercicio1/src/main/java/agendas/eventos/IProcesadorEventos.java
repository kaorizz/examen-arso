package agendas.eventos;

import repositorio.EntidadNoEncontrada;

public interface IProcesadorEventos {

	void procesarAgregarCita(String idAgenda, String descripcion, String inicio, int duracion) throws EntidadNoEncontrada;
}
