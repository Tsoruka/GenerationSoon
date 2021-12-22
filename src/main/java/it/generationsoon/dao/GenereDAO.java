package it.generationsoon.dao;

import java.sql.Connection;

import it.generationsoon.model.Genere;

public interface GenereDAO {
	
	Genere findById(Connection connection, int id) throws DAOException;

}
