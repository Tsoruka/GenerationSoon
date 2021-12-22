package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.RegistaDAO;
import it.generationsoon.dao.impl.RegistaDAOImpl;
import it.generationsoon.model.Regista;
import it.generationsoon.service.RegistaService;
import it.generationsoon.service.ServiceException;

public class RegistaServiceImpl implements RegistaService  {
	
	private RegistaDAO registaDAO = new RegistaDAOImpl();

	
	public Regista findById(int id) throws ServiceException {
		Regista regista = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			regista = registaDAO.findById(connection, id);
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
