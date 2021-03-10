package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelGerenciarUnidade extends JPanel {

	private JLabel jLabelGerenciarUnidade;
	private JTextField jTextFieldGerenciarUnidade;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelGerenciarUnidade() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelGerenciarUnidade());
		add(getJTextFieldGerenciarUnidade());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelGerenciarUnidade() {
		if (jLabelGerenciarUnidade == null) {
			jLabelGerenciarUnidade = new JLabel("Gerenciar unidade");
			jLabelGerenciarUnidade.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelGerenciarUnidade.setBounds(57, 43, 293, 30);
		}
		return jLabelGerenciarUnidade;
	}

	public JTextField getJTextFieldGerenciarUnidade() {
		if (jTextFieldGerenciarUnidade == null) {
			jTextFieldGerenciarUnidade = new JTextField();
			jTextFieldGerenciarUnidade.setColumns(10);
			jTextFieldGerenciarUnidade.setBounds(57, 107, 382, 40);
		}
		return jTextFieldGerenciarUnidade;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(57, 199, 145, 40);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(294, 199, 145, 40);
		}
		return jButtonCancelar;
	}
}
