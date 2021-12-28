package it.generationsoon.dao;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.model.Film;

public interface FilmDAO {
	
	Film findById(Connection connection, int id) throws DAOException;
	
	List<Film> findAll(Connection connection) throws DAOException;
	
	
	

}
