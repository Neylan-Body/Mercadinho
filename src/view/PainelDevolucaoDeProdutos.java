package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PainelDevolucaoDeProdutos extends JPanel{

	
	private JLabel jJLabelDevolucaoDeProdutos;
	private JTextField jTextFieldCodigoDaCompra;
	private JLabel jLabelCodigoDaCompra;
	private JLabel jLabelCodigoDoItem;
	private JTextField jTextFieldCodigoDoItem;
	private JButton jButtonPesquisar;
	private JScrollPane scrollPane;
	private DefaultTableModel DefaultTableModelDevolucaoDeProduto;
	private JTable JTableDevolucaoDeProduto;
	private JScrollPane BarraRolagemProduto;
	private JButton btnDevolver;
	private JButton btnDevolverItem;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	
	
	public PainelDevolucaoDeProdutos()
	{
		setSize(1197,693);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		add(getJLabelGerenciarProduto());
		add(getJTextFieldCodigoDaCompra());
		add(getJLabelCodigoDaCompra());
		add(getJLabelCodigoDoItem());
		add(getJTextFieldCodigoDoItem());
		add(getJButtonPesquisar());
		add(getBarraRolagemProduto());
		add(getBtnDevolver());
		add(getBtnDevolverItem());
		add(getBtnConfirmar());
		add(getBtnCancelar());
	}
	
	
	public JLabel getJLabelGerenciarProduto() {
		if (jJLabelDevolucaoDeProdutos == null) {
			jJLabelDevolucaoDeProdutos = new JLabel("Devolução de produtos");
			jJLabelDevolucaoDeProdutos.setFont(new Font("Arial", Font.BOLD, 32));
			jJLabelDevolucaoDeProdutos.setBounds(79, 39, 489, 65);
		}
		return jJLabelDevolucaoDeProdutos;
	}
	public JTextField getJTextFieldCodigoDaCompra() {
		if (jTextFieldCodigoDaCompra == null) {
			jTextFieldCodigoDaCompra = new JTextField();
			jTextFieldCodigoDaCompra.setColumns(10);
			jTextFieldCodigoDaCompra.setBounds(79, 223, 191, 39);
		}
		return jTextFieldCodigoDaCompra;
	}
	public JLabel getJLabelCodigoDaCompra() {
		if (jLabelCodigoDaCompra == null) {
			jLabelCodigoDaCompra = new JLabel("Codigo da compra");
			jLabelCodigoDaCompra.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCodigoDaCompra.setBounds(79, 186, 154, 22);
		}
		return jLabelCodigoDaCompra;
	}
	public JLabel getJLabelCodigoDoItem() {
		if (jLabelCodigoDoItem == null) {
			jLabelCodigoDoItem = new JLabel("Codigo do item");
			jLabelCodigoDoItem.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCodigoDoItem.setBounds(333, 186, 127, 22);
		}
		return jLabelCodigoDoItem;
	}
	public JTextField getJTextFieldCodigoDoItem() {
		if (jTextFieldCodigoDoItem == null) {
			jTextFieldCodigoDoItem = new JTextField();
			jTextFieldCodigoDoItem.setColumns(10);
			jTextFieldCodigoDoItem.setBounds(333, 223, 191, 39);
		}
		return jTextFieldCodigoDoItem;
	}
	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setForeground(Color.WHITE);
			jButtonPesquisar.setBounds(623, 204, 145, 58);
			jButtonPesquisar.setBackground(new Color(204,0,102));
		}
		return jButtonPesquisar;
	}
	public DefaultTableModel getDefaultTableModelDevolucaoDeProduto() {
		if (DefaultTableModelDevolucaoDeProduto == null) {
			DefaultTableModelDevolucaoDeProduto = new DefaultTableModel(new Object[][] {},
					new String[] { "Código Item", "Código de Barras", "Nome", "Unidade","Quantidade total","Quantidade a ser devolvido" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return DefaultTableModelDevolucaoDeProduto;
	}


	public JTable getJTableDevolucaoDeProduto() {
		if (JTableDevolucaoDeProduto == null) {
			JTableDevolucaoDeProduto = new JTable(getDefaultTableModelDevolucaoDeProduto());
			JTableDevolucaoDeProduto.getTableHeader().setReorderingAllowed(false);
			JTableDevolucaoDeProduto.setRowSelectionAllowed(true);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(0).setPreferredWidth(100);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(1).setPreferredWidth(113);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(2).setPreferredWidth(350);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(3).setPreferredWidth(50);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(4).setPreferredWidth(100);
			JTableDevolucaoDeProduto.getColumnModel().getColumn(5).setPreferredWidth(150);
			JTableDevolucaoDeProduto.setLocation(79, 384);
			JTableDevolucaoDeProduto.setSize(863, 317);
		}
		return JTableDevolucaoDeProduto;
	}

	public JScrollPane getBarraRolagemProduto() {
		if (BarraRolagemProduto == null) {
			BarraRolagemProduto = new JScrollPane(getJTableDevolucaoDeProduto());
			BarraRolagemProduto.setLocation(78, 311);
			BarraRolagemProduto.setSize(1039, 254);
		}
		return BarraRolagemProduto;
	}
	public JButton getBtnDevolver() {
		if (btnDevolver == null) {
			btnDevolver = new JButton(" Devolver todos");
			btnDevolver.setForeground(Color.WHITE);
			btnDevolver.setBackground(new Color(255,0,0));
			btnDevolver.setBounds(213, 613, 145, 58);
		}
		return btnDevolver;
	}
	public JButton getBtnDevolverItem() {
		if (btnDevolverItem == null) {
			btnDevolverItem = new JButton("Devolver item");
			btnDevolverItem.setForeground(Color.WHITE);
			btnDevolverItem.setBackground(new Color(255,102,102));
			btnDevolverItem.setBounds(401, 613, 145, 58);
		}
		return btnDevolverItem;
	}
	public JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setBackground(new Color(102,204,0));
			btnConfirmar.setBounds(592, 613, 145, 58);
		}
		return btnConfirmar;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(new Color(102,102,102));
			btnCancelar.setBounds(778, 613, 145, 58);
		}
		return btnCancelar;
	}
}
