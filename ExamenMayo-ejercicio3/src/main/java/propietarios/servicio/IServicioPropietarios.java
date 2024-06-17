package propietarios.servicio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IServicioPropietarios {
	void asociarPropietarioaAgenda(String usuario, String idAgenda) throws Exception;

	List<String> getAgendasPropietario(String usuario) throws Exception;
}
