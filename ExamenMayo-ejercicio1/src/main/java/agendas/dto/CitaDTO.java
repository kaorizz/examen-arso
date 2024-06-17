package agendas.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Cita", description = "Información sobre una cita")
public class CitaDTO {
	
	@Schema(description = "Descripción de una cita")
	private String descripcion;
	@Schema(description = "Inicio de una cita")
	private LocalDateTime inicio;
	@Schema(description = "Duración de una cita")
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
