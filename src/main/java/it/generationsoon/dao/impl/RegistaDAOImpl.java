package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.RegistaDAO;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Utente;

public class RegistaDAOImpl implements RegistaDAO{

	@Override
	public Regista findById(Connection connection, int id) throws DAOException {
		Regista regista = null;
		String sql = "SELECT * FROM Regista WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				regista = new Regista();
				regista.setId(resultSet.getInt(1));
				regista.setNome(resultSet.getString(2));
				regista.setCognome(resultSet.getString(3));
				regista.setDataDiNascita(resultSet.getString(4));
				regista.setNazionalita(resultSet.getString(5));
				regista.setDataDiDecesso(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return regista;
	}

}
