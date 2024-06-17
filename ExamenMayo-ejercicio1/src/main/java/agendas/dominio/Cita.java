package agendas.dominio;

import java.time.LocalDateTime;

import agendas.dto.CitaDTO;

public class Cita {

	private String descripcion;
	private LocalDateTime inicio;
	private int duracion;

	public Cita() {
	}

	public Cita(String descripcion, LocalDateTime inicio, int duracion) {
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String texto) {
		this.descripcion = texto;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public CitaDTO toDTO() {
		return new CitaDTO(descripcion, inicio, duracion);
	}

	@Override
	public String toString() {
		return "Cita [descripcion=" + descripcion + ", inicio=" + inicio + ", duracion=" + duracion + "]";
	}
}
