package it.generationsoon.model;

import java.util.ArrayList;
import java.util.List;

public class Utente {

//  `id` INT NOT NULL AUTO_INCREMENT,
	private int id;
//  `nome` VARCHAR(45) NOT NULL,
	private String nome;
//  `cognome` VARCHAR(45) NOT NULL,
	private String cognome;
//  `username` VARCHAR(45) NOT NULL,
	private String username;
//  `password` VARCHAR(45) NOT NULL,
	private String password;

	private String email;

	// COLLEGAMENTO (film) N <-> N (utente)
	// voti degli utenti ai film
	// pi� utenti votano uno stesso film
	// pi� film vengono votati da pi� utenti
	private List<VotoUtenteFilm> filmVotati = new ArrayList<VotoUtenteFilm>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<VotoUtenteFilm> getFilmVotati() {
		return filmVotati;
	}

	public void setFilmVotati(List<VotoUtenteFilm> filmVotati) {
		this.filmVotati = filmVotati;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}

}
