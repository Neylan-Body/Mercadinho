package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PainelRelatorio extends JPanel {
	private JLabel jLabelRelatrio;
	private JRadioButton jRadioButtonTodasAsVendas;
	private JRadioButton jRadioButtonVendasAReceber;
	private JRadioButton jRadioButtonVendasPagas;
	private JRadioButton jRadioButtonPedidosCancelados;
	private JLabel jLabelDe;
	private JTextField jTextFieldDe;
	private JLabel jLabelAte;
	private JTextField jTextFieldAte;
	private JLabel jLabelCaixa;
	private JComboBox jComboBoxCaixa;
	private JLabel jLabelOperador;
	private JComboBox jComboBoxOperador;
	private JLabel jLabelBuscarCliente;
	private JLabel jLabelNomeDoCliente;
	private JTextField jTextFieldNomeDoCliente;
	private JButton jButtonImprimir;
	private DefaultTableModel defaultTableModelRelatorio;
	private JTable jTableRelatorio;
	private JScrollPane barraRolagemRelatorio;
	private JLabel jLabelTotal;
	private JTextField jTextFieldTotalVendido;
	private JTextField jTextFieldTotalRecebido;
	private JTextField jTextFieldTotalPendente;
	private JButton jButtonSair;
	
	public PainelRelatorio() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getJLabelRelatrio());
		add(getJRadioButtonTodasAsVendas());
		add(getJRadioButtonVendasAReceber());
		add(getJRadioButtonVendasPagas());
		add(getJRadioButtonPedidosCancelados());
		add(getJLabelDe());
		add(getJTextFieldDe());
		add(getJLabelAte());
		add(getJTextFieldAte());
		add(getJLabelCaixa());
		add(getJComboBoxCaixa());
		add(getJLabelOperador());
		add(getJComboBoxOperador());
		add(getJLabelBuscarCliente());
		add(getJLabelNomeDoCliente());
		add(getJTextFieldNomeDoCliente());
		add(getJButtonImprimir());
		add(getBarraRolagemRelatorio());
		add(getJLabelTotal());
		add(getJTextFieldTotalVendido());
		add(getJTextFieldTotalRecebido());
		add(getJTextFieldTotalPendente());
		add(getJButtonSair());
	}
	public JLabel getJLabelRelatrio() {
		if (jLabelRelatrio == null) {
			jLabelRelatrio = new JLabel("Relat\u00F3rio");
			jLabelRelatrio.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelRelatrio.setBounds(79, 39, 199, 65);
		}
		return jLabelRelatrio;
	}
	public JRadioButton getJRadioButtonTodasAsVendas() {
		if (jRadioButtonTodasAsVendas == null) {
			jRadioButtonTodasAsVendas = new JRadioButton("Todas as vendas");
			jRadioButtonTodasAsVendas.setFont(new Font("Tahoma", Font.BOLD, 12));
			jRadioButtonTodasAsVendas.setBackground(Color.LIGHT_GRAY);
			jRadioButtonTodasAsVendas.setBounds(120, 111, 125, 31);
		}
		return jRadioButtonTodasAsVendas;
	}
	public JRadioButton getJRadioButtonVendasAReceber() {
		if (jRadioButtonVendasAReceber == null) {
			jRadioButtonVendasAReceber = new JRadioButton("Vendas a receber");
			jRadioButtonVendasAReceber.setFont(new Font("Tahoma", Font.BOLD, 12));
			jRadioButtonVendasAReceber.setBackground(Color.LIGHT_GRAY);
			jRadioButtonVendasAReceber.setBounds(269, 111, 136, 31);
		}
		return jRadioButtonVendasAReceber;
	}
	public JRadioButton getJRadioButtonVendasPagas() {
		if (jRadioButtonVendasPagas == null) {
			jRadioButtonVendasPagas = new JRadioButton("Vendas pagas");
			jRadioButtonVendasPagas.setFont(new Font("Tahoma", Font.BOLD, 12));
			jRadioButtonVendasPagas.setBackground(Color.LIGHT_GRAY);
			jRadioButtonVendasPagas.setBounds(430, 111, 109, 31);
		}
		return jRadioButtonVendasPagas;
	}
	public JRadioButton getJRadioButtonPedidosCancelados() {
		if (jRadioButtonPedidosCancelados == null) {
			jRadioButtonPedidosCancelados = new JRadioButton("Pedidos cancelados");
			jRadioButtonPedidosCancelados.setFont(new Font("Tahoma", Font.BOLD, 12));
			jRadioButtonPedidosCancelados.setBackground(Color.LIGHT_GRAY);
			jRadioButtonPedidosCancelados.setBounds(571, 111, 143, 31);
		}
		return jRadioButtonPedidosCancelados;
	}
	public JLabel getJLabelDe() {
		if (jLabelDe == null) {
			jLabelDe = new JLabel("De");
			jLabelDe.setFont(new Font("Dialog", Font.BOLD, 15));
			jLabelDe.setBounds(79, 183, 34, 22);
		}
		return jLabelDe;
	}
	public JTextField getJTextFieldDe() {
		if (jTextFieldDe == null) {
			jTextFieldDe = new JTextField();
			jTextFieldDe.setColumns(10);
			jTextFieldDe.setBounds(120, 184, 109, 22);
		}
		return jTextFieldDe;
	}
	public JLabel getJLabelAte() {
		if (jLabelAte == null) {
			jLabelAte = new JLabel("At\u00E9");
			jLabelAte.setFont(new Font("Dialog", Font.BOLD, 15));
			jLabelAte.setBounds(79, 224, 34, 22);
		}
		return jLabelAte;
	}
	public JTextField getJTextFieldAte() {
		if (jTextFieldAte == null) {
			jTextFieldAte = new JTextField();
			jTextFieldAte.setColumns(10);
			jTextFieldAte.setBounds(119, 224, 109, 22);
		}
		return jTextFieldAte;
	}
	public JLabel getJLabelCaixa() {
		if (jLabelCaixa == null) {
			jLabelCaixa = new JLabel("Caixa");
			jLabelCaixa.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCaixa.setBounds(269, 183, 61, 26);
		}
		return jLabelCaixa;
	}
	public JComboBox getJComboBoxCaixa() {
		if (jComboBoxCaixa == null) {
			jComboBoxCaixa = new JComboBox();
			jComboBoxCaixa.setBounds(340, 183, 199, 25);
		}
		return jComboBoxCaixa;
	}
	public JLabel getJLabelOperador() {
		if (jLabelOperador == null) {
			jLabelOperador = new JLabel("Operador");
			jLabelOperador.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelOperador.setBounds(569, 183, 90, 26);
		}
		return jLabelOperador;
	}
	public JComboBox getJComboBoxOperador() {
		if (jComboBoxOperador == null) {
			jComboBoxOperador = new JComboBox();
			jComboBoxOperador.setBounds(667, 183, 168, 25);
		}
		return jComboBoxOperador;
	}
	public JLabel getJLabelBuscarCliente() {
		if (jLabelBuscarCliente == null) {
			jLabelBuscarCliente = new JLabel("Buscar cliente");
			jLabelBuscarCliente.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabelBuscarCliente.setForeground(new Color(22,155,213));
			jLabelBuscarCliente.setBounds(340, 223, 117, 31);
		}
		return jLabelBuscarCliente;
	}
	public JLabel getJLabelNomeDoCliente() {
		if (jLabelNomeDoCliente == null) {
			jLabelNomeDoCliente = new JLabel("Nome do cliente");
			jLabelNomeDoCliente.setFont(new Font("Dialog", Font.BOLD, 15));
			jLabelNomeDoCliente.setBounds(486, 227, 125, 22);
		}
		return jLabelNomeDoCliente;
	}
	public JTextField getJTextFieldNomeDoCliente() {
		if (jTextFieldNomeDoCliente == null) {
			jTextFieldNomeDoCliente = new JTextField();
			jTextFieldNomeDoCliente.setColumns(10);
			jTextFieldNomeDoCliente.setBounds(609, 225, 255, 22);
		}
		return jTextFieldNomeDoCliente;
	}
	public JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton("Imprimir");
			jButtonImprimir.setForeground(Color.WHITE);
			jButtonImprimir.setBackground(new Color(51,204,0));
			jButtonImprimir.setBounds(1007, 179, 98, 42);
		}
		return jButtonImprimir;
	}
	
	public DefaultTableModel getDefaultTableModelRelatorio() {
		if (defaultTableModelRelatorio == null) {
			defaultTableModelRelatorio = new DefaultTableModel(new Object[][] {},
					new String[] { "Número", "Data da venda", "Horário","Data fechamento","Total vendido","Total recebido","Total pendente","Total desconto","Status","Operador(a)" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelRelatorio;
	}
	
	
	
	public JTable getJTableRelatorio() {
		if (jTableRelatorio == null) {
			jTableRelatorio = new JTable(getDefaultTableModelRelatorio());
			jTableRelatorio.getTableHeader().setReorderingAllowed(false);
			jTableRelatorio.setRowSelectionAllowed(true);
			jTableRelatorio.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(1).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(2).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(3).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(4).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(5).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(6).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(7).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(8).setPreferredWidth(50);
			jTableRelatorio.getColumnModel().getColumn(9).setPreferredWidth(50);
			jTableRelatorio.setLocation(79, 384);
			jTableRelatorio.setSize(700, 317);
		}
		return jTableRelatorio;
	}

	public JScrollPane getBarraRolagemRelatorio() {
		if (barraRolagemRelatorio == null) {
			barraRolagemRelatorio = new JScrollPane(getJTableRelatorio());
			barraRolagemRelatorio.setLocation(79, 284);
			barraRolagemRelatorio.setSize(911, 311);
		}
		return barraRolagemRelatorio;
	}
	public JLabel getJLabelTotal() {
		if (jLabelTotal == null) {
			jLabelTotal = new JLabel("Total");
			jLabelTotal.setFont(new Font("Dialog", Font.BOLD, 15));
			jLabelTotal.setBounds(389, 607, 50, 22);
		}
		return jLabelTotal;
	}
	public JTextField getJTextFieldTotalVendido() {
		if (jTextFieldTotalVendido == null) {
			jTextFieldTotalVendido = new JTextField();
			jTextFieldTotalVendido.setColumns(10);
			jTextFieldTotalVendido.setBounds(445, 607, 109, 22);
		}
		return jTextFieldTotalVendido;
	}
	public JTextField getJTextFieldTotalRecebido() {
		if (jTextFieldTotalRecebido == null) {
			jTextFieldTotalRecebido = new JTextField();
			jTextFieldTotalRecebido.setColumns(10);
			jTextFieldTotalRecebido.setBounds(570, 607, 109, 22);
		}
		return jTextFieldTotalRecebido;
	}
	public JTextField getJTextFieldTotalPendente() {
		if (jTextFieldTotalPendente == null) {
			jTextFieldTotalPendente = new JTextField();
			jTextFieldTotalPendente.setColumns(10);
			jTextFieldTotalPendente.setBounds(694, 607, 109, 22);
		}
		return jTextFieldTotalPendente;
	}
	public JButton getJButtonSair() {
		if (jButtonSair == null) {
			jButtonSair = new JButton("Sair");
			jButtonSair.setForeground(Color.WHITE);
			jButtonSair.setBackground(new Color(255,0,0));
			jButtonSair.setBounds(864, 611, 98, 31);
		}
		return jButtonSair;
	}
}
