package it.generationsoon.model;

import java.util.ArrayList;
import java.util.List;

public class Film implements Comparable<Film> {
// `id` INT NOT NULL AUTO_INCREMENT,
	private int id;
//  `titolo` VARCHAR(45) NOT NULL,
	private String titolo;
//  `descrizione` TEXT NOT NULL,
	private String descrizione;
//  `anno` INT NOT NULL,
	private int anno;
//  `durata` INT NOT NULL,
	private int durata;
	//TODO: calcolo media voti 
	private double mediaVoti;
//  `foto` VARCHAR(500) NOT NULL,
	private String foto;
//  `distribuzione` VARCHAR(45) NOT NULL,
	private String distribuzione;
//  `paese` VARCHAR(45) NOT NULL,
	private String paese;
//  `data_di_uscita` DATE NOT NULL,
	private String dataDiUscita;
//  `genere` VARCHAR(100) NOT NULL,
	private Genere genere;
//  `Regista_id` INT NOT NULL,
	private Regista regista;
	
	//lista dei ruoli interpretati dagli attori 
	private List<Ruolo> attori = new ArrayList<Ruolo>();
	//lista dei voti dati al film dagli N utenti
	private List<VotoUtente> votiUtenti = new ArrayList<VotoUtente>();
//  PRIMARY KEY (`id`),
//	FOREIGN KEY (`Regista_id`) REFERENCES `generation_soon`.`Regista` (`id`)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDistribuzione() {
		return distribuzione;
	}
	public void setDistribuzione(String distribuzione) {
		this.distribuzione = distribuzione;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public String getDataDiUscita() {
		return dataDiUscita;
	}
	public void setDataDiUscita(String dataDiUscita) {
		this.dataDiUscita = dataDiUscita;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	public Regista getRegista() {
		return regista;
	}
	public void setRegista(Regista regista) {
		this.regista = regista;
	}
	public List<Ruolo> getAttori() {
		return attori;
	}
	public void setAttori(List<Ruolo> attori) {
		this.attori = attori;
	}
	public List<VotoUtente> getVotiUtenti() {
		return votiUtenti;
	}
	public void setVotiUtenti(List<VotoUtente> votiUtenti) {
		this.votiUtenti = votiUtenti;
	}
	
	public double getMediaVoti() {
		return mediaVoti;
	}
	public void setMediaVoti(double mediaVoti) {
		this.mediaVoti = mediaVoti;
	}
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", anno=" + anno + ", durata="
				+ durata + ", mediaVoti=" + mediaVoti + ", foto=" + foto + ", distribuzione=" + distribuzione
				+ ", paese=" + paese + ", dataDiUscita=" + dataDiUscita + ", genere=" + genere + ", regista=" + regista
				+ ", attori=" + attori + ", votiUtenti=" + votiUtenti + "]";
	}
	
	//metodo necessario all'ordinamento in FilmServiceImpl.OrderByName()
	@Override
	    public int compareTo(Film other) {
	        return titolo.compareTo(other.titolo);
	    }
	
	
	
	
	
		
}
