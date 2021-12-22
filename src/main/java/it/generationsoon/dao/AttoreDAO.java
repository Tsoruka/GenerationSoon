package it.generationsoon.dao;

import java.sql.Connection;

import it.generationsoon.model.Attore;


public interface AttoreDAO {
	
	Attore findById(Connection connection, int id) throws DAOException;

}
