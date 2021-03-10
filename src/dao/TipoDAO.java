package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Tipo;

public class TipoDAO {
	
	public void create(Tipo tipo) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO TIPO (tipo)VALUES(?)");
			preparedStatement.setString(1, tipo.getTipo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Tipo> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Tipo> tipos = new ArrayList<Tipo>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM tipo");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Tipo tipo = new Tipo();
				tipo.setId(resultSet.getInt(1));
				tipo.setTipo(resultSet.getString(2));
				tipos.add(tipo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return tipos;
	}
	
	public Tipo TipoPorId(int id) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Tipo tipo = new Tipo();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM tipo WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipo.setId(resultSet.getInt(1));
				tipo.setTipo(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Tipo inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return tipo;
	}
	
	public Tipo TipoPorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Tipo tipo = new Tipo();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM tipo WHERE tipo = ?");
			preparedStatement.setString(1, nome);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipo.setId(resultSet.getInt(1));
				tipo.setTipo(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Tipo inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return tipo;
	}
	
	public void update(Tipo tipo) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE tipo SET tipo = ? WHERE (id = ?)");
			preparedStatement.setString(1, tipo.getTipo());
			preparedStatement.setInt(2, tipo.getId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}
	
	public void delete(Tipo tipo) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("DELETE FROM tipo WHERE id = ?");
			preparedStatement.setInt(1, tipo.getId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso", "Exclusão", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao excluir", "Exclusão", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

}
