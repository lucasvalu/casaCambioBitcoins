package br.com.bitcoin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Conta {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private String id;
	
	
	private double saldo;
	private double saldoBitcoin;
	private double investimentoTotal;
	private double lucro;
	private double credito;



	public Conta() {

	}
	
	public Conta(String id, double saldo, double saldoBitcoin, double investimentoTotal, double lucro, double credito) {
		this.id = id;
		this.saldo = saldo;
		this.saldoBitcoin = saldoBitcoin;
		this.investimentoTotal = investimentoTotal;
		this.lucro = lucro;
		this.credito = credito;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldoBitcoin() {
		return saldoBitcoin;
	}
	
	public void setSaldoBitcoin(double saldoBitcoin) {
		this.saldoBitcoin = saldoBitcoin;
	}
	
	public double getInvestimentoTotal() {
		return investimentoTotal;
	}
	
	public void setInvestimentoTotal(double investimentoTotal) {
		this.investimentoTotal = investimentoTotal;
	}
	
	public void creditarSaldo (double credito, double saldoAnterior) {
		this.setSaldo(saldoAnterior + credito);
	}
	
	public void creditarSaldo (double credito) {
		this.saldo += credito;
	}
	
	public double getLucro() {
		return lucro;
	}
	
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", saldo=" + saldo + ", saldoBitcoin=" + saldoBitcoin + ", investimentoTotal="
				+ investimentoTotal + ", lucro=" + lucro + ", credito=" + credito + "]";
	}
	
	
}
