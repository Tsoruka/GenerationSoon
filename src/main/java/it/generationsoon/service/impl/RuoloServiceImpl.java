package it.generationsoon.service.impl;

import java.sql.Connection;

import it.generationsoon.dao.DAOException;
import it.generationsoon.dao.DBUtil;
import it.generationsoon.dao.DataSource;
import it.generationsoon.dao.RuoloDAO;
import it.generationsoon.dao.impl.RuoloDAOImpl;
import it.generationsoon.model.Ruolo;
import it.generationsoon.service.RuoloService;
import it.generationsoon.service.ServiceException;

public class RuoloServiceImpl implements RuoloService  {
	
	private RuoloDAO ruoloDAO = new RuoloDAOImpl();

	
	public Ruolo findById(int id) throws ServiceException {
		Ruolo ruolo = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			ruolo = ruoloDAO.findById(connection, id);
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