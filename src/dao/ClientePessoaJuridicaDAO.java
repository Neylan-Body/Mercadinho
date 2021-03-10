package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import connection.ConnectionFactory;
import model.ClientePessoaJuridica;
import model.Endereco;

public class ClientePessoaJuridicaDAO {

	public boolean create(ClientePessoaJuridica clientePessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, clientePessoaJuridica.getCep());
			preparedStatement.setString(2, clientePessoaJuridica.getLogradouro());
			preparedStatement.setString(3, clientePessoaJuridica.getNumero());
			preparedStatement.setString(4, clientePessoaJuridica.getComplemento());
			preparedStatement.setString(5, clientePessoaJuridica.getBairro());
			preparedStatement.setString(6, clientePessoaJuridica.getMunicipio());
			preparedStatement.setString(7, clientePessoaJuridica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(clientePessoaJuridica.getBairro());
			endereco.setCep(clientePessoaJuridica.getCep());
			endereco.setComplemento(clientePessoaJuridica.getComplemento());
			endereco.setLogradouro(clientePessoaJuridica.getLogradouro());
			endereco.setMunicipio(clientePessoaJuridica.getMunicipio());
			endereco.setNumero(clientePessoaJuridica.getNumero());
			endereco.setUf(clientePessoaJuridica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					clientePessoaJuridica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					JOptionPane.showMessageDialog(null, "Altere o endereço");
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				}
			}
			if (opc == 0 && ClientePessoaJuridicaPorCNPJ(clientePessoaJuridica)
					&& ClientePessoaJuridicaPorIE(clientePessoaJuridica)) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO cliente (cadastradoEm,email,telefone,celular,credito,situacao,idEndereco)VALUES(?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDate(1, clientePessoaJuridica.getCadastradoEm());
				preparedStatement.setString(2, clientePessoaJuridica.getEmail());
				preparedStatement.setString(3, clientePessoaJuridica.getTelefone());
				preparedStatement.setString(4, clientePessoaJuridica.getCelular());
				preparedStatement.setDouble(5, clientePessoaJuridica.getCredito());
				preparedStatement.setString(6, clientePessoaJuridica.getSituacao());
				preparedStatement.setInt(7, clientePessoaJuridica.getIdEndereco());
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaJuridica.setCodigo(resultSet.getInt(1));
				}
				preparedStatement = connection.prepareStatement(
						"INSERT INTO clientepessoajuridica (codigo,razaoSocial,cnpj,ie,abertura)VALUES(?,?,?,?,?)");
				preparedStatement.setInt(1, clientePessoaJuridica.getCodigo());
				preparedStatement.setString(2, clientePessoaJuridica.getRazaoSocial());
				preparedStatement.setString(3, clientePessoaJuridica.getCnpj());
				preparedStatement.setString(4, clientePessoaJuridica.getIe());
				preparedStatement.setDate(5, clientePessoaJuridica.getAbertura());
				preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
				ConnectionFactory.closeConnection(connection, preparedStatement);
				return true;
			}
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<ClientePessoaJuridica> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ClientePessoaJuridica> clientesPessoasJuridicas = new ArrayList<ClientePessoaJuridica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco ORDER BY razaoSocial");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
				clientesPessoasJuridicas.add(clientePessoaJuridica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe cliente pessoa juridica cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientesPessoasJuridicas;
	}

	public ArrayList<ClientePessoaJuridica> ClientePessoaJuridicasPorRazaoSocial(String razaoSocial) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ClientePessoaJuridica> clientePessoaJuridicas = new ArrayList<ClientePessoaJuridica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco WHERE razaoSocial LIKE ? ORDER BY razaoSocial");
			preparedStatement.setString(1, "%" + razaoSocial + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
				clientePessoaJuridicas.add(clientePessoaJuridica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Esta nome não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientePessoaJuridicas;
	}

	public ClientePessoaJuridica ClientePessoaJuridicaPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
			} else {
				JOptionPane.showMessageDialog(null, "Este codigo não foi cadastrado", "Busca",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este codigo não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientePessoaJuridica;
	}

	public ClientePessoaJuridica ClientePessoaJuridicaPorCNPJ(String CNPJ) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco WHERE cnpj = ?");
			preparedStatement.setString(1, CNPJ);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
			} else {
				JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientePessoaJuridica;
	}

	public boolean ClientePessoaJuridicaPorCNPJ(ClientePessoaJuridica clientePessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco WHERE cnpj = ?");
			preparedStatement.setString(1, clientePessoaJuridica.getCnpj());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				JOptionPane.showMessageDialog(null, "Este CNPJ ja existe", "Cadastro", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
//				JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				return true;
			}
		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
	}

	public boolean ClientePessoaJuridicaPorIE(ClientePessoaJuridica clientePessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaJuridica NATURAL JOIN cliente NATURAL JOIN endereco WHERE ie = ?");
			preparedStatement.setString(1, clientePessoaJuridica.getIe());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				clientePessoaJuridica.setCodigo(resultSet.getInt(2));
				clientePessoaJuridica.setRazaoSocial(resultSet.getString(3));
				clientePessoaJuridica.setCnpj(resultSet.getString(4));
				clientePessoaJuridica.setIe(resultSet.getString(5));
				clientePessoaJuridica.setAbertura(resultSet.getDate(6));
				clientePessoaJuridica.setCadastradoEm(resultSet.getDate(7));
				clientePessoaJuridica.setEmail(resultSet.getString(8));
				clientePessoaJuridica.setTelefone(resultSet.getString(9));
				clientePessoaJuridica.setCelular(resultSet.getString(10));
				clientePessoaJuridica.setCredito(resultSet.getDouble(11));
				clientePessoaJuridica.setSituacao(resultSet.getString(12));
				clientePessoaJuridica.setCep(resultSet.getString(13));
				clientePessoaJuridica.setLogradouro(resultSet.getString(14));
				clientePessoaJuridica.setNumero(resultSet.getString(15));
				clientePessoaJuridica.setComplemento(resultSet.getString(16));
				clientePessoaJuridica.setBairro(resultSet.getString(17));
				clientePessoaJuridica.setMunicipio(resultSet.getString(18));
				clientePessoaJuridica.setUf(resultSet.getString(19));
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				JOptionPane.showMessageDialog(null, "Este IE Ja existe", "Cadastro", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
//				JOptionPane.showMessageDialog(null, "Este RG não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				return true;
			}
		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Este RG não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
	}

	public boolean update(ClientePessoaJuridica clientePessoaJuridica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, clientePessoaJuridica.getCep());
			preparedStatement.setString(2, clientePessoaJuridica.getLogradouro());
			preparedStatement.setString(3, clientePessoaJuridica.getNumero());
			preparedStatement.setString(4, clientePessoaJuridica.getComplemento());
			preparedStatement.setString(5, clientePessoaJuridica.getBairro());
			preparedStatement.setString(6, clientePessoaJuridica.getMunicipio());
			preparedStatement.setString(7, clientePessoaJuridica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(clientePessoaJuridica.getBairro());
			endereco.setCep(clientePessoaJuridica.getCep());
			endereco.setComplemento(clientePessoaJuridica.getComplemento());
			endereco.setLogradouro(clientePessoaJuridica.getLogradouro());
			endereco.setMunicipio(clientePessoaJuridica.getMunicipio());
			endereco.setNumero(clientePessoaJuridica.getNumero());
			endereco.setUf(clientePessoaJuridica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					clientePessoaJuridica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					ConnectionFactory.closeConnection(connection, preparedStatement);
					JOptionPane.showMessageDialog(null, "Altere o endereço");
					return false;
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaJuridica.setIdEndereco(resultSet.getInt(1));
				}
			}
			ClienteDAO clienteDAO = new ClienteDAO();
			preparedStatement = connection.prepareStatement(
					"UPDATE cliente SET cadastradoEm = ?,email = ?,telefone = ?,celular = ?,credito = ?,situacao = ?,idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, clientePessoaJuridica.getCadastradoEm());
			preparedStatement.setString(2, clientePessoaJuridica.getEmail());
			preparedStatement.setString(3, clientePessoaJuridica.getTelefone());
			preparedStatement.setString(4, clientePessoaJuridica.getCelular());
			preparedStatement.setDouble(5, clientePessoaJuridica.getCredito());
			preparedStatement.setString(6, clientePessoaJuridica.getSituacao());
			preparedStatement.setInt(7, clientePessoaJuridica.getIdEndereco());
			preparedStatement.setInt(8, clientePessoaJuridica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(
					"UPDATE clientepessoajuridica SET codigo = ?,razaoSocial = ?,cnpj = ?,ie = ?,abertura = ? WHERE codigo = ?");
			preparedStatement.setInt(1, clientePessoaJuridica.getCodigo());
			preparedStatement.setString(2, clientePessoaJuridica.getRazaoSocial());
			preparedStatement.setString(3, clientePessoaJuridica.getCnpj());
			preparedStatement.setString(4, clientePessoaJuridica.getIe());
			preparedStatement.setDate(5, clientePessoaJuridica.getAbertura());
			preparedStatement.setInt(6, clientePessoaJuridica.getCodigo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(ClientePessoaJuridica clientePessoaJuridica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM clientePessoaJuridica WHERE codigo = ?");
			preparedStatement.setInt(1, clientePessoaJuridica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
			preparedStatement.setInt(1, clientePessoaJuridica.getCodigo());
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
