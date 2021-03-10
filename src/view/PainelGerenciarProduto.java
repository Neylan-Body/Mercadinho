package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.FormataMascaras;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PainelGerenciarProduto extends JPanel {
	private JLabel jLabelGerenciarProduto;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelDescricao;
	private JTextField jTextFieldDescricao;
	private JLabel jLabelCodigoBarra;
	private JTextField jTextFieldCodigoBarra;
	private JLabel jLabelEstoqueMinimo;
	private JLabel jLabelEstoqueMaximo;
	private JTextField jTextFieldEstoqueMinimo;
	private JTextField jTextFieldEstoqueMaximo;
	private JLabel jLabelValorDeCusto;
	private JTextField jTextFieldValorCusto;
	private JLabel jLabelLucro;
	private JTextField jTextFieldLucro;
	private JLabel jLabelValorDaVenda;
	private JTextField jTextFieldValorVenda;
	private JLabel jLabelUnidade;
	private JComboBox<String> jComboBoxUnidade;
	private JButton jButtonAddUnidade;
	private JButton jButtonRemoverUnidade;
	private JButton jButtonAlterarUnidade;
	private JLabel jLabelTipo;
	private JComboBox<String> jComboBoxTipo;
	private JButton jButtonAddTipo;
	private JButton jButtonRemoverTipo;
	private JButton jButtonAlterarTipo;
	private JComboBox<String> jComboBoxPesquisa;
	private JTextField jTextFieldPesquisa;
	private JButton jButtonPesquisa;
	private JTable jTableProduto;
	private DefaultTableModel defaultTableModelProduto;
	private JScrollPane barraRolagemProduto;
	private JSeparator separator;
	private JButton jButtonIncluir;
	private JButton jButtonExcluir;
	private JButton jButtonAlterar;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private FormataMascaras formataMascaras;

	public PainelGerenciarProduto() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getJLabelGerenciarProduto());
		add(getJLabelCodigo());
		add(getJTextFieldCodigo());
		add(getJLabelDescricao());
		add(getJTextFieldDescricao());
		add(getJLabelCodigoBarra());
		add(getJTextFieldCodigoBarra());
		add(getJLabelEstoqueMinimo());
		add(getJLabelEstoqueMaximo());
		add(getJTextFieldEstoqueMinimo());
		add(getJTextFieldEstoqueMaximo());
		add(getJLabelValorDeCusto());
		add(getJTextFieldValorCusto());
		add(getJLabelLucro());
		add(getJTextFieldLucro());
		add(getJLabelValorDaVenda());
		add(getJTextFieldValorVenda());
		add(getJLabelUnidade());
		add(getJComboBoxUnidade());
		add(getJButtonAddUnidade());
		add(getJButtonRemoverUnidade());
		add(getJButtonAlterarUnidade());
		add(getJLabelTipo());
		add(getJComboBoxTipo());
		add(getJButtonAddTipo());
		add(getJButtonRemoverTipo());
		add(getJButtonAlterarTipo());
		add(getJComboBoxPesquisa());
		add(getJTextFieldPesquisa());
		add(getJButtonPesquisa());
		add(getBarraRolagemProduto());
		add(getSeparator());
		add(getJButtonIncluir());
		add(getJButtonExcluir());
		add(getJButtonAlterar());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelGerenciarProduto() {
		if (jLabelGerenciarProduto == null) {
			jLabelGerenciarProduto = new JLabel("Gerenciar produto");
			jLabelGerenciarProduto.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelGerenciarProduto.setBounds(79, 39, 489, 65);
		}
		return jLabelGerenciarProduto;
	}

	public JLabel getJLabelCodigo() {
		if (jLabelCodigo == null) {
			jLabelCodigo = new JLabel("Codigo");
			jLabelCodigo.setBounds(79, 135, 46, 22);
		}
		return jLabelCodigo;
	}

	public JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setBounds(79, 152, 191, 22);
			jTextFieldCodigo.setColumns(10);
		}
		return jTextFieldCodigo;
	}

	public JLabel getJLabelDescricao() {
		if (jLabelDescricao == null) {
			jLabelDescricao = new JLabel("Descri\u00E7\u00E3o");
			jLabelDescricao.setBounds(282, 135, 87, 22);
		}
		return jLabelDescricao;
	}

	public JTextField getJTextFieldDescricao() {
		if (jTextFieldDescricao == null) {
			jTextFieldDescricao = new JTextField();
			jTextFieldDescricao.setBounds(282, 152, 234, 22);
			jTextFieldDescricao.setColumns(10);
		}
		return jTextFieldDescricao;
	}

	public JLabel getJLabelCodigoBarra() {
		if (jLabelCodigoBarra == null) {
			jLabelCodigoBarra = new JLabel("Codigo de barra");
			jLabelCodigoBarra.setBounds(526, 135, 119, 22);
		}
		return jLabelCodigoBarra;
	}

	public JTextField getJTextFieldCodigoBarra() {
		if (jTextFieldCodigoBarra == null) {
			jTextFieldCodigoBarra = new JTextField();
			jTextFieldCodigoBarra.setColumns(10);
			jTextFieldCodigoBarra.setBounds(526, 152, 234, 22);
		}
		return jTextFieldCodigoBarra;
	}

	public JLabel getJLabelEstoqueMinimo() {
		if (jLabelEstoqueMinimo == null) {
			jLabelEstoqueMinimo = new JLabel("Estoque minimo");
			jLabelEstoqueMinimo.setBounds(771, 135, 125, 22);
		}
		return jLabelEstoqueMinimo;
	}

	public JLabel getJLabelEstoqueMaximo() {
		if (jLabelEstoqueMaximo == null) {
			jLabelEstoqueMaximo = new JLabel("Estoque maximo");
			jLabelEstoqueMaximo.setBounds(930, 135, 125, 22);
		}
		return jLabelEstoqueMaximo;
	}

	public JTextField getJTextFieldEstoqueMinimo() {
		if (jTextFieldEstoqueMinimo == null) {
			jTextFieldEstoqueMinimo = new JTextField();
			jTextFieldEstoqueMinimo.setColumns(10);
			jTextFieldEstoqueMinimo.setBounds(770, 152, 148, 22);
		}
		return jTextFieldEstoqueMinimo;
	}

	public JTextField getJTextFieldEstoqueMaximo() {
		if (jTextFieldEstoqueMaximo == null) {
			jTextFieldEstoqueMaximo = new JTextField();
			jTextFieldEstoqueMaximo.setColumns(10);
			jTextFieldEstoqueMaximo.setBounds(930, 152, 188, 22);
		}
		return jTextFieldEstoqueMaximo;
	}

	public JLabel getJLabelValorDeCusto() {
		if (jLabelValorDeCusto == null) {
			jLabelValorDeCusto = new JLabel("Valor de custo (R$)");
			jLabelValorDeCusto.setBounds(79, 207, 125, 22);
		}
		return jLabelValorDeCusto;
	}

	public JTextField getJTextFieldValorCusto() {
		if (jTextFieldValorCusto == null) {
			jTextFieldValorCusto = new JTextField();
			jTextFieldValorCusto.setColumns(10);
			jTextFieldValorCusto.setBounds(79, 225, 125, 22);
		}
		return jTextFieldValorCusto;
	}

	public JLabel getJLabelLucro() {
		if (jLabelLucro == null) {
			jLabelLucro = new JLabel("Lucro (%)");
			jLabelLucro.setBounds(214, 207, 66, 22);
		}
		return jLabelLucro;
	}

	public JTextField getJTextFieldLucro() {
		if (jTextFieldLucro == null) {
			jTextFieldLucro = new JTextField();
			jTextFieldLucro.setColumns(10);
			jTextFieldLucro.setBounds(214, 225, 123, 22);
		}
		return jTextFieldLucro;
	}

	public JLabel getJLabelValorDaVenda() {
		if (jLabelValorDaVenda == null) {
			jLabelValorDaVenda = new JLabel("Valor da venda (R$)");
			jLabelValorDaVenda.setBounds(349, 207, 111, 22);
		}
		return jLabelValorDaVenda;
	}

	public JTextField getJTextFieldValorVenda() {
		if (jTextFieldValorVenda == null) {
			jTextFieldValorVenda = new JTextField();
			jTextFieldValorVenda.setColumns(10);
			jTextFieldValorVenda.setBounds(349, 225, 125, 22);
		}
		return jTextFieldValorVenda;
	}

	public JLabel getJLabelUnidade() {
		if (jLabelUnidade == null) {
			jLabelUnidade = new JLabel("Unidade\r\n");
			jLabelUnidade.setBounds(488, 207, 111, 22);
		}
		return jLabelUnidade;
	}

	public JComboBox<String> getJComboBoxUnidade() {
		if (jComboBoxUnidade == null) {
			jComboBoxUnidade = new JComboBox<String>();
			jComboBoxUnidade.setModel(new DefaultComboBoxModel(new String[] { "--" }));
			jComboBoxUnidade.setBounds(484, 224, 119, 22);
		}
		return jComboBoxUnidade;
	}

	public JButton getJButtonAddUnidade() {
		if (jButtonAddUnidade == null) {
			jButtonAddUnidade = new JButton("+");
			jButtonAddUnidade.setBounds(615, 224, 53, 23);
		}
		return jButtonAddUnidade;
	}

	public JButton getJButtonRemoverUnidade() {
		if (jButtonRemoverUnidade == null) {
			jButtonRemoverUnidade = new JButton("-");
			jButtonRemoverUnidade.setBounds(680, 224, 53, 23);
		}
		return jButtonRemoverUnidade;
	}

	public JButton getJButtonAlterarUnidade() {
		if (jButtonAlterarUnidade == null) {
			jButtonAlterarUnidade = new JButton("A");
			jButtonAlterarUnidade.setBounds(745, 224, 53, 23);
		}
		return jButtonAlterarUnidade;
	}

	public JLabel getJLabelTipo() {
		if (jLabelTipo == null) {
			jLabelTipo = new JLabel("Tipo");
			jLabelTipo.setBounds(808, 207, 27, 22);
		}
		return jLabelTipo;
	}

	public JComboBox<String> getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox<String>();
			jComboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "--" }));
			jComboBoxTipo.setBounds(808, 224, 119, 22);
		}
		return jComboBoxTipo;
	}

	public JButton getJButtonAddTipo() {
		if (jButtonAddTipo == null) {
			jButtonAddTipo = new JButton("+");
			jButtonAddTipo.setBounds(935, 224, 53, 23);
		}
		return jButtonAddTipo;
	}

	public JButton getJButtonRemoverTipo() {
		if (jButtonRemoverTipo == null) {
			jButtonRemoverTipo = new JButton("-");
			jButtonRemoverTipo.setBounds(1000, 224, 53, 23);
		}
		return jButtonRemoverTipo;
	}

	public JButton getJButtonAlterarTipo() {
		if (jButtonAlterarTipo == null) {
			jButtonAlterarTipo = new JButton("A");
			jButtonAlterarTipo.setBounds(1065, 224, 53, 23);
		}
		return jButtonAlterarTipo;
	}

	public JComboBox<String> getJComboBoxPesquisa() {
		if (jComboBoxPesquisa == null) {
			jComboBoxPesquisa = new JComboBox<String>();
			jComboBoxPesquisa.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Descri\u00E7\u00E3o", "Codigo", "Codigo de barras" }));
			jComboBoxPesquisa.setBounds(79, 314, 119, 22);
		}
		return jComboBoxPesquisa;
	}

	public JTextField getJTextFieldPesquisa() {
		if (jTextFieldPesquisa == null) {
			jTextFieldPesquisa = new JTextField();
			jTextFieldPesquisa.setColumns(10);
			jTextFieldPesquisa.setBounds(205, 315, 595, 22);
		}
		return jTextFieldPesquisa;
	}

	public JButton getJButtonPesquisa() {
		if (jButtonPesquisa == null) {
			jButtonPesquisa = new JButton("Pesquisar");
			jButtonPesquisa.setBounds(810, 314, 173, 23);
		}
		return jButtonPesquisa;
	}

	public DefaultTableModel getDefaultTableModel() {
		if (defaultTableModelProduto == null) {
			defaultTableModelProduto = new DefaultTableModel(new Object[][] {},
					new String[] { "Descri\u00E7\u00E3o", "Codigo", "Tipo", "Valor venda" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelProduto;
	}

	public JTable getJTableProduto() {
		if (jTableProduto == null) {
			jTableProduto = new JTable(getDefaultTableModel());
			jTableProduto.getTableHeader().setReorderingAllowed(false);
			jTableProduto.setRowSelectionAllowed(true);
			jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(350);
			jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(50);
			jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(250);
			jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(213);
			jTableProduto.setLocation(79, 384);
			jTableProduto.setSize(913, 317);
		}
		return jTableProduto;
	}

	public JScrollPane getBarraRolagemProduto() {
		if (barraRolagemProduto == null) {
			barraRolagemProduto = new JScrollPane(getJTableProduto());
			barraRolagemProduto.setLocation(79, 347);
			barraRolagemProduto.setSize(1039, 254);
		}
		return barraRolagemProduto;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(0, 283, 1340, 2);
		}
		return separator;
	}

	public JButton getJButtonIncluir() {
		if (jButtonIncluir == null) {
			jButtonIncluir = new JButton("Incluir");
			jButtonIncluir.setForeground(Color.WHITE);
			jButtonIncluir.setBackground(new Color (51,0,255));
			jButtonIncluir.setBounds(301, 631, 111, 23);
		}
		return jButtonIncluir;
	}

	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color (255,0,0));
			jButtonExcluir.setBounds(422, 631, 111, 23);
		}
		return jButtonExcluir;
	}

	public JButton getJButtonAlterar() {
		if (jButtonAlterar == null) {
			jButtonAlterar = new JButton("Alterar");
			jButtonAlterar.setForeground(Color.WHITE);
			jButtonAlterar.setBackground(new Color (0,0,0));
			jButtonAlterar.setBounds(547, 631, 111, 23);
		}
		return jButtonAlterar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setBackground(new Color (102,204,0));
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBounds(666, 631, 111, 23);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setBackground(new Color (102,102,102));
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBounds(785, 631, 98, 23);
		}
		return jButtonCancelar;
	}

	public FormataMascaras getFormataMascaras() {
		if(formataMascaras == null) {
			formataMascaras = new FormataMascaras();
		}
		return formataMascaras;
	}
}
