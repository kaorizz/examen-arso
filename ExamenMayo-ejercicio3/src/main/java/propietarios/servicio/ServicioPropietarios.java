package propietarios.servicio;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import propietarios.dominio.Agenda;
import propietarios.dominio.Propietario;
import propietarios.repositorio.RepositorioPropietariosMongoDB;
import repositorio.EntidadNoEncontrada;
import repositorio.IRepositorio;
import repositorio.RepositorioException;

@Stateless
public class ServicioPropietarios implements IServicioPropietarios {

	@EJB(beanName = "RepositorioPropietariosMongoDB")
	private RepositorioPropietariosMongoDB repositorioPropietarios;
	@EJB(beanName = "RepositorioAgendasMongoDB")
	private IRepositorio<Agenda, String> repositorioAgendas;
	
	public void asociarPropietarioaAgenda(String usuario, String idAgenda) throws RepositorioException, EntidadNoEncontrada {
		Agenda agenda = repositorioAgendas.getById(idAgenda);
		Propietario propietario = repositorioPropietarios.getByUsuario(usuario);
		propietario.addAgenda(agenda);
		agenda.setPropietario(propietario);
		repositorioPropietarios.update(propietario);
		repositorioAgendas.update(agenda);
	}
	
	public List<String> getAgendasPropietario(String usuario) throws EntidadNoEncontrada {
		Propietario propietario = repositorioPropietarios.getByUsuario(usuario);
        List<String> ids = new LinkedList<String>();
        for (Agenda agenda : propietario.getAgendas()) {
            ids.add(agenda.getId());
        }
        return ids;
	}
}