package agendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AgendasApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = SpringApplication.run(AgendasApp.class, args);
	}
}