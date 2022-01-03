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
	public void update(Connection connection,VotoUtente votoUtente) throws DAOException {
		String sql = "UPDATE Voto_film SET voto=? WHERE Film_id=? and Utente_id=?";
		System.out.println(sql);
		// Statement statement = null;
		PreparedStatement statement = null;
		try {
			// statement = connection.createStatement();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, votoUtente.getVoto());
			statement.setInt(2, votoUtente.getFilm().getId());
			statement.setInt(3, votoUtente.getUtente().getId());
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

	@Override
	public int findIdVotoUtente(Connection connection, int filmId, int utenteId) throws DAOException {
		int votoUtenteId = 0;
		String sql = "select voto_film.id from voto_film inner join utente on utente.id = voto_film.utente_id inner join film on voto_film.film_id = film.id where film.id = ? and utente.id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, filmId);
			statement.setInt(2, utenteId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				
				votoUtenteId = resultSet.getInt(1);


			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return votoUtenteId;
	}

	@Override
	public void save(Connection connection, VotoUtente votoUtente) throws DAOException {
		String sql = "INSERT INTO Voto_film(Film_id,Utente_id,voto) VALUES(?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setInt(1, votoUtente.getFilm().getId());
			statement.setInt(2, votoUtente.getUtente().getId());
			statement.setInt(3, votoUtente.getVoto());
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				votoUtente.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
		
	}
		
	}


