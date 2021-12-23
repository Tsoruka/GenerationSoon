package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.GenereDAO;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Utente;

public class GenereDAOImpl implements GenereDAO {


	@Override
	public Genere findById(Connection connection, int id) throws DAOException {
		Genere genere = null;
		String sql = "SELECT * FROM genere WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {				
				for (Genere gen : Genere.values()) {
					if(resultSet.getInt(1) == gen.getId()) {
						genere = Genere.fromId(id);
					}
				}
				genere.setId(resultSet.getInt(1));
				genere.setValue(resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return genere;
	}

}
