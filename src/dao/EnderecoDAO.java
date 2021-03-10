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
import model.Endereco;
import model.Tipo;

public class EnderecoDAO {

	public boolean create(Endereco endereco) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setString(3, endereco.getComplemento());
			preparedStatement.setString(4, endereco.getBairro());
			preparedStatement.setString(5, endereco.getMunicipio());
			preparedStatement.setString(6, endereco.getUf());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Endereco> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM endereco");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Endereco endereco = new Endereco();
				endereco.setIdEndereco(resultSet.getInt(1));
				endereco.setCep(resultSet.getString(2));
				endereco.setLogradouro(resultSet.getString(3));
				endereco.setComplemento(resultSet.getString(4));
				endereco.setBairro(resultSet.getString(5));
				endereco.setMunicipio(resultSet.getString(6));
				endereco.setUf(resultSet.getString(7));
				enderecos.add(endereco);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return enderecos;
	}

	public Endereco EnderecoPorId(int idEndereco) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Endereco endereco = new Endereco();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM endereco WHERE idEndereco = ?");
			preparedStatement.setInt(1, idEndereco);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				endereco.setIdEndereco(resultSet.getInt(1));
				endereco.setCep(resultSet.getString(2));
				endereco.setLogradouro(resultSet.getString(3));
				endereco.setComplemento(resultSet.getString(4));
				endereco.setBairro(resultSet.getString(5));
				endereco.setMunicipio(resultSet.getString(6));
				endereco.setUf(resultSet.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Endereco inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return endereco;
	}

	public Endereco EnderecoPorConjunto(Endereco endereco) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Tipo tipo = new Tipo();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM endereco WHERE cep = ? and logradouro = ? and numero = ? and complemento = ? and bairro = ? and municipio = ? and uf = ?");
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setString(3, endereco.getNumero());
			preparedStatement.setString(4, endereco.getComplemento());
			preparedStatement.setString(5, endereco.getBairro());
			preparedStatement.setString(6, endereco.getMunicipio());
			preparedStatement.setString(7, endereco.getUf());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				endereco.setIdEndereco(resultSet.getInt(1));
				endereco.setCep(resultSet.getString(2));
				endereco.setLogradouro(resultSet.getString(3));
				endereco.setNumero(resultSet.getString(4));
				endereco.setComplemento(resultSet.getString(5));
				endereco.setBairro(resultSet.getString(6));
				endereco.setMunicipio(resultSet.getString(7));
				endereco.setUf(resultSet.getString(8));
			} else {
				JOptionPane.showMessageDialog(null, "Endereco inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Endereco inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return endereco;
	}
	
	public boolean Existe(Endereco endereco) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Tipo tipo = new Tipo();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM endereco WHERE cep = ? and logradouro = ? and numero = ? and complemento = ? and bairro = ? and municipio = ? and uf = ?");
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setString(3, endereco.getNumero());
			preparedStatement.setString(4, endereco.getComplemento());
			preparedStatement.setString(5, endereco.getBairro());
			preparedStatement.setString(6, endereco.getMunicipio());
			preparedStatement.setString(7, endereco.getUf());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				endereco.setIdEndereco(resultSet.getInt(1));
				endereco.setCep(resultSet.getString(2));
				endereco.setLogradouro(resultSet.getString(3));
				endereco.setNumero(resultSet.getString(4));
				endereco.setComplemento(resultSet.getString(5));
				endereco.setBairro(resultSet.getString(6));
				endereco.setMunicipio(resultSet.getString(7));
				endereco.setUf(resultSet.getString(8));
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				return true;
			} else {
//				JOptionPane.showMessageDialog(null, "Endereco inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				return false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Endereco inexistente", "Busca", JOptionPane.ERROR_MESSAGE);
		} 
		return false;
	}

	public void update(Endereco endereco) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE endereco SET cep = ?,logradouro = ?,complemento = ?,bairro = ?,municipio = ?,uf = ? WHERE idEndereco = ?");
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setString(3, endereco.getComplemento());
			preparedStatement.setString(4, endereco.getBairro());
			preparedStatement.setString(5, endereco.getMunicipio());
			preparedStatement.setString(6, endereco.getUf());
			preparedStatement.setInt(7, endereco.getIdEndereco());
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(Endereco endereco) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM endereco WHERE idEndereco = ?");
			preparedStatement.setInt(1, endereco.getIdEndereco());
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
