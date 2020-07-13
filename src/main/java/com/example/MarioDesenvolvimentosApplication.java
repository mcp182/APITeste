package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.mariodesenvolvimentos.controller.PessoaController;

@SpringBootApplication
public class MarioDesenvolvimentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarioDesenvolvimentosApplication.class, args);
	}

}
