package br.com.alura.tabelafipe.consulta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.tabelafipe.consulta.principal.Consulta;

@SpringBootApplication
public class ConsultaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsultaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Consulta.consultar();
	}

}
