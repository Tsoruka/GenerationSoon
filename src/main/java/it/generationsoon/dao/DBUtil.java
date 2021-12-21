package it.generationsoon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	public static void setAutoCommit(Connection connection, boolean autoCommit) throws DAOException {
		try {
			if (connection != null)
				connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
	}

	public static void commit(Connection connection) throws DAOException {
		try {
			if (connection != null)
				connection.commit();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
	}

	public static void rollback(Connection connection) {
		try {
			if (connection != null)
				connection.rollback();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
