package it.generationsoon.dao;

import java.sql.Connection;


import it.generationsoon.model.VotoUtente;

public interface VotoUtenteDAO {
	
	VotoUtente findById(Connection connection, int id) throws DAOException;
	
	void save(Connection connection, VotoUtente votoUtente) throws DAOException;
	
	void update(Connection connection, VotoUtente votoUtente) throws DAOException;

	int findIdVotoUtente(Connection connection, int filmId, int utenteId) throws DAOException;
}



