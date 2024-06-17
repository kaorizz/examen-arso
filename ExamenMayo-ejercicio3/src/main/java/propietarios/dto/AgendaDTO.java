package propietarios.dto;

import java.util.List;

public class AgendaDTO {

	private String id;
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
