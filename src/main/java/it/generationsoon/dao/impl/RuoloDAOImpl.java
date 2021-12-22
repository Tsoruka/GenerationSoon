package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Ruolo;
import it.generationsoon.model.Utente;

public class RuoloDAOImpl implements RuoloDAO {

	@Override
	public Ruolo findById(Connection connection, int id) throws DAOException {
		Ruolo ruolo = null;
		String sql = "SELECT * FROM Attore_film WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				ruolo = new Ruolo();
				ruolo.setId(resultSet.getInt(1));
				Film film = new Film();
				film.setId(resultSet.getInt(2));
				ruolo.setFilm(film);
				Attore attore = new Attore();
				attore.setId(resultSet.getInt(3));
				ruolo.setAttore(attore);
				ruolo.setNomeRuolo(resultSet.getString(4));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return ruolo;
	}

}
