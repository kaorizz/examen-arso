package propietarios.dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import propietarios.dto.AgendaDTO;
import propietarios.dto.CitaDTO;

@SuppressWarnings("serial")
public class Agenda implements Serializable {

	@BsonId
	@BsonRepresentation(BsonType.OBJECT_ID)
	private String id;
	private List<Cita> citas;
	private Propietario propietario;
	
	public Agenda() {
		this.citas = new LinkedList<Cita>();
	}
	
	public Agenda(String id, List<Cita> citas, Propietario propietario) {
		this.id = id;
		this.citas = citas;
		this.propietario = propietario;
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
	
	public Propietario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
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
