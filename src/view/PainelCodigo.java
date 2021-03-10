package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCodigo extends JPanel {

	private JLabel jLabelCodigo;
	private JTextField jTextFieldCodigo;
	private JButton jButtonCancelar;
	private JButton jButtonConfirmar;

	public PainelCodigo() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelCodigo());
		add(getJTextFieldCodigo());
		add(getJButtonCancelar());
		add(getJButtonConfirmar());
	}

	public JLabel getJLabelCodigo() {
		if (jLabelCodigo == null) {
			jLabelCodigo = new JLabel("Codigo:");
			jLabelCodigo.setFont(new Font("Dialog", Font.BOLD, 25));
			jLabelCodigo.setBounds(79, 96, 111, 45);
		}
		return jLabelCodigo;
	}

	public JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setBounds(202, 105, 179, 37);
			jTextFieldCodigo.setColumns(10);
		}
		return jTextFieldCodigo;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(262, 197, 162, 46);
		}
		return jButtonCancelar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(79, 197, 162, 46);
		}
		return jButtonConfirmar;
	}
}
