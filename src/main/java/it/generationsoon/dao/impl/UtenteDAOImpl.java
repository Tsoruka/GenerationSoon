package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.UtenteDAO;
import it.generationsoon.model.Utente;

public class UtenteDAOImpl implements UtenteDAO {

	@Override
	public void save(Connection connection, Utente utente) throws DAOException {
		String sql = "INSERT INTO utente(nome,cognome,email,username,password) VALUES(?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;

		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getEmail());
			statement.setString(4, utente.getUsername());
			statement.setString(5, utente.getPassword());
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				utente.setId(generatedKeys.getInt(1));
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
	public Utente findById(Connection connection, int id) throws DAOException {
		Utente utente = null;
		String sql = "SELECT * FROM Utente WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setNome(resultSet.getString(2));
				utente.setCognome(resultSet.getString(3));
				utente.setEmail(resultSet.getString(4));
				utente.setUsername(resultSet.getString(5));
				utente.setPassword(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utente;
	}

	@Override
	public Utente findByUsername(Connection connection, String username) throws DAOException {
		Utente utente = null;
		String sql = "SELECT * FROM Utente WHERE username=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setNome(resultSet.getString(2));
				utente.setCognome(resultSet.getString(3));
				utente.setEmail(resultSet.getString(4));
				utente.setUsername(resultSet.getString(5));
				utente.setPassword(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utente;
	}

	@Override
	public Utente findByEmail(Connection connection, String email) throws DAOException {
		Utente utente = null;
		String sql = "SELECT * FROM Utente WHERE email=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setNome(resultSet.getString(2));
				utente.setCognome(resultSet.getString(3));
				utente.setEmail(resultSet.getString(4));
				utente.setUsername(resultSet.getString(5));
				utente.setPassword(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utente;
	}

	@Override
	public String usernameInUso(Connection connection, String username) throws DAOException {
		String sql = "SELECT username FROM Utente WHERE username=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String usernameInUso = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				usernameInUso = resultSet.getString(1);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return usernameInUso;
	}

	@Override
	public String emailInUso(Connection connection, String email) throws DAOException {
		String sql = "SELECT email FROM Utente WHERE email=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String emailInUso = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				emailInUso = resultSet.getString(1);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return emailInUso;
	}

}
