package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelExcluirProduto extends JPanel {

	private JLabel jLabelExcluirProdutos;
	private JLabel jLabelMensagem;
	private DefaultTableModel defaultTableModelProduto;
	private JTable jTableProduto;
	private JScrollPane barraRolagemProduto;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private JButton jButtonExcluir;

	public PainelExcluirProduto() {

		setSize(852, 809);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		add(getJLabelExcluirProdutos());
		add(getJLabelMensagem());
		add(getBarraRolagemProduto());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
		add(getJButtonExcluir());
	}

	public JLabel getJLabelExcluirProdutos() {
		if (jLabelExcluirProdutos == null) {
			jLabelExcluirProdutos = new JLabel("Excluir produtos");
			jLabelExcluirProdutos.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelExcluirProdutos.setBounds(73, 65, 276, 65);
		}
		return jLabelExcluirProdutos;
	}

	public JLabel getJLabelMensagem() {
		if (jLabelMensagem == null) {
			jLabelMensagem = new JLabel("Selecione na tabela o produto que deseja excluir");
			jLabelMensagem.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelMensagem.setBounds(73, 189, 408, 22);
		}
		return jLabelMensagem;
	}

	public DefaultTableModel getDefaultTableModelProduto() {
		if (defaultTableModelProduto == null) {
			defaultTableModelProduto = new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Descrição", "Quantidade" }) {
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
			jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(120);
			jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(360);
			jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(120);
			jTableProduto.setLocation(79, 384);
			jTableProduto.setSize(700, 317);
		}
		return jTableProduto;
	}

	public JScrollPane getBarraRolagemProduto() {
		if (barraRolagemProduto == null) {
			barraRolagemProduto = new JScrollPane(getJTableProduto());
			barraRolagemProduto.setLocation(73, 248);
			barraRolagemProduto.setSize(492, 416);
		}
		return barraRolagemProduto;
	}
	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(616, 452, 145, 40);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(616, 514, 145, 40);
		}
		return jButtonCancelar;
	}
	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color(255,0,0));
			jButtonExcluir.setBounds(616, 389, 145, 40);
		}
		return jButtonExcluir;
	}
}
