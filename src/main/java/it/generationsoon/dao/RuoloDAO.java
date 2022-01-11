package it.generationsoon.dao;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.model.Ruolo;


public interface RuoloDAO {
	
	List<Ruolo> findCastByFilmId(Connection connection, int id) throws DAOException;
	
	List<Ruolo> findFilmByAttoreId(Connection connection, int id) throws DAOException;
	
}
