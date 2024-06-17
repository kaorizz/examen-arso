package cliente.eventos;

public class EventoAñadirCita {

	private String idAgenda;
	private String descripcion;
	private String inicio;
	private int duracion;
	
	public EventoAñadirCita(String idAgenda, String descripcion, String inicio, int duracion) {
		this.idAgenda = idAgenda;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.duracion = duracion;
	}
	
	public String getIdAgenda() {
		return idAgenda;
	}
	
	public void setIdAgenda(String idAgenda) {
		this.idAgenda = idAgenda;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getInicio() {
		return inicio;
	}
	
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}	
}
