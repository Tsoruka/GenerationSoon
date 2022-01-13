package it.generationsoon.service.impl;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.FilmDAO;
import it.generationsoon.dao.GenereDAO;
import it.generationsoon.dao.RegistaDAO;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.dao.VotoUtenteFilmDAO;
import it.generationsoon.dao.impl.FilmDAOImpl;
import it.generationsoon.dao.impl.GenereDAOImpl;
import it.generationsoon.dao.impl.RegistaDAOImpl;
import it.generationsoon.dao.impl.RuoloDAOImpl;
import it.generationsoon.dao.impl.VotoUtenteFilmDAOImpl;
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
	private RuoloDAO ruoloDAO = new RuoloDAOImpl();
	//richiamo la DAO corrispondente alla tabella voto_film
	private VotoUtenteFilmDAO votoUtenteFilmDAO= new VotoUtenteFilmDAOImpl();
	
	public Film findById(int id) throws ServiceException {
		Film film = null;
		Connection connection = null;
		List<Ruolo> cast = new ArrayList<Ruolo>();
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			film = filmDAO.findById(connection, id);
			//richiamo la DAO corrispondente alla tabella voto_film
			double mediaVotoFilm = votoUtenteFilmDAO.mediaVotoFilm(connection, id);
			//formattazione media voto alla prima cifra significativa 
			
//			DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ITALIAN);
//			otherSymbols.setDecimalSeparator(',');
//			otherSymbols.setGroupingSeparator('.'); 
//			DecimalFormat df = new DecimalFormat("0.0", otherSymbols);

			film.setMediaVoti(mediaVotoFilm);
			
			Genere genere = genereDAO.findById(connection, film.getGenere().getId());
			Regista regista = registaDAO.findById(connection, film.getRegista().getId());
			
			film.setGenere(genere);
			film.setRegista(regista);
			
			//TODO: LISTA DI ATTORI
			cast = ruoloDAO.findCastByFilmId(connection, id);
			
			film.setAttori(cast);
			
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
	public List<Film> findAll() throws ServiceException {
		List<Film> listaFilm= new ArrayList<Film>(); 

		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			listaFilm = filmDAO.findAll(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return listaFilm;
	}

	@Override
	public List<Film> findByTitolo(String titolo) throws ServiceException {
		List<Film> listaFilm= new ArrayList<Film>(); 

		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			listaFilm = filmDAO.findByTitolo(connection, titolo);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return listaFilm;
	}

	@Override
	public List<Film> filterByGenereAndAnno(String genere, int anno) throws ServiceException {
		List<Film> listaFilm= new ArrayList<Film>(); 

		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			listaFilm = filmDAO.filterByGenereAndAnno(connection, genere, anno);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return listaFilm;
	}

	@Override
	public List<Film> OrderByVoto() throws ServiceException {
		List<Film> listaFilm= new ArrayList<Film>(); 
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			listaFilm = filmDAO.OrderByVoto(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return listaFilm;
	}

	@Override
	public List<Film> findMarvel() throws ServiceException {
		List<Film> marvel = new ArrayList<Film>();
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			marvel = filmDAO.findMarvel(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return marvel;
	}	



}