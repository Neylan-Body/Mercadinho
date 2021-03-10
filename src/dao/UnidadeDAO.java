
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
import model.Unidade;

public class UnidadeDAO {

	public void create(Unidade unidade) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO UNIDADE (unidade)VALUES(?)");
			preparedStatement.setString(1, unidade.getUnidade());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Unidade> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Unidade> unidades = new ArrayList<Unidade>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM unidade");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Unidade unidade = new Unidade();
				unidade.setId(resultSet.getInt(1));
				unidade.setUnidade(resultSet.getString(2));
				unidades.add(unidade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return unidades;
	}
	
	public Unidade UnidadePorId(int id) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Unidade unidade = new Unidade();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM unidade WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				unidade.setId(resultSet.getInt(1));
				unidade.setUnidade(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Unidade inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return unidade;
	}
	
	public Unidade UnidadePorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Unidade unidade = new Unidade();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM unidade WHERE unidade = ?");
			preparedStatement.setString(1, nome);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				unidade.setId(resultSet.getInt(1));
				unidade.setUnidade(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Unidade inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return unidade;
	}

	public void update(Unidade unidade) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE unidade SET unidade = ? WHERE (id = ?)");
			preparedStatement.setString(1, unidade.getUnidade());
			preparedStatement.setInt(2, unidade.getId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(Unidade unidade) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM unidade WHERE id = ?");
			preparedStatement.setInt(1, unidade.getId());
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
