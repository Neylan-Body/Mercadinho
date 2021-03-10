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
import model.Fornecedor;

public class FornecedorDAO {

	public boolean create(Fornecedor fornecedor) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO fornecedor (cadastradoEm,email,telefone,celular,situacao,idEndereco)VALUES(?,?,?,?,?,?)");
			preparedStatement.setDate(1, fornecedor.getCadastradoEm());
			preparedStatement.setString(2, fornecedor.getEmail());
			preparedStatement.setString(3, fornecedor.getTelefone());
			preparedStatement.setString(4, fornecedor.getCelular());
			preparedStatement.setString(5, fornecedor.getSituacao());
			preparedStatement.setInt(6, fornecedor.getIdEndereco());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);

			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Fornecedor> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Fornecedor> fornecedors = new ArrayList<Fornecedor>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM fornecedor ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setCodigo(resultSet.getInt(1));
				fornecedor.setCadastradoEm(resultSet.getDate(2));
				fornecedor.setEmail(resultSet.getString(3));
				fornecedor.setTelefone(resultSet.getString(4));
				fornecedor.setCelular(resultSet.getString(5));
				fornecedor.setSituacao(resultSet.getString(7));
				fornecedor.setIdEndereco(resultSet.getInt(8));
				fornecedors.add(fornecedor);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe fornecedor cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedors;
	}

	public boolean update(Fornecedor fornecedor) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE fornecedor SET cadastradoEm = ?, email = ?, telefone = ?, celular = ?, situacao = ?, idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, fornecedor.getCadastradoEm());
			preparedStatement.setString(2, fornecedor.getEmail());
			preparedStatement.setString(3, fornecedor.getTelefone());
			preparedStatement.setString(4, fornecedor.getCelular());
			preparedStatement.setString(5, fornecedor.getSituacao());
			preparedStatement.setInt(6, fornecedor.getIdEndereco());
			preparedStatement.setInt(7, fornecedor.getCodigo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);

			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(Fornecedor fornecedor) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM fornecedor WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedor.getCodigo());
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

