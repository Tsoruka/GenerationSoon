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
import it.generationsoon.dao.FilmDAO;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Ruolo;

public class RuoloDAOImpl implements RuoloDAO {
	
	private AttoreDAO attoreDAO = new AttoreDAOImpl();
	private FilmDAO filmDAO = new FilmDAOImpl();
	
	@Override
	//TODO: LISTA CAST ATTORI 
	public List<Ruolo> findCastByFilmId(Connection connection, int filmId) throws DAOException {
		List<Ruolo> cast = new ArrayList<Ruolo>();
		String sql = "SELECT af.id, af.film_id, af.attore_id, af.ruolo, a.nome, a.cognome from Attore_Film AS af INNER JOIN Attore AS a ON a.id = af.Attore_id WHERE af.Film_id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			//setta id del film (in session) per recuperare il cast di quel film 
			//sostituire il "?" della query con filmId
			statement.setInt(1, filmId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Ruolo ruolo = new Ruolo();
				//col (1) - id tabella Attore_Film
				ruolo.setId(resultSet.getInt(1));
				Film film = new Film();
				//col(2) - Film_id 
				film.setId(resultSet.getInt(2));
				//assegno id film al modello di Ruolo 
				//(solo id del film, lascio gli altri spazi vuoti) 
				ruolo.setFilm(film);
				
				Attore attore = new Attore();
				//col(3) - Attore_id
				attore.setId(resultSet.getInt(3));
				
				//col(4) - nomeRuolo interpretato dall'attore nel film  
				ruolo.setNomeRuolo(resultSet.getString(4));
				
				//col(5) - nome attore 
				attore.setNome(resultSet.getString(5));
				//col(6) - cognome attore
				attore.setCognome(resultSet.getString(6));
				
				//assegno id, nome e cognome attore al modello di Ruolo 
				//(lascio gli altri spazi vuoti) 
				ruolo.setAttore(attore);
				
				//aggiorna lista di ruoli 
				cast.add(ruolo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return cast;
	}
	

}






















































