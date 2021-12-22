package it.generationsoon.dao;

import java.sql.Connection;

import it.generationsoon.model.Regista;

public interface RegistaDAO {
	
	Regista findById(Connection connection, int id) throws DAOException;

}
