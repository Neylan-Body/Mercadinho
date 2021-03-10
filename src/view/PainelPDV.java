package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PainelPDV extends JPanel {

	
	private JLabel jLabelPdv;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldQuantidade;
	private JLabel jLabelQuantidade;
	private JLabel jLabelValorUnitario;
	private JTextField jTextFieldValorUnitario;
	private JLabel jLavelValorTotal;
	private JTextField jTextFieldValorTotal;

	private DefaultTableModel DefaultTableModelPDV;
	private JTable JTablePDV;
	private JScrollPane BarraRolagemPDV;
	private JLabel jLabelSubtotal;
	private JTextField jTextFieldSubtotal;
	private JTextArea jTextAreaInformacoes;
	
	public PainelPDV()
	{
		setSize(1197,693);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		add(getJLabelPdv());
		add(getJTextFieldCodigo());
		add(getJLabelCodigo());
		add(getJTextFieldQuantidade());
		add(getJLabelQuantidade());
		add(getJLabelValorUnitario());
		add(getJTextFieldValorUnitario());
		add(getJLavelValorTotal());
		add(getJTextFieldValorTotal());
		add(getBarraRolagemPDV());
		add(getJLabelSubtotal());
		add(getJTextFieldSubtotal());
		add(getJTextAreaInformacoes());
	}
	public JLabel getJLabelPdv() {
		if (jLabelPdv == null) {
			jLabelPdv = new JLabel("PDV");
			jLabelPdv.setFont(new Font("Arial", Font.BOLD, 42));
			jLabelPdv.setBounds(79, 30, 105, 65);
		}
		return jLabelPdv;
	}
	public JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setEditable(false);
			jTextFieldCodigo.setBounds(79, 165, 197, 41);
			jTextFieldCodigo.setColumns(10);
		}
		return jTextFieldCodigo;
	}
	public JLabel getJLabelCodigo() {
		if (jLabelCodigo == null) {
			jLabelCodigo = new JLabel("C\u00F3digo");
			jLabelCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
			jLabelCodigo.setBounds(79, 131, 66, 23);
		}
		return jLabelCodigo;
	}
	public JTextField getJTextFieldQuantidade() {
		if (jTextFieldQuantidade == null) {
			jTextFieldQuantidade = new JTextField();
			jTextFieldQuantidade.setEditable(false);
			jTextFieldQuantidade.setColumns(10);
			jTextFieldQuantidade.setBounds(79, 260, 197, 41);
		}
		return jTextFieldQuantidade;
	}
	public JLabel getJLabelQuantidade() {
		if (jLabelQuantidade == null) {
			jLabelQuantidade = new JLabel("Quantidade");
			jLabelQuantidade.setFont(new Font("Tahoma", Font.BOLD, 16));
			jLabelQuantidade.setBounds(79, 226, 127, 23);
		}
		return jLabelQuantidade;
	}
	public JLabel getJLabelValorUnitario() {
		if (jLabelValorUnitario == null) {
			jLabelValorUnitario = new JLabel("Valor Unit\u00E1rio");
			jLabelValorUnitario.setFont(new Font("Tahoma", Font.BOLD, 16));
			jLabelValorUnitario.setBounds(79, 325, 127, 23);
		}
		return jLabelValorUnitario;
	}
	public JTextField getJTextFieldValorUnitario() {
		if (jTextFieldValorUnitario == null) {
			jTextFieldValorUnitario = new JTextField();
			jTextFieldValorUnitario.setEditable(false);
			jTextFieldValorUnitario.setColumns(10);
			jTextFieldValorUnitario.setBounds(79, 359, 197, 41);
		}
		return jTextFieldValorUnitario;
	}
	public JLabel getJLavelValorTotal() {
		if (jLavelValorTotal == null) {
			jLavelValorTotal = new JLabel("Valor Total");
			jLavelValorTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
			jLavelValorTotal.setBounds(79, 427, 127, 23);
		}
		return jLavelValorTotal;
	}
	public JTextField getJTextFieldValorTotal() {
		if (jTextFieldValorTotal == null) {
			jTextFieldValorTotal = new JTextField();
			jTextFieldValorTotal.setEditable(false);
			jTextFieldValorTotal.setColumns(10);
			jTextFieldValorTotal.setBounds(79, 461, 197, 41);
		}
		return jTextFieldValorTotal;
	}

	
	public DefaultTableModel getDefaultTableModelPDV() {
		if (DefaultTableModelPDV == null) {
			DefaultTableModelPDV = new DefaultTableModel(new Object[][] {},
					new String[] { "Cód. Produto", "Descrição", "Quant.", "Valor Unitário","Valor Total"}) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return DefaultTableModelPDV;
	}

	
	public JTable getJTablePDV() {
		if (JTablePDV == null) {
			JTablePDV = new JTable(getDefaultTableModelPDV());
			JTablePDV.getTableHeader().setReorderingAllowed(false);
			JTablePDV.setRowSelectionAllowed(true);
			JTablePDV.getColumnModel().getColumn(0).setPreferredWidth(50);
			JTablePDV.getColumnModel().getColumn(1).setPreferredWidth(210);
			JTablePDV.getColumnModel().getColumn(2).setPreferredWidth(10);
			JTablePDV.getColumnModel().getColumn(3).setPreferredWidth(10);
			JTablePDV.getColumnModel().getColumn(4).setPreferredWidth(10);
			JTablePDV.setLocation(79, 384);
			JTablePDV.setSize(300, 317);
		}
		return JTablePDV;
	}
	
	
	public JScrollPane getBarraRolagemPDV() {
		if (BarraRolagemPDV == null) {
			BarraRolagemPDV = new JScrollPane(getJTablePDV());
			BarraRolagemPDV.setLocation(386, 152);
			BarraRolagemPDV.setSize(739, 402);
		}
		return BarraRolagemPDV;
	}
	public JLabel getJLabelSubtotal() {
		if (jLabelSubtotal == null) {
			jLabelSubtotal = new JLabel("SUBTOTAL:");
			jLabelSubtotal.setFont(new Font("Tahoma", Font.BOLD, 25));
			jLabelSubtotal.setBounds(760, 618, 152, 31);
		}
		return jLabelSubtotal;
	}
	public JTextField getJTextFieldSubtotal() {
		if (jTextFieldSubtotal == null) {
			jTextFieldSubtotal = new JTextField();
			jTextFieldSubtotal.setEditable(false);
			jTextFieldSubtotal.setColumns(10);
			jTextFieldSubtotal.setBounds(922, 614, 203, 41);
		}
		return jTextFieldSubtotal;
	}
	public JTextArea getJTextAreaInformacoes() {
		if (jTextAreaInformacoes == null) {
			jTextAreaInformacoes = new JTextArea();
			jTextAreaInformacoes.setForeground(Color.BLACK);
			jTextAreaInformacoes.setText("[F1] CODIGO\r\n[F2] QUANTIDADE\r\n[F3] BUSCA DE PRODUTO \r\n[F4] PAGAMENTO\r\n[F5] EXCLUIR \r\n[ENTER] CONFIRMAR \r\n[ESC] SAIR ");
			jTextAreaInformacoes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Teclas de atalho", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			jTextAreaInformacoes.setBackground(Color.LIGHT_GRAY);
			jTextAreaInformacoes.setEditable(false);
			jTextAreaInformacoes.setBounds(79, 524, 197, 157);
		}
		return jTextAreaInformacoes;
	}
}
