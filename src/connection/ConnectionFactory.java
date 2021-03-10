package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/mercado?autoReconnect=true&useSSL=false";
//	jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
	private static final String USER = "root";
	private static final String PASS = "12071997";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		 try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexão", ex);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
		closeConnection(connection);
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		closeConnection(connection, preparedStatement);
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
