package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class PainelControleDeEstoque extends JPanel {
	private JLabel lblControleDeEstoque;
	private JLabel jLabelFornecedor;
	private JTextField jTextFieldFornecedor;
	private JTextField jTextFieldCnpj_cpf;
	private JLabel jLabelCnpj_cpf;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldEndereco;
	private JLabel jLabelEndereo;
	private JButton jButtonPesquisarFornecedor;
	private JRadioButton jRadioButtonEntrada;
	private JRadioButton jRadioButtonSaida;
	private JTextField jTextFieldNatureza;
	private JLabel jLabelNatureza;
	private JTextField jTextFieldData;
	private JLabel jLabelData;
	private JLabel jLabelHora;
	private JTextField jTextFieldHora;
	private JSeparator separator;
	private JTextField jTextFieldCodigoPesquisa;
	private JLabel jLabelCodigoPesquisa;
	private JButton jButtonPesquisarProduto;
	private JLabel jLabelProduto;
	private JTextField jTextFieldProduto;
	private JLabel jLabelQuantidade;
	private JTextField jTextFieldQuantidade;
	private JLabel jLabelUnidade;
	private JLabel jLabelValorDeCusto;
	private JTextField jTextFieldValorDeCusto;
	private JButton jButtonIncluir;
	private JButton jButtonExcluir;
	private JTable jTableProduto;
	private DefaultTableModel defaultTableModelProduto;
	private JScrollPane barraRolagemProduto;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private JTextField jTextFieldUnidade;
	
	
	public PainelControleDeEstoque() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197,693);
		setLayout(null);
		add(getLblControleDeEstoque());
		add(getJLabelFornecedor());
		add(getJTextFieldFornecedor());
		add(getJTextFieldCnpj_cpf());
		add(getJLabelCnpj_cpf());
		add(getJTextFieldCodigo());
		add(getJLabelCodigo());
		add(getJTextFieldEndereco());
		add(getJLabelEndereo());
		add(getJButtonPesquisarFornecedor());
		add(getJRadioButtonEntrada());
		add(getJRadioButtonSaida());
		add(getJTextFieldNatureza());
		add(getJLabelNatureza());
		add(getJTextFieldData());
		add(getJLabelData());
		add(getJLabelHora());
		add(getJTextFieldHora());
		add(getSeparator());
		add(getJTextFieldCodigoPesquisa());
		add(getJLabelCodigoPesquisa());
		add(getJButtonPesquisarProduto());
		add(getJLabelProduto());
		add(getJTextFieldProduto());
		add(getJLabelQuantidade());
		add(getJTextFieldQuantidade());
		add(getJLabelUnidade());
		add(getJLabelValorDeCusto());
		add(getJTextFieldValorDeCusto());
		add(getJButtonIncluir());
		add(getJButtonExcluir());
		add(getBarraRolagemProduto());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
		add(getTextField_10_1());
	}
	public JLabel getLblControleDeEstoque() {
		if (lblControleDeEstoque == null) {
			lblControleDeEstoque = new JLabel("Controle de estoque");
			lblControleDeEstoque.setFont(new Font("Arial", Font.BOLD, 32));
			lblControleDeEstoque.setBounds(79, 39, 339, 65);
		}
		return lblControleDeEstoque;
	}
	public JLabel getJLabelFornecedor() {
		if (jLabelFornecedor == null) {
			jLabelFornecedor = new JLabel("Fornecedor");
			jLabelFornecedor.setBounds(79, 132, 71, 22);
		}
		return jLabelFornecedor;
	}
	public JTextField getJTextFieldFornecedor() {
		if (jTextFieldFornecedor == null) {
			jTextFieldFornecedor = new JTextField();
			jTextFieldFornecedor.setColumns(10);
			jTextFieldFornecedor.setBounds(79, 149, 239, 22);
		}
		return jTextFieldFornecedor;
	}
	public JTextField getJTextFieldCnpj_cpf() {
		if (jTextFieldCnpj_cpf == null) {
			jTextFieldCnpj_cpf = new JTextField();
			jTextFieldCnpj_cpf.setColumns(10);
			jTextFieldCnpj_cpf.setBounds(337, 149, 109, 22);
		}
		return jTextFieldCnpj_cpf;
	}
	public JLabel getJLabelCnpj_cpf() {
		if (jLabelCnpj_cpf == null) {
			jLabelCnpj_cpf = new JLabel("CNPJ/CPF");
			jLabelCnpj_cpf.setBounds(337, 132, 71, 22);
		}
		return jLabelCnpj_cpf;
	}
	public JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setColumns(10);
			jTextFieldCodigo.setBounds(467, 149, 109, 22);
		}
		return jTextFieldCodigo;
	}
	public JLabel getJLabelCodigo() {
		if (jLabelCodigo == null) {
			jLabelCodigo = new JLabel("C\u00F3digo");
			jLabelCodigo.setBounds(467, 132, 71, 22);
		}
		return jLabelCodigo;
	}
	public JTextField getJTextFieldEndereco() {
		if (jTextFieldEndereco == null) {
			jTextFieldEndereco = new JTextField();
			jTextFieldEndereco.setColumns(10);
			jTextFieldEndereco.setBounds(594, 149, 179, 22);
		}
		return jTextFieldEndereco;
	}
	public JLabel getJLabelEndereo() {
		if (jLabelEndereo == null) {
			jLabelEndereo = new JLabel("Endere\u00E7o");
			jLabelEndereo.setBounds(594, 132, 71, 22);
		}
		return jLabelEndereo;
	}
	public JButton getJButtonPesquisarFornecedor() {
		if (jButtonPesquisarFornecedor == null) {
			jButtonPesquisarFornecedor = new JButton("Pesquisar");
			jButtonPesquisarFornecedor.setBackground(new Color(204,0,102));
			jButtonPesquisarFornecedor.setForeground(Color.WHITE);
			jButtonPesquisarFornecedor.setBounds(783, 149, 92, 23);
		}
		return jButtonPesquisarFornecedor;
	}
	public JRadioButton getJRadioButtonEntrada() {
		if (jRadioButtonEntrada == null) {
			jRadioButtonEntrada = new JRadioButton("Entrada");
			jRadioButtonEntrada.setFont(new Font("Dialog", Font.BOLD, 14));
			jRadioButtonEntrada.setBackground(Color.LIGHT_GRAY);
			jRadioButtonEntrada.setBounds(79, 192, 82, 29);
		}
		return jRadioButtonEntrada;
	}
	public JRadioButton getJRadioButtonSaida() {
		if (jRadioButtonSaida == null) {
			jRadioButtonSaida = new JRadioButton("Sa\u00EDda");
			jRadioButtonSaida.setFont(new Font("Dialog", Font.BOLD, 14));
			jRadioButtonSaida.setBackground(Color.LIGHT_GRAY);
			jRadioButtonSaida.setBounds(180, 192, 82, 29);
		}
		return jRadioButtonSaida;
	}
	public JTextField getJTextFieldNatureza() {
		if (jTextFieldNatureza == null) {
			jTextFieldNatureza = new JTextField();
			jTextFieldNatureza.setColumns(10);
			jTextFieldNatureza.setBounds(351, 199, 187, 22);
		}
		return jTextFieldNatureza;
	}
	public JLabel getJLabelNatureza() {
		if (jLabelNatureza == null) {
			jLabelNatureza = new JLabel("Natureza");
			jLabelNatureza.setBounds(351, 182, 71, 22);
		}
		return jLabelNatureza;
	}
	public JTextField getJTextFieldData() {
		if (jTextFieldData == null) {
			jTextFieldData = new JTextField();
			jTextFieldData.setColumns(10);
			jTextFieldData.setBounds(79, 256, 109, 22);
		}
		return jTextFieldData;
	}
	public JLabel getJLabelData() {
		if (jLabelData == null) {
			jLabelData = new JLabel("Data");
			jLabelData.setBounds(79, 239, 71, 22);
		}
		return jLabelData;
	}
	public JLabel getJLabelHora() {
		if (jLabelHora == null) {
			jLabelHora = new JLabel("Hora");
			jLabelHora.setBounds(209, 239, 71, 22);
		}
		return jLabelHora;
	}
	public JTextField getJTextFieldHora() {
		if (jTextFieldHora == null) {
			jTextFieldHora = new JTextField();
			jTextFieldHora.setColumns(10);
			jTextFieldHora.setBounds(209, 257, 109, 22);
		}
		return jTextFieldHora;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(0, 312, 1340, 2);
		}
		return separator;
	}
	public JTextField getJTextFieldCodigoPesquisa() {
		if (jTextFieldCodigoPesquisa == null) {
			jTextFieldCodigoPesquisa = new JTextField();
			jTextFieldCodigoPesquisa.setColumns(10);
			jTextFieldCodigoPesquisa.setBounds(79, 358, 130, 22);
		}
		return jTextFieldCodigoPesquisa;
	}
	public JLabel getJLabelCodigoPesquisa() {
		if (jLabelCodigoPesquisa == null) {
			jLabelCodigoPesquisa = new JLabel("C\u00F3digo");
			jLabelCodigoPesquisa.setBounds(79, 341, 71, 22);
		}
		return jLabelCodigoPesquisa;
	}
	public JButton getJButtonPesquisarProduto() {
		if (jButtonPesquisarProduto == null) {
			jButtonPesquisarProduto = new JButton("Pesquisar");
			jButtonPesquisarProduto.setForeground(Color.WHITE);
			jButtonPesquisarProduto.setBackground(new Color(204,0,102));
			jButtonPesquisarProduto.setBounds(220, 358, 92, 23);
		}
		return jButtonPesquisarProduto;
	}
	public JLabel getJLabelProduto() {
		if (jLabelProduto == null) {
			jLabelProduto = new JLabel("Produto");
			jLabelProduto.setBounds(325, 341, 71, 22);
		}
		return jLabelProduto;
	}
	public JTextField getJTextFieldProduto() {
		if (jTextFieldProduto == null) {
			jTextFieldProduto = new JTextField();
			jTextFieldProduto.setColumns(10);
			jTextFieldProduto.setBounds(325, 358, 164, 22);
		}
		return jTextFieldProduto;
	}
	public JLabel getJLabelQuantidade() {
		if (jLabelQuantidade == null) {
			jLabelQuantidade = new JLabel("Quant.");
			jLabelQuantidade.setBounds(519, 341, 71, 22);
		}
		return jLabelQuantidade;
	}
	public JTextField getJTextFieldQuantidade() {
		if (jTextFieldQuantidade == null) {
			jTextFieldQuantidade = new JTextField();
			jTextFieldQuantidade.setColumns(10);
			jTextFieldQuantidade.setBounds(519, 358, 71, 22);
		}
		return jTextFieldQuantidade;
	}
	public JLabel getJLabelUnidade() {
		if (jLabelUnidade == null) {
			jLabelUnidade = new JLabel("Unid.");
			jLabelUnidade.setBounds(625, 341, 71, 22);
		}
		return jLabelUnidade;
	}
	public JLabel getJLabelValorDeCusto() {
		if (jLabelValorDeCusto == null) {
			jLabelValorDeCusto = new JLabel("Valor de custo");
			jLabelValorDeCusto.setBounds(718, 341, 101, 22);
		}
		return jLabelValorDeCusto;
	}
	public JTextField getJTextFieldValorDeCusto() {
		if (jTextFieldValorDeCusto == null) {
			jTextFieldValorDeCusto = new JTextField();
			jTextFieldValorDeCusto.setColumns(10);
			jTextFieldValorDeCusto.setBounds(718, 358, 109, 22);
		}
		return jTextFieldValorDeCusto;
	}
	public JButton getJButtonIncluir() {
		if (jButtonIncluir == null) {
			jButtonIncluir = new JButton("Incluir");
			jButtonIncluir.setForeground(Color.WHITE);
			jButtonIncluir.setBackground(new Color(51,0,255));
			jButtonIncluir.setBounds(837, 358, 71, 23);
		}
		return jButtonIncluir;
	}
	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color(255,0,0));
			jButtonExcluir.setBounds(918, 358, 82, 23);
		}
		return jButtonExcluir;
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
			jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(500);
			jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
			jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(213);
			jTableProduto.setLocation(79, 384);
			jTableProduto.setSize(913, 317);
		}
		return jTableProduto;
	}

	public JScrollPane getBarraRolagemProduto() {
		if (barraRolagemProduto == null) {
			barraRolagemProduto = new JScrollPane(getJTableProduto());
			barraRolagemProduto.setLocation(79, 398);
			barraRolagemProduto.setSize(1039, 221);
		}
		return barraRolagemProduto;
	}
	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(447, 646, 123, 32);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(591, 646, 123, 32);
		}
		return jButtonCancelar;
	}
	public JTextField getTextField_10_1() {
		if (jTextFieldUnidade == null) {
			jTextFieldUnidade = new JTextField();
			jTextFieldUnidade.setColumns(10);
			jTextFieldUnidade.setBounds(625, 359, 71, 22);
		}
		return jTextFieldUnidade;
	}
}
