package it.generationsoon.dao;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.model.Ruolo;


public interface RuoloDAO {
	
	Ruolo findById(Connection connection, int id) throws DAOException;
	
}
