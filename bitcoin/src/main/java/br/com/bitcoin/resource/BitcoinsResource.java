package br.com.bitcoin.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.bitcoin.model.Bitcoin;

@RestController
@RequestMapping(value = "/bitcoin")
public class BitcoinsResource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public Bitcoin show() {
		Bitcoin bitcoin = restTemplate.getForObject("https://api.coinbase.com/v2/prices/spot?currency=BRL", Bitcoin.class);
		return bitcoin;
	}

}
