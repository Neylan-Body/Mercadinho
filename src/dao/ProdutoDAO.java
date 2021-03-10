package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import connection.ConnectionFactory;
import controller.ControladorTelaGerenciarProduto;
import model.Produto;

public class ProdutoDAO {

	public boolean create(Produto produto) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO produto (descricao,codigoBarra,estoqueMinimo,estoqueMaximo,valorCusto,lucro,valorVenda,unidade_id,tipo_id)VALUES(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, produto.getDescricao());
			preparedStatement.setInt(2, produto.getCodigoBarra());
			preparedStatement.setInt(3, produto.getEstoqueMinimo());
			preparedStatement.setInt(4, produto.getEstoqueMaximo());
			preparedStatement.setDouble(5, produto.getValorCusto());
			preparedStatement.setDouble(6, produto.getLucro());
			preparedStatement.setDouble(7, produto.getValorVenda());
			preparedStatement.setInt(8, produto.getIdUnidade());
			preparedStatement.setInt(9, produto.getIdTipo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return true;
		} catch (SQLException e) {
			if(e.getMessage().equals("Duplicate entry '"+produto.getCodigoBarra()+"' for key 'codigoBarra_UNIQUE'")) {
				JOptionPane.showMessageDialog(null, "Codigo de barra ja existente");
			}
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Inserção", JOptionPane.ERROR_MESSAGE);
			ConnectionFactory.closeConnection(connection, preparedStatement);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public ArrayList<Produto> read() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM produto ORDER BY descricao");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Produto produto = new Produto();
				produto.setCodigo(resultSet.getInt(1));
				produto.setDescricao(resultSet.getString(2));
				produto.setCodigoBarra(resultSet.getInt(3));
				produto.setEstoqueMinimo(resultSet.getInt(4));
				produto.setEstoqueMaximo(resultSet.getInt(5));
				produto.setValorCusto(resultSet.getDouble(6));
				produto.setLucro(resultSet.getDouble(7));
				produto.setValorVenda(resultSet.getDouble(8));
				produto.setIdUnidade(resultSet.getInt(9));
				produto.setIdTipo(resultSet.getInt(10));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não existe produto cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return produtos;
	}

	public ArrayList<Produto> ProdutosPorDescricao(String descricao) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ? ORDER BY descricao");
			preparedStatement.setString(1, "%"+descricao+"%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Produto produto = new Produto();
				produto.setCodigo(resultSet.getInt(1));
				produto.setDescricao(resultSet.getString(2));
				produto.setCodigoBarra(resultSet.getInt(3));
				produto.setEstoqueMinimo(resultSet.getInt(4));
				produto.setEstoqueMaximo(resultSet.getInt(5));
				produto.setValorCusto(resultSet.getDouble(6));
				produto.setLucro(resultSet.getDouble(7));
				produto.setValorVenda(resultSet.getDouble(8));
				produto.setIdUnidade(resultSet.getInt(9));
				produto.setIdTipo(resultSet.getInt(10));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Esta descrição não foi cadastrada", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return produtos;
	}

	public Produto ProdutoPorCodigo(int codigo) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Produto produto = new Produto();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM produto WHERE codigo = ?");
			preparedStatement.setInt(1, codigo);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				produto.setCodigo(resultSet.getInt(1));
				produto.setDescricao(resultSet.getString(2));
				produto.setCodigoBarra(resultSet.getInt(3));
				produto.setEstoqueMinimo(resultSet.getInt(4));
				produto.setEstoqueMaximo(resultSet.getInt(5));
				produto.setValorCusto(resultSet.getDouble(6));
				produto.setLucro(resultSet.getDouble(7));
				produto.setValorVenda(resultSet.getDouble(8));
				produto.setIdUnidade(resultSet.getInt(9));
				produto.setIdTipo(resultSet.getInt(10));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este codigo não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return produto;
	}

	public Produto ProdutoPorCodigoBarra(int codigoBarra) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Produto produto = new Produto();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM produto WHERE codigoBarra = ?");
			preparedStatement.setInt(1, codigoBarra);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				produto.setCodigo(resultSet.getInt(1));
				produto.setDescricao(resultSet.getString(2));
				produto.setCodigoBarra(resultSet.getInt(3));
				produto.setEstoqueMinimo(resultSet.getInt(4));
				produto.setEstoqueMaximo(resultSet.getInt(5));
				produto.setValorCusto(resultSet.getDouble(6));
				produto.setLucro(resultSet.getDouble(7));
				produto.setValorVenda(resultSet.getDouble(8));
				produto.setIdUnidade(resultSet.getInt(9));
				produto.setIdTipo(resultSet.getInt(10));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Este codigo de barra não foi cadastrado", "Busca", JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
		}
		return produto;
	}

	public boolean update(Produto produto) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE produto SET estoqueMaximo = ?, estoqueMinimo = ?, tipo_id = ?, unidade_id = ?, descricao = ?, lucro = ?, valorCusto = ?, valorVenda = ?, codigoBarra = ? WHERE codigo = ?");
			preparedStatement.setInt(1, produto.getEstoqueMaximo());
			preparedStatement.setInt(2, produto.getEstoqueMinimo());
			preparedStatement.setInt(3, produto.getIdTipo());
			preparedStatement.setInt(4, produto.getIdUnidade());
			preparedStatement.setString(5, produto.getDescricao());
			preparedStatement.setDouble(6, produto.getLucro());
			preparedStatement.setDouble(7, produto.getValorCusto());
			preparedStatement.setDouble(8, produto.getValorVenda());
			preparedStatement.setInt(9, produto.getCodigoBarra());
			preparedStatement.setInt(10, produto.getCodigo());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Atualização", JOptionPane.INFORMATION_MESSAGE);
			return true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Atualização", JOptionPane.ERROR_MESSAGE);
			if(e.getMessage().equals("Duplicate entry '"+produto.getCodigoBarra()+"' for key 'codigoBarra_UNIQUE'")) {
				JOptionPane.showMessageDialog(null, "Codigo de barra ja existente");
			}
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, preparedStatement);
		}
	}

	public void delete(Produto produto) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE codigo = ?");
			preparedStatement.setInt(1, produto.getCodigo());
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
