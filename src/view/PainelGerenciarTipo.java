package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelGerenciarTipo extends JPanel {

	private JLabel jLabelGerenciarTipo;
	private JTextField jTextFieldGerenciarTipo;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelGerenciarTipo() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelGerenciarTipo());
		add(getJTextFieldGerenciarTipo());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelGerenciarTipo() {
		if (jLabelGerenciarTipo == null) {
			jLabelGerenciarTipo = new JLabel("Gerenciar tipo");
			jLabelGerenciarTipo.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelGerenciarTipo.setBounds(53, 44, 293, 30);
		}
		return jLabelGerenciarTipo;
	}

	public JTextField getJTextFieldGerenciarTipo() {
		if (jTextFieldGerenciarTipo == null) {
			jTextFieldGerenciarTipo = new JTextField();
			jTextFieldGerenciarTipo.setBounds(53, 108, 382, 40);
			jTextFieldGerenciarTipo.setColumns(10);
		}
		return jTextFieldGerenciarTipo;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(53, 200, 145, 40);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102, 102, 102));
			jButtonCancelar.setBounds(290, 200, 145, 40);
		}
		return jButtonCancelar;
	}
}
