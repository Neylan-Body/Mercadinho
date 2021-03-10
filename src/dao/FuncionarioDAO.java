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
import model.Funcionario;

public class FuncionarioDAO {
	public boolean create(Funcionario funcionario) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, funcionario.getCep());
			preparedStatement.setString(2, funcionario.getLogradouro());
			preparedStatement.setString(3, funcionario.getNumero());
			preparedStatement.setString(4, funcionario.getComplemento());
			preparedStatement.setString(5, funcionario.getBairro());
			preparedStatement.setString(6, funcionario.getMunicipio());
			preparedStatement.setString(7, funcionario.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(funcionario.getBairro());
			endereco.setCep(funcionario.getCep());
			endereco.setComplemento(funcionario.getComplemento());
			endereco.setLogradouro(funcionario.getLogradouro());
			endereco.setMunicipio(funcionario.getMunicipio());
			endereco.setNumero(funcionario.getNumero());
			endereco.setUf(funcionario.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					funcionario.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					JOptionPane.showMessageDialog(null, "Altere o endereço");
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					funcionario.setIdEndereco(resultSet.getInt(1));
				}
			}
			if (opc == 0) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO funcionario (nome,cpf,rg,orgaoEmissor,dtEmissao,estadoCivil,dtNascimento,nacionalidade,ufDoc,naturalidade,sexo,cadastradoEm,email,telefone,celular,idOcupacao,salario,senha,idEndereco)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, funcionario.getNome());
				preparedStatement.setString(2, funcionario.getCpf());
				preparedStatement.setString(3, funcionario.getRg());
				preparedStatement.setString(4, funcionario.getOrgaoEmissor());
				preparedStatement.setDate(5, funcionario.getDtEmissao());
				preparedStatement.setString(6, funcionario.getEstadoCivil());
				preparedStatement.setDate(7, funcionario.getDtNascimento());
				preparedStatement.setString(8, funcionario.getNacionalidade());
				preparedStatement.setString(9, funcionario.getUfDoc());
				preparedStatement.setString(10, funcionario.getNaturalidade());
				preparedStatement.setString(11, funcionario.getSexo());
				preparedStatement.setDate(12, funcionario.getCadastradoEm());
				preparedStatement.setString(13, funcionario.getEmail());
				preparedStatement.setString(14, funcionario.getTelefone());
				preparedStatement.setString(15, funcionario.getCelular());
				preparedStatement.setInt(16, funcionario.getIdOcupacao());
				preparedStatement.setDouble(17, funcionario.getSalario());
				preparedStatement.setString(18, funcionario.getSenha());
				preparedStatement.setInt(19, funcionario.getIdEndereco());
				preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Funcionario> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM funcionario NATURAL JOIN endereco ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdEndereco(resultSet.getInt(1));
				funcionario.setCodigo(resultSet.getInt(2));
				funcionario.setNome(resultSet.getString(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setOrgaoEmissor(resultSet.getString(6));
				funcionario.setDtEmissao(resultSet.getDate(7));
				funcionario.setEstadoCivil(resultSet.getString(8));
				funcionario.setDtNascimento(resultSet.getDate(9));
				funcionario.setNacionalidade(resultSet.getString(10));
				funcionario.setUfDoc(resultSet.getString(11));
				funcionario.setNaturalidade(resultSet.getString(12));
				funcionario.setSexo(resultSet.getString(13));
				funcionario.setCadastradoEm(resultSet.getDate(14));
				funcionario.setEmail(resultSet.getString(15));
				funcionario.setTelefone(resultSet.getString(16));
				funcionario.setCelular(resultSet.getString(17));
				funcionario.setIdOcupacao(resultSet.getInt(18));
				funcionario.setSalario(resultSet.getDouble(19));
				funcionario.setSenha(resultSet.getString(20));
				funcionario.setCep(resultSet.getString(21));
				funcionario.setLogradouro(resultSet.getString(22));
				funcionario.setNumero(resultSet.getString(23));
				funcionario.setComplemento(resultSet.getString(24));
				funcionario.setBairro(resultSet.getString(25));
				funcionario.setMunicipio(resultSet.getString(26));
				funcionario.setUf(resultSet.getString(27));
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe funcionario cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return funcionarios;
	}

	public ArrayList<Funcionario> FuncionariosPorNome(String nome) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM funcionario NATURAL JOIN endereco WHERE nome LIKE ? ORDER BY nome");
			preparedStatement.setString(1, "%" + nome + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdEndereco(resultSet.getInt(1));
				funcionario.setCodigo(resultSet.getInt(2));
				funcionario.setNome(resultSet.getString(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setOrgaoEmissor(resultSet.getString(6));
				funcionario.setDtEmissao(resultSet.getDate(7));
				funcionario.setEstadoCivil(resultSet.getString(8));
				funcionario.setDtNascimento(resultSet.getDate(9));
				funcionario.setNacionalidade(resultSet.getString(10));
				funcionario.setUfDoc(resultSet.getString(11));
				funcionario.setNaturalidade(resultSet.getString(12));
				funcionario.setSexo(resultSet.getString(13));
				funcionario.setCadastradoEm(resultSet.getDate(14));
				funcionario.setEmail(resultSet.getString(15));
				funcionario.setTelefone(resultSet.getString(16));
				funcionario.setCelular(resultSet.getString(17));
				funcionario.setIdOcupacao(resultSet.getInt(18));
				funcionario.setSalario(resultSet.getDouble(19));
				funcionario.setSenha(resultSet.getString(20));
				funcionario.setCep(resultSet.getString(21));
				funcionario.setLogradouro(resultSet.getString(22));
				funcionario.setNumero(resultSet.getString(23));
				funcionario.setComplemento(resultSet.getString(24));
				funcionario.setBairro(resultSet.getString(25));
				funcionario.setMunicipio(resultSet.getString(26));
				funcionario.setUf(resultSet.getString(27));
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe funcionario cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return funcionarios;
	}

	public ArrayList<Funcionario> FuncionariosPorOcupacao(int idOcupacao) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM funcionario NATURAL JOIN endereco WHERE idOcupacao = ? ORDER BY nome");
			preparedStatement.setInt(1, idOcupacao);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdEndereco(resultSet.getInt(1));
				funcionario.setCodigo(resultSet.getInt(2));
				funcionario.setNome(resultSet.getString(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setOrgaoEmissor(resultSet.getString(6));
				funcionario.setDtEmissao(resultSet.getDate(7));
				funcionario.setEstadoCivil(resultSet.getString(8));
				funcionario.setDtNascimento(resultSet.getDate(9));
				funcionario.setNacionalidade(resultSet.getString(10));
				funcionario.setUfDoc(resultSet.getString(11));
				funcionario.setNaturalidade(resultSet.getString(12));
				funcionario.setSexo(resultSet.getString(13));
				funcionario.setCadastradoEm(resultSet.getDate(14));
				funcionario.setEmail(resultSet.getString(15));
				funcionario.setTelefone(resultSet.getString(16));
				funcionario.setCelular(resultSet.getString(17));
				funcionario.setIdOcupacao(resultSet.getInt(18));
				funcionario.setSalario(resultSet.getDouble(19));
				funcionario.setSenha(resultSet.getString(20));
				funcionario.setCep(resultSet.getString(21));
				funcionario.setLogradouro(resultSet.getString(22));
				funcionario.setNumero(resultSet.getString(23));
				funcionario.setComplemento(resultSet.getString(24));
				funcionario.setBairro(resultSet.getString(25));
				funcionario.setMunicipio(resultSet.getString(26));
				funcionario.setUf(resultSet.getString(27));
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe funcionario cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return funcionarios;
	}

	public Funcionario FuncionarioPorCPF(String cpf) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Funcionario funcionario = null;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM funcionario NATURAL JOIN endereco WHERE cpf = ?");
			preparedStatement.setString(1, cpf);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				funcionario = new Funcionario();
				funcionario.setIdEndereco(resultSet.getInt(1));
				funcionario.setCodigo(resultSet.getInt(2));
				funcionario.setNome(resultSet.getString(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setOrgaoEmissor(resultSet.getString(6));
				funcionario.setDtEmissao(resultSet.getDate(7));
				funcionario.setEstadoCivil(resultSet.getString(8));
				funcionario.setDtNascimento(resultSet.getDate(9));
				funcionario.setNacionalidade(resultSet.getString(10));
				funcionario.setUfDoc(resultSet.getString(11));
				funcionario.setNaturalidade(resultSet.getString(12));
				funcionario.setSexo(resultSet.getString(13));
				funcionario.setCadastradoEm(resultSet.getDate(14));
				funcionario.setEmail(resultSet.getString(15));
				funcionario.setTelefone(resultSet.getString(16));
				funcionario.setCelular(resultSet.getString(17));
				funcionario.setIdOcupacao(resultSet.getInt(18));
				funcionario.setSalario(resultSet.getDouble(19));
				funcionario.setSenha(resultSet.getString(20));
				funcionario.setCep(resultSet.getString(21));
				funcionario.setLogradouro(resultSet.getString(22));
				funcionario.setNumero(resultSet.getString(23));
				funcionario.setComplemento(resultSet.getString(24));
				funcionario.setBairro(resultSet.getString(25));
				funcionario.setMunicipio(resultSet.getString(26));
				funcionario.setUf(resultSet.getString(27));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe funcionario cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return funcionario;
	}

	public Funcionario FuncionarioPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Funcionario funcionario = null;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM funcionario NATURAL JOIN endereco WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				funcionario = new Funcionario();
				funcionario.setIdEndereco(resultSet.getInt(1));
				funcionario.setCodigo(resultSet.getInt(2));
				funcionario.setNome(resultSet.getString(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setOrgaoEmissor(resultSet.getString(6));
				funcionario.setDtEmissao(resultSet.getDate(7));
				funcionario.setEstadoCivil(resultSet.getString(8));
				funcionario.setDtNascimento(resultSet.getDate(9));
				funcionario.setNacionalidade(resultSet.getString(10));
				funcionario.setUfDoc(resultSet.getString(11));
				funcionario.setNaturalidade(resultSet.getString(12));
				funcionario.setSexo(resultSet.getString(13));
				funcionario.setCadastradoEm(resultSet.getDate(14));
				funcionario.setEmail(resultSet.getString(15));
				funcionario.setTelefone(resultSet.getString(16));
				funcionario.setCelular(resultSet.getString(17));
				funcionario.setIdOcupacao(resultSet.getInt(18));
				funcionario.setSalario(resultSet.getDouble(19));
				funcionario.setSenha(resultSet.getString(20));
				funcionario.setCep(resultSet.getString(21));
				funcionario.setLogradouro(resultSet.getString(22));
				funcionario.setNumero(resultSet.getString(23));
				funcionario.setComplemento(resultSet.getString(24));
				funcionario.setBairro(resultSet.getString(25));
				funcionario.setMunicipio(resultSet.getString(26));
				funcionario.setUf(resultSet.getString(27));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe funcionario cadastrado", "Busca",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return funcionario;
	}

	public boolean update(Funcionario funcionario) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO endereco (cep,logradouro,numero,complemento,bairro,municipio,uf)VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, funcionario.getCep());
			preparedStatement.setString(2, funcionario.getLogradouro());
			preparedStatement.setString(3, funcionario.getNumero());
			preparedStatement.setString(4, funcionario.getComplemento());
			preparedStatement.setString(5, funcionario.getBairro());
			preparedStatement.setString(6, funcionario.getMunicipio());
			preparedStatement.setString(7, funcionario.getUf());
			Endereco endereco = new Endereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			endereco.setBairro(funcionario.getBairro());
			endereco.setCep(funcionario.getCep());
			endereco.setComplemento(funcionario.getComplemento());
			endereco.setLogradouro(funcionario.getLogradouro());
			endereco.setMunicipio(funcionario.getMunicipio());
			endereco.setNumero(funcionario.getNumero());
			endereco.setUf(funcionario.getUf());
			int opc = 0;
			if (enderecoDAO.Existe(endereco)) {
				opc = JOptionPane.showConfirmDialog(null, "Endereço já existe deseja coloca-lo no mesmo endereco?",
						"Endereço", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					funcionario.setIdEndereco(enderecoDAO.EnderecoPorConjunto(endereco).getIdEndereco());
				} else {
					ConnectionFactory.closeConnection(connection, preparedStatement);
					JOptionPane.showMessageDialog(null, "Altere o endereço");
					return false;
				}
			} else {
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					funcionario.setIdEndereco(resultSet.getInt(1));
				}
			}
			preparedStatement = connection.prepareStatement(
					"UPDATE funcionario SET nome = ?,cpf = ?,rg = ?,orgaoEmissor = ?,dtEmissao = ?,estadoCivil = ?,dtNascimento = ?,nacionalidade = ?,ufDoc = ?,naturalidade = ?,sexo = ?,cadastradoEm = ?,email = ?,telefone = ?,celular = ?,idOcupacao = ?,salario = ?,senha = ?,idEndereco = ? WHERE codigo = ?");
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getCpf());
			preparedStatement.setString(3, funcionario.getRg());
			preparedStatement.setString(4, funcionario.getOrgaoEmissor());
			preparedStatement.setDate(5, funcionario.getDtEmissao());
			preparedStatement.setString(6, funcionario.getEstadoCivil());
			preparedStatement.setDate(7, funcionario.getDtNascimento());
			preparedStatement.setString(8, funcionario.getNacionalidade());
			preparedStatement.setString(9, funcionario.getUfDoc());
			preparedStatement.setString(10, funcionario.getNaturalidade());
			preparedStatement.setString(11, funcionario.getSexo());
			preparedStatement.setDate(12, funcionario.getCadastradoEm());
			preparedStatement.setString(13, funcionario.getEmail());
			preparedStatement.setString(14, funcionario.getTelefone());
			preparedStatement.setString(15, funcionario.getCelular());
			preparedStatement.setInt(16, funcionario.getIdOcupacao());
			preparedStatement.setDouble(17, funcionario.getSalario());
			preparedStatement.setString(18, funcionario.getSenha());
			preparedStatement.setInt(19, funcionario.getIdEndereco());
			preparedStatement.setInt(20, funcionario.getCodigo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(Funcionario funcionario) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM funcionario WHERE codigo = ?");
			preparedStatement.setInt(1, funcionario.getCodigo());
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
