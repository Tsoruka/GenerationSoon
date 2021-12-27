package it.generationsoon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.FilmDAO;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Ruolo;


public class FilmDAOImpl implements FilmDAO{

	@Override
	public Film findById(Connection connection, int id) throws DAOException {
		Film film = null;
		String sql = "SELECT * FROM Film WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				film = new Film();
				film.setId(resultSet.getInt(1));
				film.setTitolo(resultSet.getString(2));
				film.setDescrizione(resultSet.getString(3));
				film.setAnno(resultSet.getInt(4));
				film.setDurata(resultSet.getInt(5));
				film.setFoto(resultSet.getString(6));
				film.setDistribuzione(resultSet.getString(7));
				film.setPaese(resultSet.getString(8));
				film.setDataDiUscita(resultSet.getString(9));
				film.setGenere(Genere.fromId(resultSet.getInt(10)));
				//preso genere con metodo fromId
				Regista regista = new Regista();
				regista.setId(resultSet.getInt(11));
				film.setRegista(regista);
				
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return film;
	}

	@Override
	public List<Film> findAll(Connection connection) throws DAOException {
		
		List<Film> listaFilm= new ArrayList<Film>(); 
		String sql = "SELECT * FROM Film order by data_di_uscita desc;";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			//setta id del film (in session) per recuperare il cast di quel film 
			//sostituire il "?" della query con filmId
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Film film = new Film();
				
				film.setId(resultSet.getInt(1));
				film.setTitolo(resultSet.getString(2));
				film.setDescrizione(resultSet.getString(3));
				film.setAnno(resultSet.getInt(4));
				film.setDurata(resultSet.getInt(5));
				film.setFoto(resultSet.getString(6));
				film.setDistribuzione(resultSet.getString(7));
				film.setPaese(resultSet.getString(8));
				film.setDataDiUscita(resultSet.getString(9));
				film.setGenere(Genere.fromId(resultSet.getInt(10)));
				Regista regista = new Regista();
				regista.setId(resultSet.getInt(11));
				film.setRegista(regista);
				
				//aggiorna lista di ruoli 
				listaFilm.add(film);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return listaFilm;
		
		
		
	}

}
