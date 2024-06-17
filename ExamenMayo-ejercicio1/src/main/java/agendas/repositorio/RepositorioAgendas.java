package agendas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import agendas.dominio.Agenda;

@NoRepositoryBean
public interface RepositorioAgendas extends CrudRepository<Agenda, String>{

}
