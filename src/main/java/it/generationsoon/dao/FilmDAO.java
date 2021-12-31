package it.generationsoon.dao;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.model.Film;

public interface FilmDAO {
	
	Film findById(Connection connection, int id) throws DAOException;
	
	List<Film> findAll(Connection connection) throws DAOException;
	
	List<Film> findByTitolo(Connection connection, String titolo) throws DAOException;

	List<Film> filterByGenereAndAnno(Connection connection,String genere, int anno) throws DAOException; 
	
	double mediaVotoFilm(Connection connection, int film_id) throws DAOException; 

}
