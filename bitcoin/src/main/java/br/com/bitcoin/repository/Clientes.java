package br.com.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bitcoin.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, String>{

}
