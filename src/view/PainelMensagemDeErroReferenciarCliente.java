package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelMensagemDeErroReferenciarCliente extends JPanel {

	private JLabel jLabelTitulo;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private JLabel jLabelMensagem;

	public PainelMensagemDeErroReferenciarCliente() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelTitulo());
		add(getJLabelMensagem());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelTitulo() {
		if (jLabelTitulo == null) {
			jLabelTitulo = new JLabel("Mensagem!");
			jLabelTitulo.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelTitulo.setBounds(53, 44, 293, 40);
		}
		return jLabelTitulo;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(93, 210, 145, 40);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(264, 210, 145, 40);
		}
		return jButtonCancelar;
	}

	public JLabel getJLabelMensagem() {
		if (jLabelMensagem == null) {
			jLabelMensagem = new JLabel("Cliente n\u00E3o possui cadastro, deseja completa-lo ?");
			jLabelMensagem.setFont(new Font("Tahoma", Font.BOLD, 15));
			jLabelMensagem.setBounds(63, 122, 372, 40);
		}
		return jLabelMensagem;
	}
}
