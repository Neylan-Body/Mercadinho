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

public class PainelBuscarProduto extends JPanel {

	private JLabel jLabelBuscaDeProduto;
	private JComboBox<String> jComboBoxPesquisa;
	private JTextField jTextFieldPesquisa;
	private JButton jButtonPesquisa;
	private DefaultTableModel defaultTableModelProduto;
	private JTable jTableProduto;
	private JScrollPane barraRolagemProduto;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelBuscarProduto() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1252, 462);
		setLayout(null);
		add(getJLabelBuscaDeProduto());
		add(getJComboBoxPesquisa());
		add(getJTextFieldPesquisa());
		add(getJButtonPesquisa());
		add(getBarraRolagemProduto());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelBuscaDeProduto() {
		if (jLabelBuscaDeProduto == null) {
			jLabelBuscaDeProduto = new JLabel("Busca de produto");
			jLabelBuscaDeProduto.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelBuscaDeProduto.setBounds(69, 44, 308, 65);
		}
		return jLabelBuscaDeProduto;
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

	public DefaultTableModel getDefaultTableModelProduto() {
		if (defaultTableModelProduto == null) {
			defaultTableModelProduto = new DefaultTableModel(new Object[][] {},
					new String[] { "Descrição", "Código", "Tipo", "Unidade" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelProduto;
	}

	public JTable getJTableProduto() {
		if (jTableProduto == null) {
			jTableProduto = new JTable(getDefaultTableModelProduto());
			jTableProduto.getTableHeader().setReorderingAllowed(false);
			jTableProduto.setRowSelectionAllowed(true);
			jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(400);
			jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
			jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
			jTableProduto.setLocation(79, 384);
			jTableProduto.setSize(700, 317);
		}
		return jTableProduto;
	}

	public JScrollPane getBarraRolagemProduto() {
		if (barraRolagemProduto == null) {
			barraRolagemProduto = new JScrollPane(getJTableProduto());
			barraRolagemProduto.setLocation(69, 197);
			barraRolagemProduto.setSize(1090, 145);
		}
		return barraRolagemProduto;
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
