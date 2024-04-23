package br.com.alura.tabelafipe.consuta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.tabelafipe.consuta.principal.Consulta;

@SpringBootApplication
public class ConsutaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsutaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Consulta.consultar();
	}

}
