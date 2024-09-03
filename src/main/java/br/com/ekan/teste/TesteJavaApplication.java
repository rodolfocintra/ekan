package br.com.ekan.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TesteJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteJavaApplication.class, args);
	}



}
