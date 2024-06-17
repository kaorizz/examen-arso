package agendas.dominio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import agendas.dto.AgendaDTO;
import agendas.dto.CitaDTO;

@Document(collection = "agendas")
public class Agenda {

	@Id
	private String id;
	private List<Cita> citas;
	
	public Agenda() {
		this.citas = new LinkedList<Cita>();
	}
	
	public Agenda(String id, List<Cita> citas) {
		this.id = id;
		this.citas = citas;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Cita> getCitas() {
		return citas;
	}
	
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	public void addCita(Cita cita) {
		citas.add(cita);
	}
	
	public AgendaDTO toDTO() {
		List<CitaDTO> citasDTO = new LinkedList<CitaDTO>();
		for (Cita cita : this.citas) {
			citasDTO.add(cita.toDTO());
		}
		return new AgendaDTO(id, citasDTO);
	}
	
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", citas=" + citas + "]";
	}
}
