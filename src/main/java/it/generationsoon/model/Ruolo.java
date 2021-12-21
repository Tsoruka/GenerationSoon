package it.generationsoon.model;

public class Ruolo {
	private int id; 
	private String nomeRuolo;
	private Attore attore; 
	private Film film;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Attore getAttore() {
		return attore;
	}
	public void setAttore(Attore attore) {
		this.attore = attore;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getNomeRuolo() {
		return nomeRuolo;
	}
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}
	
	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", attore=" + attore + ", film=" + film + ", nome=" + nomeRuolo + "]";
	}
	
}
