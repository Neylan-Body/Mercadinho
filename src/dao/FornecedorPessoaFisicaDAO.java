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
import model.FornecedorPessoaFisica;

public class FornecedorPessoaFisicaDAO {

	public boolean create(FornecedorPessoaFisica fornecedorPessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, fornecedorPessoaFisica.getCep());
			preparedStatement.setString(2, fornecedorPessoaFisica.getLogradouro());
			preparedStatement.setString(3, fornecedorPessoaFisica.getNumero());
			preparedStatement.setString(4, fornecedorPessoaFisica.getComplemento());
			preparedStatement.setString(5, fornecedorPessoaFisica.getBairro());
			preparedStatement.setString(6, fornecedorPessoaFisica.getMunicipio());
			preparedStatement.setString(7, fornecedorPessoaFisica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(fornecedorPessoaFisica.getBairro());
			endereco.setCep(fornecedorPessoaFisica.getCep());
			endereco.setComplemento(fornecedorPessoaFisica.getComplemento());
			endereco.setLogradouro(fornecedorPessoaFisica.getLogradouro());
			endereco.setMunicipio(fornecedorPessoaFisica.getMunicipio());
			endereco.setNumero(fornecedorPessoaFisica.getNumero());
			endereco.setUf(fornecedorPessoaFisica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					fornecedorPessoaFisica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					JOptionPane.showMessageDialog(null, "Altere o endereço");
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				}
			}
			if (opc == 0 && FornecedorPessoaFisicaPorCPF(fornecedorPessoaFisica)
					&& FornecedorPessoaFisicaPorRG(fornecedorPessoaFisica)) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO fornecedor (cadastradoEm,email,telefone,celular,situacao,idEndereco)VALUES(?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDate(1, fornecedorPessoaFisica.getCadastradoEm());
				preparedStatement.setString(2, fornecedorPessoaFisica.getEmail());
				preparedStatement.setString(3, fornecedorPessoaFisica.getTelefone());
				preparedStatement.setString(4, fornecedorPessoaFisica.getCelular());
				preparedStatement.setString(5, fornecedorPessoaFisica.getSituacao());
				preparedStatement.setInt(6, fornecedorPessoaFisica.getIdEndereco());
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaFisica.setCodigo(resultSet.getInt(1));
				}
				preparedStatement = connection.prepareStatement(
						"INSERT INTO fornecedorpessoafisica (codigo,nome,cpf,rg,orgaoEmissor,dtEmissao,nacionalidade,ufDoc,naturalidade,sexo)VALUES(?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, fornecedorPessoaFisica.getCodigo());
				preparedStatement.setString(2, fornecedorPessoaFisica.getNome());
				preparedStatement.setString(3, fornecedorPessoaFisica.getCpf());
				preparedStatement.setString(4, fornecedorPessoaFisica.getRg());
				preparedStatement.setString(5, fornecedorPessoaFisica.getOrgaoEmissor());
				preparedStatement.setDate(6, fornecedorPessoaFisica.getDtEmissao());
				preparedStatement.setString(7, fornecedorPessoaFisica.getNacionalidade());
				preparedStatement.setString(8, fornecedorPessoaFisica.getUfDoc());
				preparedStatement.setString(9, fornecedorPessoaFisica.getNaturalidade());
				preparedStatement.setString(10, fornecedorPessoaFisica.getSexo());
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

	public ArrayList<FornecedorPessoaFisica> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FornecedorPessoaFisica> fornecedorsPessoasFisicas = new ArrayList<FornecedorPessoaFisica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FornecedorPessoaFisica fornecedorPessoaFisica = new FornecedorPessoaFisica();
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
				fornecedorsPessoasFisicas.add(fornecedorPessoaFisica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe fornecedor pessoa fisica cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorsPessoasFisicas;
	}

	public ArrayList<FornecedorPessoaFisica> FornecedorPessoaFisicasPorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FornecedorPessoaFisica> fornecedorPessoaFisicas = new ArrayList<FornecedorPessoaFisica>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE nome LIKE ? ORDER BY nome");
			preparedStatement.setString(1, "%" + nome + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FornecedorPessoaFisica fornecedorPessoaFisica = new FornecedorPessoaFisica();
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
				fornecedorPessoaFisicas.add(fornecedorPessoaFisica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Esta nome não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorPessoaFisicas;
	}

	public FornecedorPessoaFisica FornecedorPessoaFisicaPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		FornecedorPessoaFisica fornecedorPessoaFisica = new FornecedorPessoaFisica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
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
		return fornecedorPessoaFisica;
	}

	public FornecedorPessoaFisica FornecedorPessoaFisicaPorCPF(String CPF) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		FornecedorPessoaFisica fornecedorPessoaFisica = new FornecedorPessoaFisica();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE cpf = ?");
			preparedStatement.setString(1, CPF);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
			} else {
				JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este CPF não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return fornecedorPessoaFisica;
	}

	public boolean FornecedorPessoaFisicaPorCPF(FornecedorPessoaFisica fornecedorPessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE cpf = ?");
			preparedStatement.setString(1, fornecedorPessoaFisica.getCpf());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
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

	public boolean FornecedorPessoaFisicaPorRG(FornecedorPessoaFisica fornecedorPessoaFisica) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM fornecedorPessoaFisica NATURAL JOIN fornecedor NATURAL JOIN endereco WHERE rg = ?");
			preparedStatement.setString(1, fornecedorPessoaFisica.getRg());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				fornecedorPessoaFisica.setCodigo(resultSet.getInt(2));
				fornecedorPessoaFisica.setNome(resultSet.getString(3));
				fornecedorPessoaFisica.setCpf(resultSet.getString(4));
				fornecedorPessoaFisica.setRg(resultSet.getString(5));
				fornecedorPessoaFisica.setOrgaoEmissor(resultSet.getString(6));
				fornecedorPessoaFisica.setDtEmissao(resultSet.getDate(7));
				fornecedorPessoaFisica.setNacionalidade(resultSet.getString(8));
				fornecedorPessoaFisica.setUfDoc(resultSet.getString(9));
				fornecedorPessoaFisica.setNaturalidade(resultSet.getString(10));
				fornecedorPessoaFisica.setSexo(resultSet.getString(11));
				fornecedorPessoaFisica.setCadastradoEm(resultSet.getDate(12));
				fornecedorPessoaFisica.setEmail(resultSet.getString(13));
				fornecedorPessoaFisica.setTelefone(resultSet.getString(14));
				fornecedorPessoaFisica.setCelular(resultSet.getString(15));
				fornecedorPessoaFisica.setSituacao(resultSet.getString(16));
				fornecedorPessoaFisica.setCep(resultSet.getString(17));
				fornecedorPessoaFisica.setLogradouro(resultSet.getString(18));
				fornecedorPessoaFisica.setNumero(resultSet.getString(19));
				fornecedorPessoaFisica.setComplemento(resultSet.getString(20));
				fornecedorPessoaFisica.setBairro(resultSet.getString(21));
				fornecedorPessoaFisica.setMunicipio(resultSet.getString(22));
				fornecedorPessoaFisica.setUf(resultSet.getString(23));
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

	public boolean update(FornecedorPessoaFisica fornecedorPessoaFisica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, fornecedorPessoaFisica.getCep());
			preparedStatement.setString(2, fornecedorPessoaFisica.getLogradouro());
			preparedStatement.setString(3, fornecedorPessoaFisica.getNumero());
			preparedStatement.setString(4, fornecedorPessoaFisica.getComplemento());
			preparedStatement.setString(5, fornecedorPessoaFisica.getBairro());
			preparedStatement.setString(6, fornecedorPessoaFisica.getMunicipio());
			preparedStatement.setString(7, fornecedorPessoaFisica.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(fornecedorPessoaFisica.getBairro());
			endereco.setCep(fornecedorPessoaFisica.getCep());
			endereco.setComplemento(fornecedorPessoaFisica.getComplemento());
			endereco.setLogradouro(fornecedorPessoaFisica.getLogradouro());
			endereco.setMunicipio(fornecedorPessoaFisica.getMunicipio());
			endereco.setNumero(fornecedorPessoaFisica.getNumero());
			endereco.setUf(fornecedorPessoaFisica.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					fornecedorPessoaFisica.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					ConnectionFactory.closeConnection(connection, preparedStatement);
					JOptionPane.showMessageDialog(null, "Altere o endereço");
					return false;
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					fornecedorPessoaFisica.setIdEndereco(resultSet.getInt(1));
				}
			}
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			preparedStatement = connection.prepareStatement(
					"UPDATE fornecedor SET cadastradoEm = ?,email = ?,telefone = ?,celular = ?,situacao = ?,idEndereco = ? WHERE codigo = ?");
			preparedStatement.setDate(1, fornecedorPessoaFisica.getCadastradoEm());
			preparedStatement.setString(2, fornecedorPessoaFisica.getEmail());
			preparedStatement.setString(3, fornecedorPessoaFisica.getTelefone());
			preparedStatement.setString(4, fornecedorPessoaFisica.getCelular());
			preparedStatement.setString(5, fornecedorPessoaFisica.getSituacao());
			preparedStatement.setInt(6, fornecedorPessoaFisica.getIdEndereco());
			preparedStatement.setInt(7, fornecedorPessoaFisica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(
					"UPDATE fornecedorpessoafisica SET nome = ?,cpf = ?,rg = ?,orgaoEmissor = ?,dtEmissao = ?,nacionalidade = ?,ufDoc = ?,naturalidade = ?,sexo = ? WHERE codigo = ?");
			preparedStatement.setString(1, fornecedorPessoaFisica.getNome());
			preparedStatement.setString(2, fornecedorPessoaFisica.getCpf());
			preparedStatement.setString(3, fornecedorPessoaFisica.getRg());
			preparedStatement.setString(4, fornecedorPessoaFisica.getOrgaoEmissor());
			preparedStatement.setDate(5, fornecedorPessoaFisica.getDtEmissao());
			preparedStatement.setString(6, fornecedorPessoaFisica.getNacionalidade());
			preparedStatement.setString(7, fornecedorPessoaFisica.getUfDoc());
			preparedStatement.setString(8, fornecedorPessoaFisica.getNaturalidade());
			preparedStatement.setString(9, fornecedorPessoaFisica.getSexo());
			preparedStatement.setInt(10, fornecedorPessoaFisica.getCodigo());
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

	public void delete(FornecedorPessoaFisica fornecedorPessoaFisica) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM fornecedorPessoaFisica WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedorPessoaFisica.getCodigo());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("DELETE FROM fornecedor WHERE codigo = ?");
			preparedStatement.setInt(1, fornecedorPessoaFisica.getCodigo());
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
