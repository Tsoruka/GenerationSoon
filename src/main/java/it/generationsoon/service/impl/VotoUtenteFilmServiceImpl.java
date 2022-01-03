package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.VotoUtenteFilmDAO;
import it.generationsoon.dao.impl.VotoUtenteFilmDAOImpl;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.VotoUtenteFilmService;

public class VotoUtenteFilmServiceImpl implements VotoUtenteFilmService  {
	
	private VotoUtenteFilmDAO votoUtenteFilmDAO = new VotoUtenteFilmDAOImpl();

	@Override
	public void update(int filmId, int utenteId, int voto) throws ServiceException {

		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			votoUtenteFilmDAO.update(connection, filmId, utenteId, voto);
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
	public void save(int filmId, int utenteId, int voto) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			votoUtenteFilmDAO.save(connection, filmId, utenteId, voto);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		
	}


	@Override
	public int votato(int filmId, int utenteId) throws ServiceException {
		int voted = 0;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			voted = votoUtenteFilmDAO.votato(connection, filmId, utenteId);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return voted;
	}


}
