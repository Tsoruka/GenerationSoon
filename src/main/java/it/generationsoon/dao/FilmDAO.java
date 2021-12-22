package it.generationsoon.dao;

import java.sql.Connection;

import it.generationsoon.model.Film;

public interface FilmDAO {
	
	Film findById(Connection connection, int id) throws DAOException;

}
