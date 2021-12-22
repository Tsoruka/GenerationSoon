package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.UtenteDAO;
import it.generationsoon.dao.impl.UtenteDAOImpl;
import it.generationsoon.model.Utente;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.UtenteService;

public class UtenteServiceImpl implements UtenteService{

	private UtenteDAO utenteDAO = new UtenteDAOImpl();
	
	@Override
	public void save(Utente utente) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenteDAO.save(connection, utente);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Utente findById(int id) throws ServiceException {
		Utente utente = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utente = utenteDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return utente;
	}

	@Override
	public Utente findByUsername(String username) throws ServiceException {
		Utente utente = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utente = utenteDAO.findByUsername(connection, username);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return utente;
	}

}
