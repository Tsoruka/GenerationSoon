package it.generationsoon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	// private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
			// private static final String DRIVER = "com.mysql.jdbc.Driver";
			private static final String URL = "jdbc:mysql://localhost:3306/finale?user=root";
			private static final String USER = "root";
			private static final String PASSWORD = "M0vingc@stle";

			private static DataSource instance;

			private DataSource() {
			}

			public static DataSource getInstance() {
				if (instance == null)
					instance = new DataSource();
				return instance;
			}

			public Connection getConnection() throws DAOException {
				try {
					return DriverManager.getConnection(URL, USER, PASSWORD);
				} catch (SQLException e) {
					throw new DAOException(e.getMessage(), e);
				}
			}
}
