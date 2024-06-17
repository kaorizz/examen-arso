package propietarios.repositorio;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import propietarios.dominio.Propietario;
import repositorio.EntidadNoEncontrada;
import repositorio.IRepositorio;
import repositorio.RepositorioException;
import utils.PropertiesReader;

@Singleton(name = "RepositorioPropietariosMongoDB")
@Startup
@Lock(LockType.READ)
public class RepositorioPropietariosMongoDB implements IRepositorio<Propietario, String> {

	private MongoCollection<Propietario> propietarios;

	@PostConstruct
	public void init() throws IOException {
		PropertiesReader properties;
		properties = new PropertiesReader("mongo.properties");

		String connectionString = properties.getProperty("mongouri");

		MongoClient mongoClient = MongoClients.create(connectionString);

		String mongoDatabase = properties.getProperty("mongodatabase");

		MongoDatabase database = mongoClient.getDatabase(mongoDatabase);

		CodecRegistry defaultCodecRegistry = CodecRegistries.fromRegistries(
				MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		propietarios = database.getCollection("propietarios", Propietario.class)
				.withCodecRegistry(defaultCodecRegistry);
	}

	@Override
	public String add(Propietario entity) throws RepositorioException, EntidadNoEncontrada {
		if (getByUsuario(entity.getUsuario()) != null) {
			throw new RepositorioException("Ya existe un propietario con el usuario " + entity.getUsuario());
		}
		InsertOneResult resultado = propietarios.insertOne(entity);
		if (resultado.getInsertedId() == null) {
			throw new RepositorioException("Error creando un nuevo propietario");
		}
		return entity.getId();
	}

	@Override
	public void update(Propietario entity) throws RepositorioException, EntidadNoEncontrada {
		UpdateResult result = propietarios.replaceOne(new Document("_id", new ObjectId(entity.getId())), entity);
		if (result.getMatchedCount() == 0) {
			throw new EntidadNoEncontrada("No se ha encontrado el propietario a actualizar");
		}
		if (result.getModifiedCount() == 0) {
			throw new RepositorioException("No se ha actualizado el propietario");
		}
	}

	@Override
	public void delete(String id) throws RepositorioException, EntidadNoEncontrada {
		DeleteResult result = propietarios.deleteOne(new Document("_id", new ObjectId(id)));
		if (result.getDeletedCount() == 0) {
			throw new EntidadNoEncontrada("No se ha encontrado el documento a borrar");
		}
		if (!result.wasAcknowledged()) {
			throw new RepositorioException("No se ha borrado el documento");
		}
	}

	@Override
	public Propietario getById(String id) throws RepositorioException, EntidadNoEncontrada {
		Document query = new Document("_id", new ObjectId(id));
		Propietario entity = propietarios.find(query).first();
		if (entity == null) {
			throw new EntidadNoEncontrada("Propietario no encontrado para el id " + id);
		}
		return entity;
	}
	
	public Propietario getByUsuario(String usuario) throws EntidadNoEncontrada {
		Document query = new Document("usuario", usuario);
		Propietario entity = propietarios.find(query).first();
		if (entity == null) {
			throw new EntidadNoEncontrada("Propietario no encontrado para el usuario " + usuario);
		}
		return entity;
	}

	@Override
	public List<Propietario> getAll() throws RepositorioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getIds() throws RepositorioException {
		// TODO Auto-generated method stub
		return null;
	}

}
