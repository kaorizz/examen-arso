package cliente.rabbit;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ServicioRabbitMQ implements IServicioRabbitMQ {

	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Channel channel;
	@SuppressWarnings("unused")
	private String QUEUE = "agendas";
	private String EXCHANGE_NAME = "amq.direct";
	private String ROUTING_KEY = "agenda";

	public ServicioRabbitMQ()
			throws TimeoutException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException {
		connectionFactory = new ConnectionFactory();
		connectionFactory.setUri("amqp://guest:guest@rabbitmq:5672");

		try {
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enviarMensaje(String idEvento, Object evento) throws IOException {
		// mappear el objeto a json
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(evento);

		// preparar el routing key
		String routingKey = ROUTING_KEY + "." + idEvento;

		// publicar el mensaje
		channel.basicPublish(EXCHANGE_NAME, routingKey,
				new AMQP.BasicProperties().builder().contentType("application/json").build(), json.getBytes());
	}

}
