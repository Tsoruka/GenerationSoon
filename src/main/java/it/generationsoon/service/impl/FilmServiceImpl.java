package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.FilmDAO;
import it.generationsoon.dao.GenereDAO;
import it.generationsoon.dao.RegistaDAO;
import it.generationsoon.dao.impl.FilmDAOImpl;
import it.generationsoon.dao.impl.GenereDAOImpl;
import it.generationsoon.dao.impl.RegistaDAOImpl;
import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.ServiceException;

public class FilmServiceImpl implements FilmService  {
	
	private FilmDAO filmDAO = new FilmDAOImpl();
	private GenereDAO genereDAO = new GenereDAOImpl();
	private RegistaDAO registaDAO = new RegistaDAOImpl();
	
	public Film findById(int id) throws ServiceException {
		Film film = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			film = filmDAO.findById(connection, id);
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
	public Genere findGenereByFilmId(int filmId) throws ServiceException {
		Genere genere = null;
		Film film = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			film = filmDAO.findById(connection, filmId);
													//recuperando genere_id dall'oggetto film 
			genere = genereDAO.findById(connection, film.getGenere().getId());
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return genere;
	}


	@Override
	public Regista findRegistaByFilmId(int filmId) throws ServiceException {
		Regista regista = null;
		Film film = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			film = filmDAO.findById(connection, filmId);
													//recuperando regista_id dall'oggetto film 
			regista = registaDAO.findById(connection, film.getRegista().getId());
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return regista;
	}


}