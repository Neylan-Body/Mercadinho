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

public class PainelBuscarCliente extends JPanel {

	private JLabel jLabelTitulo;
	private JComboBox<String> jComboBoxPesquisa;
	private JTextField jTextFieldPesquisa;
	private JButton jButtonPesquisar;
	private DefaultTableModel defaultTableModelCliente;
	private JTable jTableCliente;
	private JScrollPane barraRolagemCliente;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelBuscarCliente() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getJLabelTitulo());
		add(getJComboBoxPesquisa());
		add(getJTextFieldPesquisa());
		add(getJButtonPesquisar());
		add(getBarraRolagemCliente());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());

	}

	public JLabel getJLabelTitulo() {
		if (jLabelTitulo == null) {
			jLabelTitulo = new JLabel("Buscar cliente");
			jLabelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelTitulo.setBounds(79, 39, 291, 65);
		}
		return jLabelTitulo;
	}

	public JComboBox<String> getJComboBoxPesquisa() {
		if (jComboBoxPesquisa == null) {
			jComboBoxPesquisa = new JComboBox<String>();
			jComboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));
			jComboBoxPesquisa.setBounds(79, 150, 119, 22);
		}
		return jComboBoxPesquisa;
	}

	public JTextField getJTextFieldPesquisa() {
		if (jTextFieldPesquisa == null) {
			jTextFieldPesquisa = new JTextField();
			jTextFieldPesquisa.setColumns(10);
			jTextFieldPesquisa.setBounds(205, 151, 595, 22);
		}
		return jTextFieldPesquisa;
	}

	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setBounds(810, 150, 173, 23);
		}
		return jButtonPesquisar;
	}

	public DefaultTableModel getDefaultTableModelCliente() {
		if (defaultTableModelCliente == null) {
			defaultTableModelCliente = new DefaultTableModel(new Object[][] {},
					new String[] { "Nome", "CPF", "Código" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelCliente;
	}

	public JTable getJTableCliente() {
		if (jTableCliente == null) {
			jTableCliente = new JTable(getDefaultTableModelCliente());
			jTableCliente.getTableHeader().setReorderingAllowed(false);
			jTableCliente.setRowSelectionAllowed(true);
			jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(300);
			jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
			jTableCliente.setLocation(79, 384);
			jTableCliente.setSize(500, 317);
		}
		return jTableCliente;
	}

	public JScrollPane getBarraRolagemCliente() {
		if (barraRolagemCliente == null) {
			barraRolagemCliente = new JScrollPane(getJTableCliente());
			barraRolagemCliente.setLocation(79, 218);
			barraRolagemCliente.setSize(911, 301);
		}
		return barraRolagemCliente;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(312, 575, 150, 38);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102, 102, 102));
			jButtonCancelar.setBounds(504, 575, 150, 38);
		}
		return jButtonCancelar;
	}
}
