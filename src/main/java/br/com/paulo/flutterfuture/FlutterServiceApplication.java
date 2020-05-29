package br.com.paulo.flutterfuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.paulo.flutterfuture.entity.Conta;
import br.com.paulo.flutterfuture.repository.ContaRepository;

@SpringBootApplication
public class FlutterServiceApplication implements CommandLineRunner {
	
	@Autowired
	private ContaRepository contaRepository;

	public static void main(String[] args) {
		SpringApplication.run(FlutterServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Conta c = new Conta("Paulo", 200.00);
		
		contaRepository.save(c);
	}

}
