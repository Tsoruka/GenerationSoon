package it.generationsoon.model;

import java.util.ArrayList;
import java.util.List;

public class Attore {

//  `id` INT NOT NULL AUTO_INCREMENT,
	private int id;
//  `nome` VARCHAR(45) NOT NULL,
	private String nome;
//  `cognome` VARCHAR(45) NOT NULL,
	private String cognome; 
//  `data_di_nascita` DATE NOT NULL,
	private String dataDiNascita;
//  `luogo_di_nascita` VARCHAR(45) NOT NULL,
	private String luogoDiNascita;
//  `data_di_decesso` VARCHAR(45) NULL,
	private String dataDiDecesso;
//  `biografia` TEXT NOT NULL,
	private String biografia;
//  PRIMARY KEY (`id`));
	
	//COLLEGAMENTO (film) N <-> N (attore) 
	//ruolo di un attore in un film
	//un attore avrà più ruoli in più film
	private List<Ruolo> film = new ArrayList<Ruolo>();
	
	
	public List<Ruolo> getFilm() {
		return film;
	}
	public void setFilm(List<Ruolo> film) {
		this.film = film;
	}
	
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
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public String getDataDiDecesso() {
		return dataDiDecesso;
	}
	public void setDataDiDecesso(String dataDiDecesso) {
		this.dataDiDecesso = dataDiDecesso;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	@Override
	public String toString() {
		return "Attore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", luogoDiNascita=" + luogoDiNascita + ", dataDiDecesso=" + dataDiDecesso + ", biografia=" + biografia
				+ ", film=" + film + "]";
	}

	
}
