package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.generationsoon.dao.AttoreDAO;
import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.model.Attore;


public class AttoreDAOImpl implements AttoreDAO {

	@Override
	public Attore findById(Connection connection, int id) throws DAOException {
		Attore attore = null;
		String sql = "SELECT * FROM Attore WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				attore = new Attore();
				attore.setId(resultSet.getInt(1));
				attore.setNome(resultSet.getString(2));
				attore.setCognome(resultSet.getString(3));
				attore.setDataDiNascita(resultSet.getString(4));
				attore.setLuogoDiNascita(resultSet.getString(5));
				attore.setDataDiDecesso(resultSet.getString(6));
				attore.setBiografia(resultSet.getString(7));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return attore;
	}

	@Override
	public List<Attore> findAll(Connection connection) throws DAOException {
		List<Attore> listaAttore= new ArrayList<Attore>(); 
		String sql = "SELECT * FROM Attore";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			//setta id del film (in session) per recuperare il cast di quel film 
			//sostituire il "?" della query con filmId
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Attore attore = new Attore();
				
				attore.setId(resultSet.getInt(1));
				attore.setNome(resultSet.getString(2));
				attore.setCognome(resultSet.getString(3));
				attore.setDataDiNascita(resultSet.getString(4));
				attore.setLuogoDiNascita(resultSet.getString(5));
				attore.setDataDiDecesso(resultSet.getString(6));
				attore.setBiografia(resultSet.getString(7));	
				//aggiorna lista di attore
				listaAttore.add(attore);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return listaAttore;
	}

}
