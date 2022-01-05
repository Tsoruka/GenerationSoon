package it.generationsoon.dao;

import java.sql.Connection;

import it.generationsoon.model.Utente;

public interface UtenteDAO {
	
	void save(Connection connection, Utente utente) throws DAOException;

	Utente findById(Connection connection, int id) throws DAOException;

	Utente findByUsername(Connection connection, String username) throws DAOException;
	
	//String per username --> query Select username from utente where username=?
	
	// findbyEmail
	
	// String per email

}
