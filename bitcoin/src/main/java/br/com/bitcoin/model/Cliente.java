package br.com.bitcoin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Cliente {
	@Id
	private String cpf;
	
	@NotNull
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta")
	private Conta conta;
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Conta getConta() {
		return conta;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", conta=" + conta + "]";
	}
	
}
