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
import model.Cliente;

public class ClienteDAO {

	public boolean create(Cliente cliente) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO cliente (cadastradoEm,email,telefone,celular,credito,situacao,idEndereco)VALUES(?,?,?,?,?,?,?)");
			preparedStatement.setDate(1, cliente.getCadastradoEm());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.setString(4, cliente.getCelular());
			preparedStatement.setDouble(5, cliente.getCredito());
			preparedStatement.setString(6, cliente.getSituacao());
			preparedStatement.setInt(7, cliente.getIdEndereco());
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

	public ArrayList<Cliente> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM cliente ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();

				cliente.setCodigo(resultSet.getInt(1));
				cliente.setCadastradoEm(resultSet.getDate(2));
				cliente.setEmail(resultSet.getString(3));
				cliente.setTelefone(resultSet.getString(4));
				cliente.setCelular(resultSet.getString(5));
				cliente.setCredito(resultSet.getDouble(6));
				cliente.setSituacao(resultSet.getString(7));
				cliente.setIdEndereco(resultSet.getInt(8));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe cliente cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientes;
	}

	public boolean update(Cliente cliente) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE cliente SET cadastradoEm = ?, email = ?, telefone = ?, celular = ?, credito = ?, situacao = ?, idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, cliente.getCadastradoEm());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.setString(4, cliente.getCelular());
			preparedStatement.setDouble(5, cliente.getCredito());
			preparedStatement.setString(6, cliente.getSituacao());
			preparedStatement.setInt(7, cliente.getIdEndereco());
			preparedStatement.setInt(8, cliente.getCodigo());
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

	public void delete(Cliente cliente) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
			preparedStatement.setInt(1, cliente.getCodigo());
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
