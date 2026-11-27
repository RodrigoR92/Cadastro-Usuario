package com.rodrigo.usuarioCadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsuarioCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioCadastroApplication.class, args);
	}

}
