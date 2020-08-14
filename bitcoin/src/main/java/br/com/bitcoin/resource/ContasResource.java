package br.com.bitcoin.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bitcoin.model.Conta;
import br.com.bitcoin.repository.Contas;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContasResource {

	@Autowired
	private Contas contas;
	
	@GetMapping
	public List<Conta> list() {
		return contas.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> retrieve(@PathVariable String id) {
		Conta conta = contas.getOne(id);
		
		if (conta == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(conta);
	}
	
}
