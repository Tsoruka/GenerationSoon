package it.generationsoon.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.generationsoon.dao.AttoreDAO;
import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.FilmDAO;
import it.generationsoon.dao.GenereDAO;
import it.generationsoon.dao.RegistaDAO;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.dao.impl.AttoreDAOImpl;
import it.generationsoon.dao.impl.FilmDAOImpl;
import it.generationsoon.dao.impl.GenereDAOImpl;
import it.generationsoon.dao.impl.RegistaDAOImpl;
import it.generationsoon.dao.impl.RuoloDAOImpl;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Ruolo;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.ServiceException;

public class FilmServiceImpl implements FilmService  {
	
	private FilmDAO filmDAO = new FilmDAOImpl();
	private GenereDAO genereDAO = new GenereDAOImpl();
	private RegistaDAO registaDAO = new RegistaDAOImpl();
	private AttoreDAO attoreDAO = new AttoreDAOImpl();
	private RuoloDAO ruoloDAO = new RuoloDAOImpl();
	
	public Film findById(int id) throws ServiceException {
		Film film = null;
		Connection connection = null;
		List<Ruolo> cast = new ArrayList<Ruolo>();
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			film = filmDAO.findById(connection, id);
			Genere genere = genereDAO.findById(connection, film.getGenere().getId());
			Regista regista = registaDAO.findById(connection, film.getRegista().getId());
			
			Attore attore = attoreDAO.findById(connection, id);
			
			film.setGenere(genere);
			film.setRegista(regista);
			
			//TODO: LISTA DI ATTORI
			
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return film;
	}

	@Override
	public Ruolo getRuolo(int id) throws ServiceException {
		Ruolo ruolo = null;
		Attore attore = null;
		Film film = null;
		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			ruolo = ruoloDAO.findById(connection, id);
			attore = attoreDAO.findById(connection, ruolo.getAttore().getId());
			film = filmDAO.findById(connection, ruolo.getFilm().getId());
			ruolo.setAttore(attore);
			ruolo.setFilm(film);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return ruolo;
	}


}