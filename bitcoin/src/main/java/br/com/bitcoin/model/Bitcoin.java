package br.com.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bitcoin {

	@JsonProperty("data")
	private BitcoinData data;
	
	
	
	public Bitcoin() {

	}

	public BitcoinData getData() {
		return data;
	}

	public void setData(BitcoinData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Bitcoin [data=" + data + "]";
	}
	

}
