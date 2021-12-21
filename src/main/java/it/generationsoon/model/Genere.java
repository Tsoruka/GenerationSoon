package it.generationsoon.model;

public enum Genere {
	ANIMAZIONE(1,"animazione"), AZIONE(2,"azione"), AVVENTURA(3,"avventura"), BIOGRAFIA(4,"biografia"), COMMEDIA(5,"commedia"), DOCUMENTARIO(6,"documentario"), DRAMMATICO(7,"drammatico"), 
	FANTASCIENZA(8,"fantascienza"), FANTASTICO(9,"fantastico"), GIALLO(10,"giallo"), GUERRA(11,"guerra"), HORROR(12,"horror"), MUSICALE(13,"musicale"), SENTIMENTALE(14,"sentimentale"), 
	STORICO(15,"storico"), THRILLER(16,"thriller"), WESTERN(17,"western"); 
	
	private int id;
	private String value;

	private Genere(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public int getId() {
		return id;
	}
	
}
