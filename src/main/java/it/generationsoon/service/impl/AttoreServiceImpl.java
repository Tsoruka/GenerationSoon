package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.AttoreDAO;
import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.impl.AttoreDAOImpl;
import it.generationsoon.model.Attore;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.ServiceException;

public class AttoreServiceImpl implements AttoreService {
	
	private AttoreDAO attoreDAO = new AttoreDAOImpl();
	
	public Attore findById(int id) throws ServiceException {
		Attore attore = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			attore = attoreDAO.findById(connection, id);
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


}
