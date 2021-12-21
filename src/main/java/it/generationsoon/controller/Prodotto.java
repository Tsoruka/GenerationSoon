package it.generationsoon.controller;

public class Prodotto {
	private int codice;

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "Prodotto [codice=" + codice + "]";
	}
	
}
