package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelConfirmarPagamento extends JPanel {
	private JLabel jLabelConfirmaoDePagamento;
	private JLabel jLabelFormasDePagamento;
	private JRadioButton jRadioButtonAVista;
	private JRadioButton jRadioButtonAPrazo;
	private JLabel jLabelTotalRecebido;
	private JLabel jLabelDesconto;
	private JLabel jLabelTotalAPagar;
	private JTextField jTextFieldTotalRecebido;
	private JTextField jTextFieldDesconto;
	private JTextField jTextFieldTotalPagar;
	private JLabel jLabelTroco;
	private JTextField jTextFieldTroco;
	private JLabel jLabelCpfDoCliente;
	private JTextField jTextFieldCPFDoCliente;
	private JButton jButtonEntregaDoProduto;
	private JButton jButtonEmitirReciboSimples;
	private JButton jButtonCancelar;
	private JButton jButtonConfirmar;
	private JButton jButtonReferenciarCliente;

	public PainelConfirmarPagamento() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getJLabelConfirmaoDePagamento());
		add(getJLabelFormasDePagamento());
		add(getJRadioButtonAVista());
		add(getJRadioButtonAPrazo());
		add(getJLabelTotalRecebido());
		add(getJLabelDesconto());
		add(getJLabelTotalAPagar());
		add(getJTextFieldTotalRecebido());
		add(getJTextFieldDesconto());
		add(getJTextFieldTotalPagar());
		add(getJLabelTroco());
		add(getJTextFieldTroco());
		add(getJLabelCpfDoCliente());
		add(getJTextFieldCPFDoCliente());
		add(getJButtonEntregaDoProduto());
		add(getJButtonEmitirReciboSimples());
		add(getJButtonCancelar());
		add(getJButtonConfirmar());
		add(getJButtonReferenciarCliente());
	}

	public JLabel getJLabelConfirmaoDePagamento() {
		if (jLabelConfirmaoDePagamento == null) {
			jLabelConfirmaoDePagamento = new JLabel("Confirma\u00E7\u00E3o de pagamento");
			jLabelConfirmaoDePagamento.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelConfirmaoDePagamento.setBounds(79, 39, 489, 65);
		}
		return jLabelConfirmaoDePagamento;
	}

	public JLabel getJLabelFormasDePagamento() {
		if (jLabelFormasDePagamento == null) {
			jLabelFormasDePagamento = new JLabel("Formas de pagamento:");
			jLabelFormasDePagamento.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelFormasDePagamento.setBounds(79, 146, 193, 22);
		}
		return jLabelFormasDePagamento;
	}

	public JRadioButton getJRadioButtonAVista() {
		if (jRadioButtonAVista == null) {
			jRadioButtonAVista = new JRadioButton("\u00C0 vista");
			jRadioButtonAVista.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAVista.setBounds(270, 147, 77, 23);
		}
		return jRadioButtonAVista;
	}

	public JRadioButton getJRadioButtonAPrazo() {
		if (jRadioButtonAPrazo == null) {
			jRadioButtonAPrazo = new JRadioButton("\u00C0 prazo");
			jRadioButtonAPrazo.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAPrazo.setBounds(351, 147, 77, 23);
		}
		return jRadioButtonAPrazo;
	}

	public JLabel getJLabelTotalRecebido() {
		if (jLabelTotalRecebido == null) {
			jLabelTotalRecebido = new JLabel("Total recebido:");
			jLabelTotalRecebido.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelTotalRecebido.setBounds(79, 235, 133, 22);
		}
		return jLabelTotalRecebido;
	}

	public JLabel getJLabelDesconto() {
		if (jLabelDesconto == null) {
			jLabelDesconto = new JLabel("Desconto:");
			jLabelDesconto.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelDesconto.setBounds(79, 306, 105, 22);
		}
		return jLabelDesconto;
	}

	public JLabel getJLabelTotalAPagar() {
		if (jLabelTotalAPagar == null) {
			jLabelTotalAPagar = new JLabel("Total a pagar:");
			jLabelTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelTotalAPagar.setBounds(79, 381, 128, 22);
		}
		return jLabelTotalAPagar;
	}

	public JTextField getJTextFieldTotalRecebido() {
		if (jTextFieldTotalRecebido == null) {
			jTextFieldTotalRecebido = new JTextField();
			jTextFieldTotalRecebido.setBounds(214, 235, 133, 22);
			jTextFieldTotalRecebido.setColumns(10);
		}
		return jTextFieldTotalRecebido;
	}

	public JTextField getJTextFieldDesconto() {
		if (jTextFieldDesconto == null) {
			jTextFieldDesconto = new JTextField();
			jTextFieldDesconto.setColumns(10);
			jTextFieldDesconto.setBounds(214, 303, 133, 22);
		}
		return jTextFieldDesconto;
	}

	public JTextField getJTextFieldTotalPagar() {
		if (jTextFieldTotalPagar == null) {
			jTextFieldTotalPagar = new JTextField();
			jTextFieldTotalPagar.setColumns(10);
			jTextFieldTotalPagar.setBounds(214, 380, 133, 22);
		}
		return jTextFieldTotalPagar;
	}

	public JLabel getJLabelTroco() {
		if (jLabelTroco == null) {
			jLabelTroco = new JLabel("Troco:");
			jLabelTroco.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelTroco.setBounds(215, 521, 69, 22);
		}
		return jLabelTroco;
	}

	public JTextField getJTextFieldTroco() {
		if (jTextFieldTroco == null) {
			jTextFieldTroco = new JTextField();
			jTextFieldTroco.setColumns(10);
			jTextFieldTroco.setBounds(295, 522, 133, 20);
		}
		return jTextFieldTroco;
	}

	public JLabel getJLabelCpfDoCliente() {
		if (jLabelCpfDoCliente == null) {
			jLabelCpfDoCliente = new JLabel("CPF do cliente:");
			jLabelCpfDoCliente.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelCpfDoCliente.setBounds(647, 248, 133, 22);
		}
		return jLabelCpfDoCliente;
	}

	public JTextField getJTextFieldCPFDoCliente() {
		if (jTextFieldCPFDoCliente == null) {
			jTextFieldCPFDoCliente = new JTextField();
			jTextFieldCPFDoCliente.setColumns(10);
			jTextFieldCPFDoCliente.setBounds(782, 247, 217, 23);
		}
		return jTextFieldCPFDoCliente;
	}

	public JButton getJButtonEntregaDoProduto() {
		if (jButtonEntregaDoProduto == null) {
			jButtonEntregaDoProduto = new JButton("Entrega do produto");
			jButtonEntregaDoProduto.setForeground(Color.WHITE);
			jButtonEntregaDoProduto.setBackground(new Color(51, 51, 255));
			jButtonEntregaDoProduto.setBounds(826, 397, 142, 52);
		}
		return jButtonEntregaDoProduto;
	}

	public JButton getJButtonEmitirReciboSimples() {
		if (jButtonEmitirReciboSimples == null) {
			jButtonEmitirReciboSimples = new JButton("Emitir recibo simples");
			jButtonEmitirReciboSimples.setForeground(Color.BLACK);
			jButtonEmitirReciboSimples.setBackground(new Color(255, 255, 0));
			jButtonEmitirReciboSimples.setBounds(808, 548, 165, 39);
		}
		return jButtonEmitirReciboSimples;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(Color.GRAY);
			jButtonCancelar.setBounds(735, 619, 142, 52);
		}
		return jButtonCancelar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(902, 619, 142, 52);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonReferenciarCliente() {
		if (jButtonReferenciarCliente == null) {
			jButtonReferenciarCliente = new JButton("+ Referenciar cliente");
			jButtonReferenciarCliente.setFont(new Font("Dialog", Font.BOLD, 18));
			jButtonReferenciarCliente.setBackground(Color.LIGHT_GRAY);
			jButtonReferenciarCliente.setForeground(Color.BLUE);
			jButtonReferenciarCliente.setBounds(104, 600, 243, 44);
		}
		return jButtonReferenciarCliente;
	}
}
