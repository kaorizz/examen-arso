package agendas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import agendas.dominio.Agenda;

public interface RepositorioAgendasMongo extends RepositorioAgendas, MongoRepository<Agenda, String>{

}
