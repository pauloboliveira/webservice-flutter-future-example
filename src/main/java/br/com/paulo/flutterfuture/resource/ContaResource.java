package br.com.paulo.flutterfuture.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.flutterfuture.entity.Conta;
import br.com.paulo.flutterfuture.repository.ContaRepository;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Conta> getConta(@PathVariable Integer id) {
		return contaRepository.findById(id);
	}

}
