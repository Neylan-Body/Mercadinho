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
import model.ClientePessoaFisica;
import model.Endereco;

public class ClientePessoaFisicaDAO {

	public boolean create(ClientePessoaFisica clientePessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, clientePessoaFisica.getCep());
			preparedStatement.setString(2, clientePessoaFisica.getLogradouro());
			preparedStatement.setString(3, clientePessoaFisica.getNumero());
			preparedStatement.setString(4, clientePessoaFisica.getComplemento());
			preparedStatement.setString(5, clientePessoaFisica.getBairro());
			preparedStatement.setString(6, clientePessoaFisica.getMunicipio());
			preparedStatement.setString(7, clientePessoaFisica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(clientePessoaFisica.getBairro());
			endereco.setCep(clientePessoaFisica.getCep());
			endereco.setComplemento(clientePessoaFisica.getComplemento());
			endereco.setLogradouro(clientePessoaFisica.getLogradouro());
			endereco.setMunicipio(clientePessoaFisica.getMunicipio());
			endereco.setNumero(clientePessoaFisica.getNumero());
			endereco.setUf(clientePessoaFisica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					clientePessoaFisica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					JOptionPane.showMessageDialog(null, "Altere o endereço");
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				}
			}
			if (opc == 0 && ClientePessoaFisicaPorCPF(clientePessoaFisica)
					&& ClientePessoaFisicaPorRG(clientePessoaFisica)) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO cliente (cadastradoEm,email,telefone,celular,credito,situacao,idEndereco)VALUES(?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDate(1, clientePessoaFisica.getCadastradoEm());
				preparedStatement.setString(2, clientePessoaFisica.getEmail());
				preparedStatement.setString(3, clientePessoaFisica.getTelefone());
				preparedStatement.setString(4, clientePessoaFisica.getCelular());
				preparedStatement.setDouble(5, clientePessoaFisica.getCredito());
				preparedStatement.setString(6, clientePessoaFisica.getSituacao());
				preparedStatement.setInt(7, clientePessoaFisica.getIdEndereco());
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaFisica.setCodigo(resultSet.getInt(1));
				}
				preparedStatement = connection.prepareStatement(
						"INSERT INTO clientepessoafisica (codigo,nome,cpf,rg,orgaoEmissor,dtEmissao,estadoCivil,dtNascimento,nacionalidade,ufDoc,naturalidade,sexo)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, clientePessoaFisica.getCodigo());
				preparedStatement.setString(2, clientePessoaFisica.getNome());
				preparedStatement.setString(3, clientePessoaFisica.getCpf());
				preparedStatement.setString(4, clientePessoaFisica.getRg());
				preparedStatement.setString(5, clientePessoaFisica.getOrgaoEmissor());
				preparedStatement.setDate(6, clientePessoaFisica.getDtEmissao());
				preparedStatement.setString(7, clientePessoaFisica.getEstadoCivil());
				preparedStatement.setDate(8, clientePessoaFisica.getDtNascimento());
				preparedStatement.setString(9, clientePessoaFisica.getNacionalidade());
				preparedStatement.setString(10, clientePessoaFisica.getUfDoc());
				preparedStatement.setString(11, clientePessoaFisica.getNaturalidade());
				preparedStatement.setString(12, clientePessoaFisica.getSexo());
				preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
				ConnectionFactory.closeConnection(connection, preparedStatement);
				return true;
			}
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<ClientePessoaFisica> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ClientePessoaFisica> clientesPessoasFisicas = new ArrayList<ClientePessoaFisica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
				clientesPessoasFisicas.add(clientePessoaFisica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe cliente pessoa fisica cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientesPessoasFisicas;
	}

	public ArrayList<ClientePessoaFisica> ClientePessoaFisicasPorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ClientePessoaFisica> clientePessoaFisicas = new ArrayList<ClientePessoaFisica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco WHERE nome LIKE ? ORDER BY nome");
			preparedStatement.setString(1, "%" + nome + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
				clientePessoaFisicas.add(clientePessoaFisica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Esta nome não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientePessoaFisicas;
	}

	public ClientePessoaFisica ClientePessoaFisicaPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
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
		return clientePessoaFisica;
	}

	public ClientePessoaFisica ClientePessoaFisicaPorCPF(String CPF) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco WHERE cpf = ?");
			preparedStatement.setString(1, CPF);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
			} else {
				JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return clientePessoaFisica;
	}

	public boolean ClientePessoaFisicaPorCPF(ClientePessoaFisica clientePessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco WHERE cpf = ?");
			preparedStatement.setString(1, clientePessoaFisica.getCpf());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				JOptionPane.showMessageDialog(null, "Este CPF Ja existe", "Cadastro", JOptionPane.ERROR_MESSAGE);
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

	public boolean ClientePessoaFisicaPorRG(ClientePessoaFisica clientePessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM clientePessoaFisica NATURAL JOIN cliente NATURAL JOIN endereco WHERE rg = ?");
			preparedStatement.setString(1, clientePessoaFisica.getRg());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				clientePessoaFisica.setCodigo(resultSet.getInt(2));
				clientePessoaFisica.setNome(resultSet.getString(3));
				clientePessoaFisica.setCpf(resultSet.getString(4));
				clientePessoaFisica.setRg(resultSet.getString(5));
				clientePessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				clientePessoaFisica.setDtEmissao(resultSet.getDate(7));
				clientePessoaFisica.setEstadoCivil(resultSet.getString(8));
				clientePessoaFisica.setDtNascimento(resultSet.getDate(9));
				clientePessoaFisica.setNacionalidade(resultSet.getString(10));
				clientePessoaFisica.setUfDoc(resultSet.getString(11));
				clientePessoaFisica.setNaturalidade(resultSet.getString(12));
				clientePessoaFisica.setSexo(resultSet.getString(13));
				clientePessoaFisica.setCadastradoEm(resultSet.getDate(14));
				clientePessoaFisica.setEmail(resultSet.getString(15));
				clientePessoaFisica.setTelefone(resultSet.getString(16));
				clientePessoaFisica.setCelular(resultSet.getString(17));
				clientePessoaFisica.setCredito(resultSet.getDouble(18));
				clientePessoaFisica.setSituacao(resultSet.getString(19));
				clientePessoaFisica.setCep(resultSet.getString(20));
				clientePessoaFisica.setLogradouro(resultSet.getString(21));
				clientePessoaFisica.setNumero(resultSet.getString(22));
				clientePessoaFisica.setComplemento(resultSet.getString(23));
				clientePessoaFisica.setBairro(resultSet.getString(24));
				clientePessoaFisica.setMunicipio(resultSet.getString(25));
				clientePessoaFisica.setUf(resultSet.getString(26));
				ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
				JOptionPane.showMessageDialog(null, "Este RG Ja existe", "Cadastro", JOptionPane.ERROR_MESSAGE);
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

	public boolean update(ClientePessoaFisica clientePessoaFisica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, clientePessoaFisica.getCep());
			preparedStatement.setString(2, clientePessoaFisica.getLogradouro());
			preparedStatement.setString(3, clientePessoaFisica.getNumero());
			preparedStatement.setString(4, clientePessoaFisica.getComplemento());
			preparedStatement.setString(5, clientePessoaFisica.getBairro());
			preparedStatement.setString(6, clientePessoaFisica.getMunicipio());
			preparedStatement.setString(7, clientePessoaFisica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(clientePessoaFisica.getBairro());
			endereco.setCep(clientePessoaFisica.getCep());
			endereco.setComplemento(clientePessoaFisica.getComplemento());
			endereco.setLogradouro(clientePessoaFisica.getLogradouro());
			endereco.setMunicipio(clientePessoaFisica.getMunicipio());
			endereco.setNumero(clientePessoaFisica.getNumero());
			endereco.setUf(clientePessoaFisica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					clientePessoaFisica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					ConnectionFactory.closeConnection(connection, preparedStatement);
					JOptionPane.showMessageDialog(null, "Altere o endereço");
					return false;
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					clientePessoaFisica.setIdEndereco(resultSet.getInt(1));
				}
			}
			ClienteDAO clienteDAO = new ClienteDAO();
			preparedStatement = connection.prepareStatement(
					"UPDATE cliente SET cadastradoEm = ?,email = ?,telefone = ?,celular = ?,credito = ?,situacao = ?,idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, clientePessoaFisica.getCadastradoEm());
			preparedStatement.setString(2, clientePessoaFisica.getEmail());
			preparedStatement.setString(3, clientePessoaFisica.getTelefone());
			preparedStatement.setString(4, clientePessoaFisica.getCelular());
			preparedStatement.setDouble(5, clientePessoaFisica.getCredito());
			preparedStatement.setString(6, clientePessoaFisica.getSituacao());
			preparedStatement.setInt(7, clientePessoaFisica.getIdEndereco());
			preparedStatement.setInt(8, clientePessoaFisica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(
					"UPDATE clientepessoafisica SET nome = ?,cpf = ?,rg = ?,orgaoEmissor = ?,dtEmissao = ?,estadoCivil = ?,dtNascimento = ?,nacionalidade = ?,ufDoc = ?,naturalidade = ?,sexo = ? WHERE codigo = ?");
			preparedStatement.setString(1, clientePessoaFisica.getNome());
			preparedStatement.setString(2, clientePessoaFisica.getCpf());
			preparedStatement.setString(3, clientePessoaFisica.getRg());
			preparedStatement.setString(4, clientePessoaFisica.getOrgaoEmissor());
			preparedStatement.setDate(5, clientePessoaFisica.getDtEmissao());
			preparedStatement.setString(6, clientePessoaFisica.getEstadoCivil());
			preparedStatement.setDate(7, clientePessoaFisica.getDtNascimento());
			preparedStatement.setString(8, clientePessoaFisica.getNacionalidade());
			preparedStatement.setString(9, clientePessoaFisica.getUfDoc());
			preparedStatement.setString(10, clientePessoaFisica.getNaturalidade());
			preparedStatement.setString(11, clientePessoaFisica.getSexo());
			preparedStatement.setInt(12, clientePessoaFisica.getCodigo());
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

	public void delete(ClientePessoaFisica clientePessoaFisica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM clientePessoaFisica WHERE codigo = ?");
			preparedStatement.setInt(1, clientePessoaFisica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
			preparedStatement.setInt(1, clientePessoaFisica.getCodigo());
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
