package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PainelBuscarFornecedor extends JPanel {

	private JLabel jLabelBuscaDeFornecedor;
	private JComboBox<String> jComboBoxPesquisa;
	private JTextField jTextFieldPesquisa;
	private JButton jButtonPesquisa;
	private DefaultTableModel defaultTableModelFornecedor;
	private JTable jTableFornecedor;
	private JScrollPane barraRolagemFornecedor;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelBuscarFornecedor() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1252, 462);
		setLayout(null);
		add(getJLabelBuscaDeFornecedor());
		add(getJComboBoxPesquisa());
		add(getJTextFieldPesquisa());
		add(getJButtonPesquisa());
		add(getBarraRolagemFornecedor());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelBuscaDeFornecedor() {
		if (jLabelBuscaDeFornecedor == null) {
			jLabelBuscaDeFornecedor = new JLabel("Busca de fornecedor");
			jLabelBuscaDeFornecedor.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelBuscaDeFornecedor.setBounds(69, 44, 349, 65);
		}
		return jLabelBuscaDeFornecedor;
	}

	public JComboBox<String> getJComboBoxPesquisa() {
		if (jComboBoxPesquisa == null) {
			jComboBoxPesquisa = new JComboBox<String>();
			jComboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));
			jComboBoxPesquisa.setBounds(69, 162, 119, 22);
		}
		return jComboBoxPesquisa;
	}

	public JTextField getJTextFieldPesquisa() {
		if (jTextFieldPesquisa == null) {
			jTextFieldPesquisa = new JTextField();
			jTextFieldPesquisa.setColumns(10);
			jTextFieldPesquisa.setBounds(195, 163, 595, 22);
		}
		return jTextFieldPesquisa;
	}

	public JButton getJButtonPesquisa() {
		if (jButtonPesquisa == null) {
			jButtonPesquisa = new JButton("Pesquisar");
			jButtonPesquisa.setBounds(800, 162, 173, 23);
		}
		return jButtonPesquisa;
	}

	public DefaultTableModel getDefaultTableModelFornecedor() {
		if (defaultTableModelFornecedor == null) {
			defaultTableModelFornecedor = new DefaultTableModel(new Object[][] {},
					new String[] { "Nome", "CPF/CNPJ", "Código", "Endereço" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelFornecedor;
	}

	public JTable getJTableFornecedor() {
		if (jTableFornecedor == null) {
			jTableFornecedor = new JTable(getDefaultTableModelFornecedor());
			jTableFornecedor.getTableHeader().setReorderingAllowed(false);
			jTableFornecedor.setRowSelectionAllowed(true);
			jTableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(300);
			jTableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(100);
			jTableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(200);
			jTableFornecedor.setLocation(79, 384);
			jTableFornecedor.setSize(700, 317);
		}
		return jTableFornecedor;
	}

	public JScrollPane getBarraRolagemFornecedor() {
		if (barraRolagemFornecedor == null) {
			barraRolagemFornecedor = new JScrollPane(getJTableFornecedor());
			barraRolagemFornecedor.setLocation(69, 197);
			barraRolagemFornecedor.setSize(1090, 145);
		}
		return barraRolagemFornecedor;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(345, 377, 156, 39);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(153,153,153));
			jButtonCancelar.setBounds(509, 377, 156, 39);
		}
		return jButtonCancelar;
	}
}
