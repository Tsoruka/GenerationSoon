package it.generationsoon.dao;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.model.Attore;


public interface AttoreDAO {
	
	Attore findById(Connection connection, int id) throws DAOException;
	
	List<Attore> findAll(Connection connection) throws  DAOException;
	
}
