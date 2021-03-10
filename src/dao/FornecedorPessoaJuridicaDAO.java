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
import model.FornecedorPessoaJuridica;
import model.Endereco;

public class FornecedorPessoaJuridicaDAO {

	public boolean create(FornecedorPessoaJuridica fornecedorPessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, fornecedorPessoaJuridica.getCep());
			preparedStatement.setString(2, fornecedorPessoaJuridica.getLogradouro());
			preparedStatement.setString(3, fornecedorPessoaJuridica.getNumero());
			preparedStatement.setString(4, fornecedorPessoaJuridica.getComplemento());
			preparedStatement.setString(5, fornecedorPessoaJuridica.getBairro());
			preparedStatement.setString(6, fornecedorPessoaJuridica.getMunicipio());
			preparedStatement.setString(7, fornecedorPessoaJuridica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(fornecedorPessoaJuridica.getBairro());
			endereco.setCep(fornecedorPessoaJuridica.getCep());
			endereco.setComplemento(fornecedorPessoaJuridica.getComplemento());
			endereco.setLogradouro(fornecedorPessoaJuridica.getLogradouro());
			endereco.setMunicipio(fornecedorPessoaJuridica.getMunicipio());
			endereco.setNumero(fornecedorPessoaJuridica.getNumero());
			endereco.setUf(fornecedorPessoaJuridica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					fornecedorPessoaJuridica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					JOptionPane.showMessageDialog(null, "Altere o endereço");
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				}
			}
			if (opc == 0 && FornecedorPessoaJuridicaPorCNPJ(fornecedorPessoaJuridica)
					&& FornecedorPessoaJuridicaPorIE(fornecedorPessoaJuridica)) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO fornecedor (cadastradoEm,email,telefone,celular,situacao,idEndereco)VALUES(?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDate(1, fornecedorPessoaJuridica.getCadastradoEm());
				preparedStatement.setString(2, fornecedorPessoaJuridica.getEmail());
				preparedStatement.setString(3, fornecedorPessoaJuridica.getTelefone());
				preparedStatement.setString(4, fornecedorPessoaJuridica.getCelular());
				preparedStatement.setString(5, fornecedorPessoaJuridica.getSituacao());
				preparedStatement.setInt(6, fornecedorPessoaJuridica.getIdEndereco());
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaJuridica.setCodigo(resultSet.getInt(1));
				}
				preparedStatement = connection.prepareStatement(
						"INSERT INTO fornecedorpessoajuridica (codigo,razaoSocial,cnpj,ie)VALUES(?,?,?,?)");
				preparedStatement.setInt(1, fornecedorPessoaJuridica.getCodigo());
				preparedStatement.setString(2, fornecedorPessoaJuridica.getRazaoSocial());
				preparedStatement.setString(3, fornecedorPessoaJuridica.getCnpj());
				preparedStatement.setString(4, fornecedorPessoaJuridica.getIe());
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

	public ArrayList<FornecedorPessoaJuridica> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FornecedorPessoaJuridica> fornecedorsPessoasJuridicas = new ArrayList<FornecedorPessoaJuridica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco ORDER BY razaoSocial");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FornecedorPessoaJuridica fornecedorPessoaJuridica = new FornecedorPessoaJuridica();
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
				fornecedorsPessoasJuridicas.add(fornecedorPessoaJuridica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe fornecedor pessoa juridica cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorsPessoasJuridicas;
	}

	public ArrayList<FornecedorPessoaJuridica> FornecedorPessoaJuridicasPorRazaoSocial(String razaoSocial) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FornecedorPessoaJuridica> fornecedorPessoaJuridicas = new ArrayList<FornecedorPessoaJuridica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE razaoSocial LIKE ? ORDER BY razaoSocial");
			preparedStatement.setString(1, "%" + razaoSocial + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FornecedorPessoaJuridica fornecedorPessoaJuridica = new FornecedorPessoaJuridica();
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
				fornecedorPessoaJuridicas.add(fornecedorPessoaJuridica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Esta nome não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorPessoaJuridicas;
	}

	public FornecedorPessoaJuridica FornecedorPessoaJuridicaPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		FornecedorPessoaJuridica fornecedorPessoaJuridica = new FornecedorPessoaJuridica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
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
		return fornecedorPessoaJuridica;
	}

	public FornecedorPessoaJuridica FornecedorPessoaJuridicaPorCNPJ(String CNPJ) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		FornecedorPessoaJuridica fornecedorPessoaJuridica = new FornecedorPessoaJuridica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE cnpj = ?");
			preparedStatement.setString(1, CNPJ);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
			} else {
				JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorPessoaJuridica;
	}

	public boolean FornecedorPessoaJuridicaPorCNPJ(FornecedorPessoaJuridica fornecedorPessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE cnpj = ?");
			preparedStatement.setString(1, fornecedorPessoaJuridica.getCnpj());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
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

	public boolean FornecedorPessoaJuridicaPorIE(FornecedorPessoaJuridica fornecedorPessoaJuridica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaJuridica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE ie = ?");
			preparedStatement.setString(1, fornecedorPessoaJuridica.getIe());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaJuridica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaJuridica.setRazaoSocial(resultSet.getString(3));
				fornecedorPessoaJuridica.setCnpj(resultSet.getString(4));
				fornecedorPessoaJuridica.setIe(resultSet.getString(5));
				fornecedorPessoaJuridica.setCadastradoEm(resultSet.getDate(6));
				fornecedorPessoaJuridica.setEmail(resultSet.getString(7));
				fornecedorPessoaJuridica.setTelefone(resultSet.getString(8));
				fornecedorPessoaJuridica.setCelular(resultSet.getString(9));
				fornecedorPessoaJuridica.setSituacao(resultSet.getString(10));
				fornecedorPessoaJuridica.setCep(resultSet.getString(11));
				fornecedorPessoaJuridica.setLogradouro(resultSet.getString(12));
				fornecedorPessoaJuridica.setNumero(resultSet.getString(13));
				fornecedorPessoaJuridica.setComplemento(resultSet.getString(14));
				fornecedorPessoaJuridica.setBairro(resultSet.getString(15));
				fornecedorPessoaJuridica.setMunicipio(resultSet.getString(16));
				fornecedorPessoaJuridica.setUf(resultSet.getString(17));
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

	public boolean update(FornecedorPessoaJuridica fornecedorPessoaJuridica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, fornecedorPessoaJuridica.getCep());
			preparedStatement.setString(2, fornecedorPessoaJuridica.getLogradouro());
			preparedStatement.setString(3, fornecedorPessoaJuridica.getNumero());
			preparedStatement.setString(4, fornecedorPessoaJuridica.getComplemento());
			preparedStatement.setString(5, fornecedorPessoaJuridica.getBairro());
			preparedStatement.setString(6, fornecedorPessoaJuridica.getMunicipio());
			preparedStatement.setString(7, fornecedorPessoaJuridica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(fornecedorPessoaJuridica.getBairro());
			endereco.setCep(fornecedorPessoaJuridica.getCep());
			endereco.setComplemento(fornecedorPessoaJuridica.getComplemento());
			endereco.setLogradouro(fornecedorPessoaJuridica.getLogradouro());
			endereco.setMunicipio(fornecedorPessoaJuridica.getMunicipio());
			endereco.setNumero(fornecedorPessoaJuridica.getNumero());
			endereco.setUf(fornecedorPessoaJuridica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					fornecedorPessoaJuridica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					ConnectionFactory.closeConnection(connection, preparedStatement);
					JOptionPane.showMessageDialog(null, "Altere o endereço");
					return false;
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaJuridica.setIdEndereco(resultSet.getInt(1));
				}
			}
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			preparedStatement = connection.prepareStatement(
					"UPDATE fornecedor SET cadastradoEm = ?,email = ?,telefone = ?,celular = ?,situacao = ?,idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, fornecedorPessoaJuridica.getCadastradoEm());
			preparedStatement.setString(2, fornecedorPessoaJuridica.getEmail());
			preparedStatement.setString(3, fornecedorPessoaJuridica.getTelefone());
			preparedStatement.setString(4, fornecedorPessoaJuridica.getCelular());
			preparedStatement.setString(5, fornecedorPessoaJuridica.getSituacao());
			preparedStatement.setInt(6, fornecedorPessoaJuridica.getIdEndereco());
			preparedStatement.setInt(7, fornecedorPessoaJuridica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(
					"UPDATE fornecedorpessoajuridica SET codigo = ?,razaoSocial = ?,cnpj = ?,ie = ? WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedorPessoaJuridica.getCodigo());
			preparedStatement.setString(2, fornecedorPessoaJuridica.getRazaoSocial());
			preparedStatement.setString(3, fornecedorPessoaJuridica.getCnpj());
			preparedStatement.setString(4, fornecedorPessoaJuridica.getIe());
			preparedStatement.setInt(5, fornecedorPessoaJuridica.getCodigo());
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

	public void delete(FornecedorPessoaJuridica fornecedorPessoaJuridica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM fornecedorPessoaJuridica WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedorPessoaJuridica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("DELETE FROM fornecedor WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedorPessoaJuridica.getCodigo());
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
