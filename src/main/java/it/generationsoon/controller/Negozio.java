package it.generationsoon.controller;

import java.util.ArrayList;
import java.util.List;

public class Negozio {
	
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "Negozio [prodotti=" + prodotti + "]";
	} 

}
