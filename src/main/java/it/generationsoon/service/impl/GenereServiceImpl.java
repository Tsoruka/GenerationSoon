package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.GenereDAO;
import it.generationsoon.dao.impl.GenereDAOImpl;
import it.generationsoon.model.Genere;
import it.generationsoon.service.GenereService;
import it.generationsoon.service.ServiceException;

public class GenereServiceImpl implements GenereService  {
	
	private GenereDAO genereDAO = new GenereDAOImpl();

	
	public Genere findById(int id) throws ServiceException {
		Genere genere = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			genere = genereDAO.findById(connection, id);
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

}