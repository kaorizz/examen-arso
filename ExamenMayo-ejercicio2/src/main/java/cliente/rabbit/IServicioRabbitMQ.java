package cliente.rabbit;

import java.io.IOException;

public interface IServicioRabbitMQ {

	void enviarMensaje(String idEvento, Object evento) throws IOException;
}
