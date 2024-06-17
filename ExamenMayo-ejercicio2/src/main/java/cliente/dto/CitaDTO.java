package cliente.dto;

import java.time.LocalDateTime;

public class CitaDTO {
	
	private String descripcion;
	private LocalDateTime inicio;
	private int duracion;

	public CitaDTO(String descripcion, LocalDateTime inicio, int duracion) {
		super();
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
	
	@Override
	public String toString() {
		return "CitaDTO [descripcion=" + descripcion + ", inicio=" + inicio + ", duracion=" + duracion + "]";
	}
}
