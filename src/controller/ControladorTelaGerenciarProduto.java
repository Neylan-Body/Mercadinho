package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import dao.ProdutoDAO;
import dao.TipoDAO;
import dao.UnidadeDAO;
import model.Produto;
import model.Tipo;
import model.Unidade;
import model.ValidarTelaPagamento;
import model.ValidarTelaProduto;
import view.FrameGerenciarProduto;
import view.FrameGerenciarTipo;
import view.FrameGerenciarUnidade;
import view.PainelGerenciarProduto;
import view.PainelGerenciarTipo;
import view.PainelGerenciarUnidade;

public class ControladorTelaGerenciarProduto implements ActionListener, MouseListener, KeyListener, WindowListener {

	private static PainelGerenciarProduto painelGerenciarProduto;
	private static FrameGerenciarProduto frameGerenciarProduto;
	private static PainelGerenciarTipo painelGerenciarTipo;
	private static FrameGerenciarTipo frameGerenciarTipo;
	private static PainelGerenciarUnidade painelGerenciarUnidade;
	private static FrameGerenciarUnidade frameGerenciarUnidade;
	private static ProdutoDAO produtoDAO;
	private static TipoDAO tipoDAO;
	private static UnidadeDAO unidadeDAO;
	private static boolean alterarTipo = false, alterarUnidade = false, alterarProduto = false;

	public ControladorTelaGerenciarProduto(FrameGerenciarProduto frameGerenciarProduto,
			PainelGerenciarProduto painelGerenciarProduto) {
		// TODO Auto-generated constructor stub
		this.frameGerenciarProduto = frameGerenciarProduto;
		this.painelGerenciarProduto = painelGerenciarProduto;
		Eventos();
		PovoarJComboBox();
		Inicio();
	}

	private void Inicio() {
		getPainelGerenciarProduto().getJComboBoxTipo().setEnabled(false);
		getPainelGerenciarProduto().getJComboBoxUnidade().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldCodigo().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldDescricao().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldLucro().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldValorCusto().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldValorVenda().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(false);
		getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(false);
		getPainelGerenciarProduto().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(false);
		getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(false);
		getPainelGerenciarProduto().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarProduto().getJButtonCancelar().setEnabled(false);
	}

	private void OpcaoIncluir() {
		getPainelGerenciarProduto().getJComboBoxTipo().setEnabled(true);
		getPainelGerenciarProduto().getJComboBoxUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldCodigo().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldDescricao().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldDescricao().grabFocus();
		getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldLucro().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldValorCusto().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldValorVenda().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarProduto().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
	}

	private void OpcaoAlterar() {
		getPainelGerenciarProduto().getJComboBoxTipo().setEnabled(true);
		getPainelGerenciarProduto().getJComboBoxUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldDescricao().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldLucro().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldValorCusto().setEnabled(true);
		getPainelGerenciarProduto().getJTextFieldValorVenda().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarProduto().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarProduto().getJTextFieldDescricao().grabFocus();
	}

	private void OpcaoTabela() {
		getPainelGerenciarProduto().getJButtonAlterar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonExcluir().setEnabled(true);
		getPainelGerenciarProduto().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
	}

	private void PovoarJComboBox() {
		getPainelGerenciarProduto().getJComboBoxTipo().setModel(new DefaultComboBoxModel(new String[] { "--" }));
		getPainelGerenciarProduto().getJComboBoxUnidade().setModel(new DefaultComboBoxModel(new String[] { "--" }));
		for (int i = 0; i < getTipoDAO().read().size(); i++) {
			getPainelGerenciarProduto().getJComboBoxTipo().addItem(getTipoDAO().read().get(i).getTipo());
		}
		for (int i = 0; i < getUnidadeDAO().read().size(); i++) {
			getPainelGerenciarProduto().getJComboBoxUnidade().addItem(getUnidadeDAO().read().get(i).getUnidade());
		}
	}

	private void Eventos() {
		getPainelGerenciarProduto().getJButtonAddTipo().addActionListener(this);
		getPainelGerenciarProduto().getJButtonAddUnidade().addActionListener(this);
		getPainelGerenciarProduto().getJButtonAlterar().addActionListener(this);
		getPainelGerenciarProduto().getJButtonAlterarTipo().addActionListener(this);
		getPainelGerenciarProduto().getJButtonAlterarUnidade().addActionListener(this);
		getPainelGerenciarProduto().getJButtonCancelar().addActionListener(this);
		getPainelGerenciarProduto().getJButtonConfirmar().addActionListener(this);
		getPainelGerenciarProduto().getJButtonExcluir().addActionListener(this);
		getPainelGerenciarProduto().getJButtonIncluir().addActionListener(this);
		getPainelGerenciarProduto().getJButtonPesquisa().addActionListener(this);
		getPainelGerenciarProduto().getJButtonRemoverTipo().addActionListener(this);
		getPainelGerenciarProduto().getJButtonRemoverUnidade().addActionListener(this);
		getPainelGerenciarProduto().getJTableProduto().addMouseListener(this);
		getPainelGerenciarProduto().getJTextFieldValorVenda().addKeyListener(this);
		getPainelGerenciarProduto().getJTextFieldLucro().addKeyListener(this);
		getPainelGerenciarProduto().getJTableProduto().addKeyListener(this);
		getFrameGerenciarProduto().addWindowListener(this);
	}

	private void LinhaSelecionada(String sinal) {
		try {
			alterarProduto = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarProduto().getJTableProduto()
						.getValueAt(getPainelGerenciarProduto().getJTableProduto().getSelectedRow() + 1, 1);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarProduto().getJTableProduto()
						.getValueAt(getPainelGerenciarProduto().getJTableProduto().getSelectedRow() - 1, 1);
			}
			int idUnidade = getProdutoDAO().ProdutoPorCodigo(codigo).getIdUnidade();
			int idTipo = getProdutoDAO().ProdutoPorCodigo(codigo).getIdTipo();
			getPainelGerenciarProduto().getJTextFieldCodigo().setText(Integer.toString(codigo));
			getPainelGerenciarProduto().getJTextFieldCodigoBarra()
					.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getCodigoBarra()));
			getPainelGerenciarProduto().getJTextFieldDescricao()
					.setText(getProdutoDAO().ProdutoPorCodigo(codigo).getDescricao());
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo()
					.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getEstoqueMaximo()));
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo()
					.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getEstoqueMinimo()));
			double lucro = getProdutoDAO().ProdutoPorCodigo(codigo).getLucro();
			lucro *= 100;
			BigDecimal a = new BigDecimal(lucro);
			BigDecimal roundOff1 = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
			lucro = roundOff1.doubleValue();
			getPainelGerenciarProduto().getJTextFieldLucro().setText(Double.toString(lucro).replace(".", ","));
			getPainelGerenciarProduto().getJTextFieldValorCusto().setText(
					Double.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getValorCusto()).replace(".", ","));
			getPainelGerenciarProduto().getJTextFieldValorVenda().setText(
					Double.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getValorVenda()).replace(".", ","));
			getPainelGerenciarProduto().getJComboBoxTipo().setSelectedItem(getTipoDAO().TipoPorId(idTipo).getTipo());
			getPainelGerenciarProduto().getJComboBoxUnidade()
					.setSelectedItem(getUnidadeDAO().UnidadePorId(idUnidade).getUnidade());
		} catch (Exception e) {
		}
	}

	private void LinhaSelecionada() {
		int codigo = (int) getPainelGerenciarProduto().getJTableProduto()
				.getValueAt(getPainelGerenciarProduto().getJTableProduto().getSelectedRow(), 1);
		int idUnidade = getProdutoDAO().ProdutoPorCodigo(codigo).getIdUnidade();
		int idTipo = getProdutoDAO().ProdutoPorCodigo(codigo).getIdTipo();
		getPainelGerenciarProduto().getJTextFieldCodigo().setText(Integer.toString(codigo));
		getPainelGerenciarProduto().getJTextFieldCodigoBarra()
				.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getCodigoBarra()));
		getPainelGerenciarProduto().getJTextFieldDescricao()
				.setText(getProdutoDAO().ProdutoPorCodigo(codigo).getDescricao());
		getPainelGerenciarProduto().getJTextFieldEstoqueMaximo()
				.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getEstoqueMaximo()));
		getPainelGerenciarProduto().getJTextFieldEstoqueMinimo()
				.setText(Integer.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getEstoqueMinimo()));
		double lucro = getProdutoDAO().ProdutoPorCodigo(codigo).getLucro();
		lucro *= 100;
		BigDecimal a = new BigDecimal(lucro);
		BigDecimal roundOff1 = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		lucro = roundOff1.doubleValue();
		getPainelGerenciarProduto().getJTextFieldLucro().setText(Double.toString(lucro).replace(".", ","));
		getPainelGerenciarProduto().getJTextFieldValorCusto()
				.setText(Double.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getValorCusto()).replace(".", ","));
		getPainelGerenciarProduto().getJTextFieldValorVenda()
				.setText(Double.toString(getProdutoDAO().ProdutoPorCodigo(codigo).getValorVenda()).replace(".", ","));
		getPainelGerenciarProduto().getJComboBoxTipo().setSelectedItem(getTipoDAO().TipoPorId(idTipo).getTipo());
		getPainelGerenciarProduto().getJComboBoxUnidade()
				.setSelectedItem(getUnidadeDAO().UnidadePorId(idUnidade).getUnidade());
	}

	private void LimparCampos() {
		getPainelGerenciarProduto().getJTextFieldCodigo().setText("");
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().setText("");
		getPainelGerenciarProduto().getJTextFieldDescricao().setText("");
		getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setText("");
		getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setText("");
		getPainelGerenciarProduto().getJTextFieldLucro().setText("");
		getPainelGerenciarProduto().getJTextFieldValorCusto().setText("");
		getPainelGerenciarProduto().getJTextFieldValorVenda().setText("");
		getPainelGerenciarProduto().getJComboBoxTipo().setSelectedIndex(0);
		getPainelGerenciarProduto().getJComboBoxUnidade().setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelGerenciarProduto().getJButtonIncluir()) {
			LimparCampos();
			OpcaoIncluir();
			alterarProduto = false;
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonCancelar()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarProduto().getJTextFieldPesquisa().setText("");
			getPainelGerenciarProduto().getDefaultTableModel().setNumRows(0);
			getPainelGerenciarProduto().getJComboBoxPesquisa().setSelectedIndex(0);
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonAddTipo()) {
			painelGerenciarTipo = null;
			frameGerenciarTipo = null;
			getFrameGerenciarTipo().addWindowListener(this);
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(false);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(false);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(false);
			getPainelGerenciarTipo().getJButtonCancelar().addActionListener(this);
			getPainelGerenciarTipo().getJButtonConfirmar().addActionListener(this);
			getFrameGerenciarTipo().setContentPane(getPainelGerenciarTipo());
			getFrameGerenciarTipo().repaint();
			getFrameGerenciarTipo().validate();
			alterarTipo = false;
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonRemoverTipo()) {
			if (getPainelGerenciarProduto().getJComboBoxTipo().getSelectedIndex() > 0) {
				int id = getTipoDAO()
						.TipoPorNome(getPainelGerenciarProduto().getJComboBoxTipo().getSelectedItem().toString())
						.getId();
				Tipo tipo = new Tipo();
				String nome = getPainelGerenciarProduto().getJComboBoxTipo().getSelectedItem().toString();
				tipo.setTipo(nome);
				tipo.setId(id);
				getTipoDAO().delete(tipo);
				getPainelGerenciarProduto().getJComboBoxTipo().removeAllItems();
				getPainelGerenciarProduto().getJComboBoxUnidade().removeAllItems();
				PovoarJComboBox();
			}
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonAlterarTipo()) {
			if (getPainelGerenciarProduto().getJComboBoxTipo().getSelectedIndex() > 0) {
				alterarTipo = true;
				painelGerenciarTipo = null;
				frameGerenciarTipo = null;
				getFrameGerenciarTipo().addWindowListener(this);
				getPainelGerenciarTipo().getJButtonCancelar().addActionListener(this);
				getPainelGerenciarTipo().getJButtonConfirmar().addActionListener(this);
				getFrameGerenciarTipo().setContentPane(getPainelGerenciarTipo());
				getPainelGerenciarTipo().getJTextFieldGerenciarTipo()
						.setText(getPainelGerenciarProduto().getJComboBoxTipo().getSelectedItem().toString());
				getFrameGerenciarTipo().repaint();
				getFrameGerenciarTipo().validate();
				getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonCancelar().setEnabled(false);
				getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(false);
				getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(false);
			}
		}
		if (e.getSource() == getPainelGerenciarTipo().getJButtonConfirmar()) {
			if (alterarTipo == false) {
				Tipo tipo = new Tipo();
				String nome = getPainelGerenciarTipo().getJTextFieldGerenciarTipo().getText();
				tipo.setTipo(nome);
				getTipoDAO().create(tipo);
			}
			if (alterarTipo == true) {
				Tipo tipo = new Tipo();
				int id = getTipoDAO()
						.TipoPorNome(getPainelGerenciarProduto().getJComboBoxTipo().getSelectedItem().toString())
						.getId();
				String nome = getPainelGerenciarTipo().getJTextFieldGerenciarTipo().getText();
				tipo.setTipo(nome);
				tipo.setId(id);
				getTipoDAO().update(tipo);
			}
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(true);
			getPainelGerenciarProduto().getJComboBoxTipo().removeAllItems();
			getPainelGerenciarProduto().getJComboBoxUnidade().removeAllItems();
			PovoarJComboBox();
			getFrameGerenciarTipo().dispose();
			getFrameGerenciarTipo().repaint();
			getFrameGerenciarTipo().validate();
		}
		if (e.getSource() == getPainelGerenciarTipo().getJButtonCancelar()) {
			getFrameGerenciarTipo().dispose();
			getFrameGerenciarTipo().repaint();
			getFrameGerenciarTipo().validate();
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(true);
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonAddUnidade()) {
			painelGerenciarUnidade = null;
			frameGerenciarUnidade = null;
			getFrameGerenciarUnidade().addWindowListener(this);
			getPainelGerenciarUnidade().getJButtonCancelar().addActionListener(this);
			getPainelGerenciarUnidade().getJButtonConfirmar().addActionListener(this);
			getFrameGerenciarUnidade().setContentPane(getPainelGerenciarUnidade());
			getFrameGerenciarUnidade().repaint();
			getFrameGerenciarUnidade().validate();
			alterarUnidade = false;
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(false);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(false);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(false);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(false);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(false);
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonRemoverUnidade()) {
			if (getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedIndex() > 0) {
				int id = getUnidadeDAO()
						.UnidadePorNome(getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedItem().toString())
						.getId();
				Unidade unidade = new Unidade();
				String nome = getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedItem().toString();
				unidade.setUnidade(nome);
				unidade.setId(id);
				getUnidadeDAO().delete(unidade);
				getPainelGerenciarProduto().getJComboBoxUnidade().removeAllItems();
				getPainelGerenciarProduto().getJComboBoxTipo().removeAllItems();
				PovoarJComboBox();
			}
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonAlterarUnidade()) {
			if (getPainelGerenciarProduto().getJComboBoxTipo().getSelectedIndex() > 0) {
				alterarUnidade = true;
				painelGerenciarUnidade = null;
				frameGerenciarUnidade = null;
				getFrameGerenciarUnidade().addWindowListener(this);
				getPainelGerenciarUnidade().getJButtonCancelar().addActionListener(this);
				getPainelGerenciarUnidade().getJButtonConfirmar().addActionListener(this);
				getFrameGerenciarUnidade().setContentPane(getPainelGerenciarUnidade());
				getPainelGerenciarUnidade().getJTextFieldGerenciarUnidade()
						.setText(getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedItem().toString());
				getFrameGerenciarUnidade().repaint();
				getFrameGerenciarUnidade().validate();
				getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(false);
				getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(false);
				getPainelGerenciarProduto().getJButtonCancelar().setEnabled(false);
				getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(false);
				getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(false);
			}
		}
		if (e.getSource() == getPainelGerenciarUnidade().getJButtonConfirmar()) {
			if (alterarUnidade == false) {
				Unidade unidade = new Unidade();
				String nome = getPainelGerenciarUnidade().getJTextFieldGerenciarUnidade().getText();
				unidade.setUnidade(nome);
				getUnidadeDAO().create(unidade);
			}
			if (alterarUnidade == true) {
				Unidade Unidade = new Unidade();
				int id = getUnidadeDAO()
						.UnidadePorNome(getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedItem().toString())
						.getId();
				String nome = getPainelGerenciarUnidade().getJTextFieldGerenciarUnidade().getText();
				Unidade.setUnidade(nome);
				Unidade.setId(id);
				getUnidadeDAO().update(Unidade);
			}
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(true);
			getPainelGerenciarProduto().getJComboBoxTipo().removeAllItems();
			getPainelGerenciarProduto().getJComboBoxUnidade().removeAllItems();
			PovoarJComboBox();
			getFrameGerenciarUnidade().dispose();
			getFrameGerenciarUnidade().repaint();
			getFrameGerenciarUnidade().validate();
		}
		if (e.getSource() == getPainelGerenciarUnidade().getJButtonCancelar()) {
			getFrameGerenciarUnidade().dispose();
			getFrameGerenciarUnidade().repaint();
			getFrameGerenciarUnidade().validate();
			getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
			getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
			getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(true);
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonPesquisa()) {
			if (getPainelGerenciarProduto().getJComboBoxPesquisa().getSelectedIndex() > 0) {
				getPainelGerenciarProduto().getDefaultTableModel().setNumRows(0);
				int cont = 0;
				if (getPainelGerenciarProduto().getJComboBoxPesquisa().getSelectedIndex() == 1) {
					String descricao = getPainelGerenciarProduto().getJTextFieldPesquisa().getText().toString();
					for (int i = 0; i < getProdutoDAO().ProdutosPorDescricao(descricao).size(); i++) {
						getPainelGerenciarProduto().getDefaultTableModel().addRow(new Object[] {
								getProdutoDAO().ProdutosPorDescricao(descricao).get(i).getDescricao(),
								getProdutoDAO().ProdutosPorDescricao(descricao).get(i).getCodigo(),
								getTipoDAO()
										.TipoPorId(getProdutoDAO().ProdutosPorDescricao(descricao).get(i).getIdTipo())
										.getTipo(),
								getProdutoDAO().ProdutosPorDescricao(descricao).get(i).getValorVenda() });
						cont++;
					}
				}
				if (getPainelGerenciarProduto().getJComboBoxPesquisa().getSelectedIndex() == 2) {
					try {
						int codigo = Integer
								.parseInt(getPainelGerenciarProduto().getJTextFieldPesquisa().getText().toString());
						if (!getProdutoDAO().ProdutoPorCodigo(codigo).getDescricao().equals("")) {
							getPainelGerenciarProduto().getDefaultTableModel()
									.addRow(new Object[] { getProdutoDAO().ProdutoPorCodigo(codigo).getDescricao(),
											getProdutoDAO().ProdutoPorCodigo(codigo).getCodigo(),
											getTipoDAO().TipoPorId(getProdutoDAO().ProdutoPorCodigo(codigo).getIdTipo())
													.getTipo(),
											getProdutoDAO().ProdutoPorCodigo(codigo).getValorVenda() });
							cont++;
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Campo não preenchido corretamente",
								"Pesquisa", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (getPainelGerenciarProduto().getJComboBoxPesquisa().getSelectedIndex() == 3) {
					try {
						int codigoBarra = Integer
								.parseInt(getPainelGerenciarProduto().getJTextFieldPesquisa().getText().toString());
						if (!getProdutoDAO().ProdutoPorCodigoBarra(codigoBarra).getDescricao().equals("")) {
							getPainelGerenciarProduto().getDefaultTableModel().addRow(new Object[] {
									getProdutoDAO().ProdutoPorCodigoBarra(codigoBarra).getDescricao(),
									getProdutoDAO().ProdutoPorCodigoBarra(codigoBarra).getCodigo(),
									getTipoDAO()
											.TipoPorId(getProdutoDAO().ProdutoPorCodigoBarra(codigoBarra).getIdTipo())
											.getTipo(),
									getProdutoDAO().ProdutoPorCodigoBarra(codigoBarra).getValorVenda() });
							cont++;
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Campo não preenchido corretamente",
								"Pesquisa", JOptionPane.ERROR_MESSAGE);
					}
				}

				if (cont == 0) {
					JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Produto inexistente", "Pesquisa",
							JOptionPane.ERROR_MESSAGE);
				}
				cont = 0;
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonAlterar()) {
			if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
				LinhaSelecionada();
				OpcaoAlterar();
				alterarProduto = true;
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Selecione uma linha da tabela", "Pesquisa",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonConfirmar()) {
			ValidarTelaProduto validarTelaProduto = new ValidarTelaProduto(getPainelGerenciarProduto());
			if (validarTelaProduto.TesteDescricao() && validarTelaProduto.TesteCodigoBarra()
					&& validarTelaProduto.TesteEstoqueMinimo() && validarTelaProduto.TesteEstoqueMaximo()
					&& validarTelaProduto.EstoqueMaximoMenorEstoqueMinimo() && validarTelaProduto.TesteValorCusto()
					&& validarTelaProduto.TesteLucro() && validarTelaProduto.TesteValorVenda()
					&& validarTelaProduto.TesteUnidade() && validarTelaProduto.TesteTipo()) {
				Produto produto = new Produto();
				produto.setCodigoBarra(
						Integer.parseInt(getPainelGerenciarProduto().getJTextFieldCodigoBarra().getText()));
				produto.setDescricao(getPainelGerenciarProduto().getJTextFieldDescricao().getText());
				produto.setEstoqueMaximo(
						Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().getText()));
				produto.setEstoqueMinimo(
						Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().getText()));
				double lucro = Double
						.parseDouble(getPainelGerenciarProduto().getJTextFieldLucro().getText().replace(",", "."));
				lucro /= 100;
				double valVenda = Double
						.parseDouble(getPainelGerenciarProduto().getJTextFieldValorVenda().getText().replace(",", "."));
				BigDecimal a = new BigDecimal(lucro);
				BigDecimal b = new BigDecimal(valVenda);
				BigDecimal roundOff1 = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
				BigDecimal roundOff2 = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
				lucro = roundOff1.doubleValue();
				valVenda = roundOff2.doubleValue();
				produto.setLucro(lucro);
				produto.setValorCusto(Double.parseDouble(
						getPainelGerenciarProduto().getJTextFieldValorCusto().getText().replace(",", ".")));
				produto.setValorVenda(valVenda);
				produto.setIdTipo(getTipoDAO()
						.TipoPorNome(getPainelGerenciarProduto().getJComboBoxTipo().getSelectedItem().toString())
						.getId());
				produto.setIdUnidade(getUnidadeDAO()
						.UnidadePorNome(getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedItem().toString())
						.getId());
				if (alterarProduto == false) {
					if (getProdutoDAO().create(produto)) {
						getPainelGerenciarProduto().getJTextFieldPesquisa().setText("");
						getPainelGerenciarProduto().getDefaultTableModel().setNumRows(0);
						getPainelGerenciarProduto().getJComboBoxPesquisa().setSelectedIndex(0);
						LimparCampos();
						Inicio();
					}
				}
				if (alterarProduto == true) {
					produto.setCodigo(Integer.parseInt(getPainelGerenciarProduto().getJTextFieldCodigo().getText()));
					if (getProdutoDAO().update(produto)) {
						getPainelGerenciarProduto().getJTextFieldPesquisa().setText("");
						getPainelGerenciarProduto().getDefaultTableModel().setNumRows(0);
						getPainelGerenciarProduto().getJComboBoxPesquisa().setSelectedIndex(0);
						LimparCampos();
						Inicio();
					}
				}
			}
		}
		if (e.getSource() == getPainelGerenciarProduto().getJButtonExcluir()) {
			if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
				int opc = JOptionPane.showConfirmDialog(getFrameGerenciarProduto(), "Deseja excluir esse produto?",
						"Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
				if (opc == 0) {
					Produto produto = new Produto();
					produto.setCodigo((int) getPainelGerenciarProduto().getJTableProduto()
							.getValueAt(getPainelGerenciarProduto().getJTableProduto().getSelectedRow(), 1));
					getProdutoDAO().delete(produto);
					getPainelGerenciarProduto().getDefaultTableModel().setNumRows(0);
					getPainelGerenciarProduto().getJComboBoxPesquisa().setSelectedIndex(0);
					LimparCampos();
					Inicio();

				}
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarProduto(), "Selecione uma linha da tabela", "Pesquisa",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public static PainelGerenciarProduto getPainelGerenciarProduto() {
		if (painelGerenciarProduto == null) {
			painelGerenciarProduto = new PainelGerenciarProduto();
		}
		return painelGerenciarProduto;
	}

	public static FrameGerenciarProduto getFrameGerenciarProduto() {
		if (frameGerenciarProduto == null) {
			frameGerenciarProduto = new FrameGerenciarProduto();
		}
		return frameGerenciarProduto;
	}

	public static ProdutoDAO getProdutoDAO() {
		if (produtoDAO == null) {
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}

	public static UnidadeDAO getUnidadeDAO() {
		if (unidadeDAO == null) {
			unidadeDAO = new UnidadeDAO();
		}
		return unidadeDAO;
	}

	public static TipoDAO getTipoDAO() {
		if (tipoDAO == null) {
			tipoDAO = new TipoDAO();
		}
		return tipoDAO;
	}

	public static PainelGerenciarTipo getPainelGerenciarTipo() {
		if (painelGerenciarTipo == null) {
			painelGerenciarTipo = new PainelGerenciarTipo();
		}
		return painelGerenciarTipo;
	}

	public static FrameGerenciarTipo getFrameGerenciarTipo() {
		if (frameGerenciarTipo == null) {
			frameGerenciarTipo = new FrameGerenciarTipo();
		}
		return frameGerenciarTipo;
	}

	public static PainelGerenciarUnidade getPainelGerenciarUnidade() {
		if (painelGerenciarUnidade == null) {
			painelGerenciarUnidade = new PainelGerenciarUnidade();
		}
		return painelGerenciarUnidade;
	}

	public static FrameGerenciarUnidade getFrameGerenciarUnidade() {
		if (frameGerenciarUnidade == null) {
			frameGerenciarUnidade = new FrameGerenciarUnidade();
		}
		return frameGerenciarUnidade;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
			if (!getPainelGerenciarProduto().getJTextFieldDescricao().isEnabled()) {
				OpcaoTabela();
			}
			if (getPainelGerenciarProduto().getJButtonIncluir().isEnabled()
					&& getPainelGerenciarProduto().getJButtonAlterar().isEnabled()) {
				LinhaSelecionada();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
				if (!getPainelGerenciarProduto().getJTextFieldDescricao().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarProduto().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarProduto().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("+");
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
				if (!getPainelGerenciarProduto().getJTextFieldDescricao().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarProduto().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarProduto().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("-");
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (getPainelGerenciarProduto().getJTableProduto().getSelectedRow() > -1) {
				if (!getPainelGerenciarProduto().getJTextFieldDescricao().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarProduto().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarProduto().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("+");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarProduto().getJTextFieldLucro().hasFocus()) {
			getPainelGerenciarProduto().getJTextFieldValorVenda().setText("");
			if (!getPainelGerenciarProduto().getJTextFieldValorCusto().getText().equals("")) {
				try {
					double lucro = Double
							.parseDouble(getPainelGerenciarProduto().getJTextFieldLucro().getText().replace(",", "."));
					lucro /= 100;
					lucro += 1;
					double valor = lucro * Double.parseDouble(
							getPainelGerenciarProduto().getJTextFieldValorCusto().getText().replace(",", "."));
					BigDecimal a = new BigDecimal(valor);
					BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
					valor = roundOff.doubleValue();
					getPainelGerenciarProduto().getJTextFieldValorVenda()
							.setText(Double.toString(valor).replace(".", ","));
					getPainelGerenciarProduto().repaint();
					getPainelGerenciarProduto().validate();
				} catch (Exception e2) {
				}
			}
		}
		if (getPainelGerenciarProduto().getJTextFieldValorVenda().hasFocus()) {
			getPainelGerenciarProduto().getJTextFieldLucro().setText("");
			if (!getPainelGerenciarProduto().getJTextFieldValorVenda().getText().equals("")) {
				try {
					double val = Double.parseDouble(
							getPainelGerenciarProduto().getJTextFieldValorVenda().getText().replace(",", "."))
							/ Double.parseDouble(
									getPainelGerenciarProduto().getJTextFieldValorCusto().getText().replace(",", "."));
					val -= 1;
					val *= 100;
					BigDecimal a = new BigDecimal(val);
					BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
					val = roundOff.doubleValue();
					getPainelGerenciarProduto().getJTextFieldLucro().setText(Double.toString(val).replace(".", ","));
					getPainelGerenciarProduto().repaint();
					getPainelGerenciarProduto().validate();
				} catch (Exception e2) {
				}
			}

		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		getFrameGerenciarTipo().dispose();
		getFrameGerenciarTipo().repaint();
		getFrameGerenciarTipo().validate();
		getFrameGerenciarUnidade().dispose();
		getFrameGerenciarUnidade().repaint();
		getFrameGerenciarUnidade().validate();
		getPainelGerenciarProduto().getJButtonAlterarUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAlterarTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonAddUnidade().setEnabled(true);
		getPainelGerenciarProduto().getJButtonRemoverTipo().setEnabled(true);
		getPainelGerenciarProduto().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarProduto().getJButtonPesquisa().setEnabled(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
