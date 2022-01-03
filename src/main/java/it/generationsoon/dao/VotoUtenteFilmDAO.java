package it.generationsoon.dao;

import java.sql.Connection;

public interface VotoUtenteFilmDAO {
	
	void save(Connection connection, int filmId, int utenteId, int voto) throws DAOException;
	
	void update(Connection connection, int filmId, int utenteId, int voto) throws DAOException;
	
	//controllo se la casella voto è riempita - scelta tra save/update voto utente
	int votato(Connection connection, int filmId, int utenteId) throws DAOException; 
	
	//calcolo delle media dei voti dati dagli utenti ad un film 
	double mediaVotoFilm(Connection connection, int film_id) throws DAOException;
	//RICORDIAMO dai mantra di Roberto 
	//      "le DAO sono vicine alle tabelle" 
	//(rif. a come è scritta la query --> FROM voto_film 
}



