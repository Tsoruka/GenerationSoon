package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.VotoUtenteFilmDAO;
import it.generationsoon.model.Film;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtenteFilm;

public class VotoUtenteFilmDAOImpl implements VotoUtenteFilmDAO{
	
	
	@Override
	public void update(Connection connection,int filmId, int utenteId, int voto) throws DAOException {
		String sql = "UPDATE voto_film SET voto=? WHERE film_id=? and utente_id=?";
		System.out.println(sql);
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, voto);
			statement.setInt(2, filmId);
			statement.setInt(3, utenteId);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}

	

	@Override
	public void save(Connection connection, int filmId, int utenteId, int voto) throws DAOException {
		String sql = "INSERT INTO voto_film(film_id, utente_id, voto) VALUES(?,?,?)";
		System.out.println(sql);
		VotoUtenteFilm votoUtenteFilm = new VotoUtenteFilm();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			
			statement.setInt(1, filmId);
			Film film = new Film();
			votoUtenteFilm.setFilm(film);
			votoUtenteFilm.getFilm().setId(filmId);
			
			statement.setInt(2, utenteId);
			Utente utente = new Utente();
			votoUtenteFilm.setUtente(utente);
			votoUtenteFilm.getUtente().setId(utenteId);
			
			statement.setInt(3, voto);
			votoUtenteFilm.setVoto(voto);
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				votoUtenteFilm.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
		
	}
	
	
	
	@Override
	public double mediaVotoFilm(Connection connection, int filmId) throws DAOException {
		//RICORDIAMO dai mantra di Roberto 
		//      "le DAO sono vicine alle tabelle" 
		String sql = "SELECT AVG(voto) FROM voto_film WHERE film_id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		double mediaVoto = 0;
		
		try {			
		statement = connection.prepareStatement(sql);
		statement.setInt(1, filmId);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
		mediaVoto = resultSet.getDouble(1);
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return mediaVoto;
	}



	@Override
	public int votato(Connection connection, int filmId, int utenteId) throws DAOException {
		String sql = "SELECT voto FROM voto_film WHERE film_id = ? AND utente_id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int voted = 0;
		
		try {			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, filmId);
			statement.setInt(2, utenteId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
			voted = resultSet.getInt(1);
				}
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOException(e.getMessage(), e);
			}
			finally {
				DBUtil.close(resultSet);
				DBUtil.close(statement);
			}
			return voted;
	}
}
		
	


