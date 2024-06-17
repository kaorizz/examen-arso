package cliente.pruebas;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import cliente.eventos.EventoAñadirCita;
import cliente.rabbit.IServicioRabbitMQ;
import cliente.rabbit.ServicioRabbitMQ;

public class PruebaRabbitMQ {

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, TimeoutException, URISyntaxException, IOException {
		
		IServicioRabbitMQ servicio = new ServicioRabbitMQ();
		
		EventoAñadirCita evento = new EventoAñadirCita("666dc4898847c67946e9895d", "Cita médico", "2024-06-30T10:00:00", 30);
		
		servicio.enviarMensaje("añadir-cita", evento);
		
		System.out.println("Evento enviado!");
	}
}
