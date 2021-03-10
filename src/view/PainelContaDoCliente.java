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

public class PainelContaDoCliente extends JPanel {

	private JLabel jLabelContaDoCliente;
	private JLabel jLabelCpf;
	private JTextField jTextFieldCPF;
	private JButton jButtonPesquisar;
	private JLabel jLabelCliente;
	private JTextField jTextFieldCliente;
	private JLabel jLabelLimiteTotal;
	private JTextField jTextFieldLimiteTotal;
	private JLabel jLabelLimiteUtilizado;
	private JTextField jTextFieldLimiteUtilizado;
	private JLabel jLabelLimiteRestante;
	private JTextField jTextFieldLimiteRestante;
	private DefaultTableModel defaultTableModelEntregaEsquerda;
	private JTable jTableEntregaEsquerda;
	private JScrollPane barraRolagemEntregaEsquerda;
	private DefaultTableModel defaultTableModelEntregaDireita;
	private JTable jTableEntregaDireita;
	private JScrollPane barraRolagemEntregaDireita;
	private JButton jButtonUmMaiorQue;
	private JButton jButtonDoisMaiorQue;
	private JButton jButtonUmMenorQue;
	private JButton jButtonDoisMenorQue;
	private JLabel jLabelTotalDevedor;
	private JTextField jTextFieldTotalAPagar;
	private JLabel jLabelTotalAPagar;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private JTextField jTextFieldTotalDevedor;

	public PainelContaDoCliente() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getJLabelContaDoCliente());
		add(getJLabelCpf());
		add(getJTextFieldCPF());
		add(getJButtonPesquisar());
		add(getJLabelCliente());
		add(getJTextFieldCliente());
		add(getJLabelLimiteTotal());
		add(getJTextFieldLimiteTotal());
		add(getJLabelLimiteUtilizado());
		add(getJTextFieldLimiteUtilizado());
		add(getJLabelLimiteRestante());
		add(getJTextFieldLimiteRestante());
		add(getBarraRolagemEntregaEsquerda());
		add(getBarraRolagemEntregaDireita());
		add(getJButtonUmMaiorQue());
		add(getJButtonDoisMaiorQue());
		add(getJButtonUmMenorQue());
		add(getJButtonDoisMenorQue());
		add(getJLabelTotalDevedor());
		add(getJTextFieldTotalAPagar());
		add(getJLabelTotalAPagar());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
		add(getTextField_5_1());
	}

	public JLabel getJLabelContaDoCliente() {
		if (jLabelContaDoCliente == null) {
			jLabelContaDoCliente = new JLabel("Conta do cliente");
			jLabelContaDoCliente.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelContaDoCliente.setBounds(79, 39, 291, 65);
		}
		return jLabelContaDoCliente;
	}

	public JLabel getJLabelCpf() {
		if (jLabelCpf == null) {
			jLabelCpf = new JLabel("CPF");
			jLabelCpf.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCpf.setBounds(79, 137, 68, 22);
		}
		return jLabelCpf;
	}

	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setBounds(79, 163, 126, 22);
			jTextFieldCPF.setColumns(10);
		}
		return jTextFieldCPF;
	}

	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setForeground(Color.WHITE);
			jButtonPesquisar.setBackground(new Color(204, 0, 102));
			jButtonPesquisar.setBounds(226, 163, 100, 23);
		}
		return jButtonPesquisar;
	}

	public JLabel getJLabelCliente() {
		if (jLabelCliente == null) {
			jLabelCliente = new JLabel("Cliente");
			jLabelCliente.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCliente.setBounds(351, 137, 68, 22);
		}
		return jLabelCliente;
	}

	public JTextField getJTextFieldCliente() {
		if (jTextFieldCliente == null) {
			jTextFieldCliente = new JTextField();
			jTextFieldCliente.setColumns(10);
			jTextFieldCliente.setBounds(351, 163, 126, 22);
		}
		return jTextFieldCliente;
	}

	public JLabel getJLabelLimiteTotal() {
		if (jLabelLimiteTotal == null) {
			jLabelLimiteTotal = new JLabel("Limite total");
			jLabelLimiteTotal.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelLimiteTotal.setBounds(502, 137, 108, 22);
		}
		return jLabelLimiteTotal;
	}

	public JTextField getJTextFieldLimiteTotal() {
		if (jTextFieldLimiteTotal == null) {
			jTextFieldLimiteTotal = new JTextField();
			jTextFieldLimiteTotal.setColumns(10);
			jTextFieldLimiteTotal.setBounds(502, 163, 126, 22);
		}
		return jTextFieldLimiteTotal;
	}

	public JLabel getJLabelLimiteUtilizado() {
		if (jLabelLimiteUtilizado == null) {
			jLabelLimiteUtilizado = new JLabel("Limite utilizado");
			jLabelLimiteUtilizado.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelLimiteUtilizado.setBounds(655, 137, 126, 22);
		}
		return jLabelLimiteUtilizado;
	}

	public JTextField getJTextFieldLimiteUtilizado() {
		if (jTextFieldLimiteUtilizado == null) {
			jTextFieldLimiteUtilizado = new JTextField();
			jTextFieldLimiteUtilizado.setColumns(10);
			jTextFieldLimiteUtilizado.setBounds(655, 163, 126, 22);
		}
		return jTextFieldLimiteUtilizado;
	}

	public JLabel getJLabelLimiteRestante() {
		if (jLabelLimiteRestante == null) {
			jLabelLimiteRestante = new JLabel("Limite Restante");
			jLabelLimiteRestante.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelLimiteRestante.setBounds(799, 137, 126, 22);
		}
		return jLabelLimiteRestante;
	}

	public JTextField getJTextFieldLimiteRestante() {
		if (jTextFieldLimiteRestante == null) {
			jTextFieldLimiteRestante = new JTextField();
			jTextFieldLimiteRestante.setColumns(10);
			jTextFieldLimiteRestante.setBounds(799, 163, 126, 22);
		}
		return jTextFieldLimiteRestante;
	}

	public DefaultTableModel getDefaultTableModelEntregaEsquerda() {
		if (defaultTableModelEntregaEsquerda == null) {
			defaultTableModelEntregaEsquerda = new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Descrição", "Quantidade" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelEntregaEsquerda;
	}

	public JTable getJTableEntregaEsquerda() {
		if (jTableEntregaEsquerda == null) {
			jTableEntregaEsquerda = new JTable(getDefaultTableModelEntregaEsquerda());
			jTableEntregaEsquerda.getTableHeader().setReorderingAllowed(false);
			jTableEntregaEsquerda.setRowSelectionAllowed(true);
			jTableEntregaEsquerda.getColumnModel().getColumn(0).setPreferredWidth(150);
			jTableEntregaEsquerda.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableEntregaEsquerda.getColumnModel().getColumn(2).setPreferredWidth(110);
			jTableEntregaEsquerda.setLocation(79, 384);
			jTableEntregaEsquerda.setSize(700, 317);
		}
		return jTableEntregaEsquerda;
	}

	public JScrollPane getBarraRolagemEntregaEsquerda() {
		if (barraRolagemEntregaEsquerda == null) {
			barraRolagemEntregaEsquerda = new JScrollPane(getJTableEntregaEsquerda());
			barraRolagemEntregaEsquerda.setLocation(82, 209);
			barraRolagemEntregaEsquerda.setSize(370, 366);
		}
		return barraRolagemEntregaEsquerda;
	}

	public DefaultTableModel getDefaultTableModelEntregaDireita() {
		if (defaultTableModelEntregaDireita == null) {
			defaultTableModelEntregaDireita = new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Descrição", "Quantidade" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelEntregaDireita;
	}

	public JTable getJTableEntregaDireita() {
		if (jTableEntregaDireita == null) {
			jTableEntregaDireita = new JTable(getDefaultTableModelEntregaEsquerda());
			jTableEntregaDireita.getTableHeader().setReorderingAllowed(false);
			jTableEntregaDireita.setRowSelectionAllowed(true);
			jTableEntregaDireita.getColumnModel().getColumn(0).setPreferredWidth(150);
			jTableEntregaDireita.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableEntregaDireita.getColumnModel().getColumn(2).setPreferredWidth(110);
			jTableEntregaDireita.setLocation(79, 384);
			jTableEntregaDireita.setSize(700, 317);
		}
		return jTableEntregaDireita;
	}

	public JScrollPane getBarraRolagemEntregaDireita() {
		if (barraRolagemEntregaDireita == null) {
			barraRolagemEntregaDireita = new JScrollPane(getJTableEntregaDireita());
			barraRolagemEntregaDireita.setLocation(556, 209);
			barraRolagemEntregaDireita.setSize(370, 366);
		}
		return barraRolagemEntregaDireita;
	}

	public JButton getJButtonUmMaiorQue() {
		if (jButtonUmMaiorQue == null) {
			jButtonUmMaiorQue = new JButton(">");
			jButtonUmMaiorQue.setBounds(468, 270, 66, 23);
		}
		return jButtonUmMaiorQue;
	}

	public JButton getJButtonDoisMaiorQue() {
		if (jButtonDoisMaiorQue == null) {
			jButtonDoisMaiorQue = new JButton(">>");
			jButtonDoisMaiorQue.setBounds(468, 339, 66, 23);
		}
		return jButtonDoisMaiorQue;
	}

	public JButton getJButtonUmMenorQue() {
		if (jButtonUmMenorQue == null) {
			jButtonUmMenorQue = new JButton("<");
			jButtonUmMenorQue.setBounds(468, 421, 66, 23);
		}
		return jButtonUmMenorQue;
	}

	public JButton getJButtonDoisMenorQue() {
		if (jButtonDoisMenorQue == null) {
			jButtonDoisMenorQue = new JButton("<<");
			jButtonDoisMenorQue.setBounds(468, 512, 66, 23);
		}
		return jButtonDoisMenorQue;
	}

	public JLabel getJLabelTotalDevedor() {
		if (jLabelTotalDevedor == null) {
			jLabelTotalDevedor = new JLabel("Total devedor:");
			jLabelTotalDevedor.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelTotalDevedor.setBounds(79, 587, 126, 22);
		}
		return jLabelTotalDevedor;
	}

	public JTextField getJTextFieldTotalAPagar() {
		if (jTextFieldTotalAPagar == null) {
			jTextFieldTotalAPagar = new JTextField();
			jTextFieldTotalAPagar.setColumns(10);
			jTextFieldTotalAPagar.setBounds(689, 589, 145, 25);
		}
		return jTextFieldTotalAPagar;
	}

	public JLabel getJLabelTotalAPagar() {
		if (jLabelTotalAPagar == null) {
			jLabelTotalAPagar = new JLabel("Total a pagar:");
			jLabelTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelTotalAPagar.setBounds(556, 587, 126, 22);
		}
		return jLabelTotalAPagar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(332, 643, 150, 38);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102, 102, 102));
			jButtonCancelar.setBounds(524, 643, 150, 38);
		}
		return jButtonCancelar;
	}

	public JTextField getTextField_5_1() {
		if (jTextFieldTotalDevedor == null) {
			jTextFieldTotalDevedor = new JTextField();
			jTextFieldTotalDevedor.setColumns(10);
			jTextFieldTotalDevedor.setBounds(204, 587, 145, 25);
		}
		return jTextFieldTotalDevedor;
	}
}
