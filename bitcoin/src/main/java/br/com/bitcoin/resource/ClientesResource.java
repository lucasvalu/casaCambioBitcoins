package br.com.bitcoin.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.bitcoin.model.Bitcoin;
import br.com.bitcoin.model.Cliente;
import br.com.bitcoin.repository.Clientes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cliente")
public class ClientesResource {

	@Autowired
	private Clientes clientes;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criate(@Validated @RequestBody Cliente cliente) {
		return clientes.save(cliente);
	}
	
	@GetMapping
	public List<Cliente> list() {
		return clientes.findAll();
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> retrieve(@PathVariable String cpf) {
		Cliente cliente = clientes.getOne(cpf);
		
		if (cliente == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<Void> remove(@PathVariable String cpf){
		Cliente cliente = clientes.getOne(cpf);
		
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		clientes.delete(cliente);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{cpf}/creditar")
	public ResponseEntity<Cliente> creditarCliente(@PathVariable String cpf, @Validated @RequestBody Cliente cliente) {
		Cliente clienteExistente = clientes.getOne(cpf);
		
		if (clienteExistente == null) 
			return ResponseEntity.notFound().build();
		
		double saldoAnterior = clienteExistente.getConta().getSaldo();
		
		BeanUtils.copyProperties(cliente, clienteExistente, "cpf");
		clienteExistente.getConta().creditarSaldo(clienteExistente.getConta().getCredito(), saldoAnterior);
		clienteExistente = clientes.save(clienteExistente);

		return ResponseEntity.ok(clienteExistente);
	}
	
	@PostMapping("/{cpf}")
	public ResponseEntity<Cliente> update(@PathVariable String cpf, @Validated @RequestBody Cliente cliente) {
		Cliente clienteExistente = clientes.getOne(cpf);
		
		if (clienteExistente == null) 
			return ResponseEntity.notFound().build();
		
		BeanUtils.copyProperties(cliente, clienteExistente, "cpf");
		clienteExistente = clientes.save(clienteExistente);

		return ResponseEntity.ok(clienteExistente);
	}
	
	/*
	 * Teste de creditação através do método GET
	@GetMapping("creditar/{cpf}")
	public ResponseEntity<Cliente> creditarCliente(@PathVariable String cpf, @RequestParam double credito	) {
		Cliente cliente = clientes.getOne(cpf);
		
		if (cliente == null)
			return ResponseEntity.notFound().build();
		
				
		if(credito > 0) {
			cliente.getConta().creditarSaldo(cliente.getConta().getSaldo(),credito);
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}*/
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("comprarBitcoin/{cpf}")
	public ResponseEntity<Cliente> comprarBitcoin(@PathVariable String cpf, @RequestParam double quantidadeBitcoin	) {
		Cliente cliente = clientes.getOne(cpf);
		
		if (cliente == null)
			return ResponseEntity.notFound().build();
		
		Bitcoin bitcoin = restTemplate.getForObject("https://api.coinbase.com/v2/prices/spot?currency=BRL", Bitcoin.class);
		
		double valorBitcoin = Double.parseDouble(bitcoin.getData().getAmount());
		
		if(cliente.getConta().getSaldo() > (valorBitcoin * quantidadeBitcoin)) {
			cliente.getConta().setSaldo(cliente.getConta().getSaldo() - (valorBitcoin * quantidadeBitcoin));
			cliente.getConta().setSaldoBitcoin(quantidadeBitcoin);
			cliente.getConta().setInvestimentoTotal(quantidadeBitcoin * Double.parseDouble(bitcoin.getData().getAmount()));
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
