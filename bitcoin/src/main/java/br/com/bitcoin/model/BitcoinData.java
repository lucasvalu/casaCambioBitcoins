package br.com.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinData {
	@JsonProperty("base")
    private String base;
	@JsonProperty("currency")
    private String currency;
	@JsonProperty("amount")
    private String amount;

    public BitcoinData() {
    	
    }
    
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BitcoinData [base=" + base + ", currency=" + currency + ", amount=" + amount + "]";
	}

}
