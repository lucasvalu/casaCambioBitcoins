package br.com.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bitcoin.model.Conta;

public interface Contas extends JpaRepository<Conta, String>{

}
