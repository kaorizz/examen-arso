package agendas.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Agenda", description = "Información sobre una agenda")
public class AgendaDTO {

	@Schema(description = "Identificador de la agenda")
	private String id;
	@Schema(description = "Lista de citas de la agenda")
	private List<CitaDTO> citas;

	public AgendaDTO(String id, List<CitaDTO> citas) {
		super();
		this.id = id;
		this.citas = citas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}

	public void addCita(CitaDTO cita) {
		citas.add(cita);
	}
	@Override
	public String toString() {
		return "AgendaDTO [id=" + id + ", citas=" + citas + "]";
	}
}
