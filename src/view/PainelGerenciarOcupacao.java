package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelGerenciarOcupacao extends JPanel {

	
	private JLabel jLabelGerenciarOcupao;
	private JTextField jTextFieldGerenciarOcupacao;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelGerenciarOcupacao()
	{
		setBackground(Color.LIGHT_GRAY);
		// TODO Auto-generated constructor stub
		setSize(498, 279);
		setLayout(null);
		add(getJLabelGerenciarOcupao());
		add(getJTextFieldGerenciarOcupacao());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}
	public JLabel getJLabelGerenciarOcupao() {
		if (jLabelGerenciarOcupao == null) {
			jLabelGerenciarOcupao = new JLabel("Gerenciar ocupa\u00E7\u00E3o");
			jLabelGerenciarOcupao.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelGerenciarOcupao.setBounds(53, 44, 293, 30);
		}
		return jLabelGerenciarOcupao;
	}
	public JTextField getJTextFieldGerenciarOcupacao() {
		if (jTextFieldGerenciarOcupacao == null) {
			jTextFieldGerenciarOcupacao = new JTextField();
			jTextFieldGerenciarOcupacao.setColumns(10);
			jTextFieldGerenciarOcupacao.setBounds(53, 108, 382, 40);
		}
		return jTextFieldGerenciarOcupacao;
	}
	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(78, 210, 145, 40);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(278, 210, 145, 40);
		}
		return jButtonCancelar;
	}
}
