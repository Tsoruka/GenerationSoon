package it.generationsoon.model;

public class VotoUtenteFilm {
	private int id; 
	private Utente utente; 
	private Film film; 
	private int voto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	@Override
	public String toString() {
		return "VotoUtente [id=" + id + ", utente=" + utente + ", film=" + film + ", voto=" + voto + "]";
	} 
}
