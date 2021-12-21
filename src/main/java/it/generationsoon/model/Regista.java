package it.generationsoon.model;

public class Regista {

//  `id` INT NOT NULL AUTO_INCREMENT,
	private int id;
//  `nome` VARCHAR(45) NOT NULL,
	private String nome;
//  `cognome` VARCHAR(45) NOT NULL,
	private String congnome; 
//  `data_di_nascita` DATE NOT NULL,
	private String dataDiNascita;
//  `nazionalita` VARCHAR(45) NOT NULL,
	private String nazionalita;
//  `data_di_decesso` VARCHAR(45) NULL,
	private String dataDiDecesso;
	
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
	public String getCongnome() {
		return congnome;
	}
	public void setCongnome(String congnome) {
		this.congnome = congnome;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public String getDataDiDecesso() {
		return dataDiDecesso;
	}
	public void setDataDiDecesso(String dataDiDecesso) {
		this.dataDiDecesso = dataDiDecesso;
	}
	
	@Override
	public String toString() {
		return "Regista [id=" + id + ", nome=" + nome + ", congnome=" + congnome + ", dataDiNascita=" + dataDiNascita
				+ ", nazionalita=" + nazionalita + ", dataDiDecesso=" + dataDiDecesso + "]";
	}
	
}
