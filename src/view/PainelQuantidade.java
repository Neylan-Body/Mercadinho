package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelQuantidade extends JPanel {

	private JLabel jLabelQuantidade;
	private JTextField jTextFieldQuantidade;
	private JButton jButtonCancelar;
	private JButton jButtonConfirmar;

	public PainelQuantidade() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelQuantidade());
		add(getJTextFieldQuantidade());
		add(getJButtonCancelar());
		add(getJButtonConfirmar());
	}

	public JLabel getJLabelQuantidade() {
		if (jLabelQuantidade == null) {
			jLabelQuantidade = new JLabel("Quantidade:");
			jLabelQuantidade.setFont(new Font("Dialog", Font.BOLD, 25));
			jLabelQuantidade.setBounds(63, 97, 168, 45);
		}
		return jLabelQuantidade;
	}

	public JTextField getJTextFieldQuantidade() {
		if (jTextFieldQuantidade == null) {
			jTextFieldQuantidade = new JTextField();
			jTextFieldQuantidade.setBounds(253, 105, 179, 37);
			jTextFieldQuantidade.setColumns(10);
		}
		return jTextFieldQuantidade;
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
