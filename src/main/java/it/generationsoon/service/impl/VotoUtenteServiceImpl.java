package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.VotoUtenteDAO;
import it.generationsoon.dao.impl.VotoUtenteDAOImpl;
import it.generationsoon.model.VotoUtente;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.VotoUtenteService;

public class VotoUtenteServiceImpl implements VotoUtenteService  {
	
	private VotoUtenteDAO votoUtenteDAO = new VotoUtenteDAOImpl();

	
	public VotoUtente findById(int id) throws ServiceException {
		VotoUtente votoUtente = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			votoUtente = votoUtenteDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return votoUtente;
	}


	@Override
	public void update(VotoUtente votoUtente) throws ServiceException {

		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			votoUtenteDAO.update(connection, votoUtente);
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
	public int votoUtenteId(int utente_id, int film_id) throws ServiceException {
		Connection connection = null;
		int utenteId = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenteId = votoUtenteDAO.findIdVotoUtente(connection, utente_id, film_id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return utenteId;
	}


	@Override
	public void save(VotoUtente votoutente) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			votoUtenteDAO.save(connection, votoutente);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		
	}

}
