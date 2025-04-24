package com.curso.suporteos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.curso") // define o pacote inicial para a busca dos componentes de nosso software
@EntityScan(basePackages = {"com.curso.domains", "com.curso.domains.enums"}) // faz com que o Spring identifique nossas entidades para o Spring JPA
@EnableJpaRepositories(basePackages = "com.curso.repositories") // Define o pacote dos repositories
@SpringBootApplication
public class SuporteosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuporteosApplication.class, args);
	}

}
