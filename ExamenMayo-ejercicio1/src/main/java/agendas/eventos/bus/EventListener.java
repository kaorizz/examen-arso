package agendas.eventos.bus;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import agendas.eventos.ProcesadorEventos;
import agendas.eventos.config.RabbitMQConfig;
import repositorio.EntidadNoEncontrada;

@Component
public class EventListener {

	private ProcesadorEventos eventHandler;

	@Autowired
	public EventListener(ProcesadorEventos eventHandler) {
		this.eventHandler = eventHandler;
	}

	EventListener() {
	}

	@SuppressWarnings("unchecked")
	@RabbitListener(queues = RabbitMQConfig.QUEUE)
	public void handleEvent(Message mensaje) throws StreamReadException, DatabindException, IOException, NumberFormatException, EntidadNoEncontrada {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(mensaje.getBody(), Map.class);

		String routingKey = mensaje.getMessageProperties().getReceivedRoutingKey();
		String eventID = routingKey.substring(routingKey.lastIndexOf('.') + 1);

		switch (eventID) {
		case "añadir-cita":
			System.out.println("Cita añadida: " + map);
			eventHandler.procesarAgregarCita(map.get("idAgenda").toString(), map.get("descripcion").toString(),
					map.get("inicio").toString(), Integer.parseInt(map.get("duracion").toString()));
			break;
		}
	}
}