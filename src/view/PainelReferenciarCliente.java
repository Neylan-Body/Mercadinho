package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelReferenciarCliente extends JPanel {

	private JLabel jLabelReferenciarCliente;
	private JLabel jLabelCpf;
	private JTextField jTextFieldCPF;
	private JButton jButtonCancelar;
	private JButton jButtonConfirmar;

	public PainelReferenciarCliente() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelReferenciarCliente());
		add(getJLabelCpf());
		add(getJTextFieldCPF());
		add(getJButtonCancelar());
		add(getJButtonConfirmar());
	}

	public JLabel getJLabelReferenciarCliente() {
		if (jLabelReferenciarCliente == null) {
			jLabelReferenciarCliente = new JLabel("Referenciar cliente:");
			jLabelReferenciarCliente.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelReferenciarCliente.setBounds(63, 44, 293, 46);
		}
		return jLabelReferenciarCliente;
	}

	public JLabel getJLabelCpf() {
		if (jLabelCpf == null) {
			jLabelCpf = new JLabel("CPF:");
			jLabelCpf.setFont(new Font("Dialog", Font.BOLD, 20));
			jLabelCpf.setBounds(63, 121, 56, 22);
		}
		return jLabelCpf;
	}

	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setBounds(137, 118, 219, 34);
			jTextFieldCPF.setColumns(10);
		}
		return jTextFieldCPF;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102, 102, 102));
			jButtonCancelar.setBounds(228, 203, 128, 37);
		}
		return jButtonCancelar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(75, 203, 128, 37);
		}
		return jButtonConfirmar;
	}
}
