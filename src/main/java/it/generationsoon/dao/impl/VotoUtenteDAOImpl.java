package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.VotoUtenteDAO;
import it.generationsoon.model.Film;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtente;

public class VotoUtenteDAOImpl implements VotoUtenteDAO{

	@Override
	public VotoUtente findById(Connection connection, int id) throws DAOException {
		VotoUtente votoUtente = null;
		String sql = "SELECT * FROM Voto_film WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				votoUtente = new VotoUtente();
				votoUtente.setId(resultSet.getInt(1));
				Film film = new Film();
				film.setId(resultSet.getInt(2));
				votoUtente.setFilm(film);
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(3));
				votoUtente.setUtente(utente);
				votoUtente.setVoto(resultSet.getInt(4));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return votoUtente;
	}

	@Override
	public void update(Connection connection, VotoUtente votoUtente) throws DAOException {
		String sql = "UPDATE Voto_film SET voto=? WHERE id=?";
		System.out.println(sql);
		// Statement statement = null;
		PreparedStatement statement = null;
		try {
			// statement = connection.createStatement();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, votoUtente.getVoto());
			statement.setInt(2, votoUtente.getId());
			// statement.executeUpdate(sql);
			statement.executeUpdate();
			// COMMIT
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			// ROLLBACK
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}
		
	}


