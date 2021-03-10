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
import model.Ocupacao;

public class OcupacaoDAO {
	
	public void create(Ocupacao ocupacao) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO ocupacao (nome)VALUES(?)");
			preparedStatement.setString(1, ocupacao.getOcupacao());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Ocupacao> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Ocupacao> ocupacaos = new ArrayList<Ocupacao>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM ocupacao");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Ocupacao ocupacao = new Ocupacao();
				ocupacao.setId(resultSet.getInt(1));
				ocupacao.setOcupacao(resultSet.getString(2));
				ocupacaos.add(ocupacao);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return ocupacaos;
	}
	
	public Ocupacao OcupacaoPorId(int id) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Ocupacao ocupacao = new Ocupacao();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM ocupacao WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ocupacao.setId(resultSet.getInt(1));
				ocupacao.setOcupacao(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocupacao inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return ocupacao;
	}
	
	public Ocupacao OcupacaoPorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Ocupacao ocupacao = new Ocupacao();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM ocupacao WHERE nome = ?");
			preparedStatement.setString(1, nome);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ocupacao.setId(resultSet.getInt(1));
				ocupacao.setOcupacao(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocupacao inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return ocupacao;
	}
	
	public void update(Ocupacao ocupacao) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE ocupacao SET nome = ? WHERE (id = ?)");
			preparedStatement.setString(1, ocupacao.getOcupacao());
			preparedStatement.setInt(2, ocupacao.getId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}
	
	public void delete(Ocupacao ocupacao) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("DELETE FROM ocupacao WHERE id = ?");
			preparedStatement.setInt(1, ocupacao.getId());
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
