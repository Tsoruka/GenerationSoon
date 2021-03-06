package it.generationsoon.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.generationsoon.dao.AttoreDAO;
import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.dao.impl.AttoreDAOImpl;
import it.generationsoon.dao.impl.RuoloDAOImpl;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Ruolo;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.ServiceException;

public class AttoreServiceImpl implements AttoreService {
	
	private AttoreDAO attoreDAO = new AttoreDAOImpl();
	private RuoloDAO ruoloDAO = new RuoloDAOImpl();
	
	public Attore findById(int id) throws ServiceException {
		Attore attore = null;
		Connection connection = null;
		List<Ruolo> film = new ArrayList<Ruolo>();
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			attore = attoreDAO.findById(connection, id);
			
			film = ruoloDAO.findFilmByAttoreId(connection, id);
			attore.setFilm(film);
			
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return attore;
	}

	@Override
	public List<Attore> findAll() throws ServiceException {
		List<Attore> listaAttore = new ArrayList<Attore>(); 

		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			listaAttore = attoreDAO.findAll(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return listaAttore;
	}


}
