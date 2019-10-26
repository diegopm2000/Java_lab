package es.poc.holamundospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="es.poc.holamundospringboot")
public class HolaMundoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoSpringBootApplication.class, args);
	}
}
