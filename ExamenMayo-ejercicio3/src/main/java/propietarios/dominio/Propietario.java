package propietarios.dominio;

import java.util.LinkedList;
import java.util.List;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

public class Propietario {

	@BsonId
	@BsonRepresentation(BsonType.OBJECT_ID)
	private String id;
	private String usuario;
	private String password;
	private List<Agenda> agendas;

	public Propietario() {
	}

	public Propietario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		this.agendas = new LinkedList<Agenda>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public void addAgenda(Agenda agenda) {
		agendas.add(agenda);
	}
}