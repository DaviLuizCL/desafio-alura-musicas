package com.alura.musicas.AluraMusicas;

import com.alura.musicas.AluraMusicas.Principal.Principal;
import com.alura.musicas.AluraMusicas.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicasApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicasApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception{
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
