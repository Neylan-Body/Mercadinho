package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelLoginExcluirProduto extends JPanel {

	private JLabel jLabelFuncionrio;
	private JLabel jLabelCpf;
	private JTextField jTextFieldCPF;
	private JTextField jTextFieldSenha;
	private JLabel jLabelSenha;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelLoginExcluirProduto() {
		setBackground(Color.LIGHT_GRAY);
		setSize(498, 279);
		setLayout(null);

		add(getJLabelFuncionrio());
		add(getJLabelCpf());
		add(getJTextFieldCPF());
		add(getJTextFieldSenha());
		add(getJLabelSenha());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());

	}

	public JLabel getJLabelFuncionrio() {
		if (jLabelFuncionrio == null) {
			jLabelFuncionrio = new JLabel("Funcion\u00E1rio");
			jLabelFuncionrio.setFont(new Font("Dialog", Font.BOLD, 30));
			jLabelFuncionrio.setBounds(53, 44, 209, 30);
		}
		return jLabelFuncionrio;
	}

	public JLabel getJLabelCpf() {
		if (jLabelCpf == null) {
			jLabelCpf = new JLabel("CPF:");
			jLabelCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
			jLabelCpf.setBounds(26, 129, 49, 30);
		}
		return jLabelCpf;
	}

	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setBounds(69, 129, 154, 27);
			jTextFieldCPF.setColumns(10);
		}
		return jTextFieldCPF;
	}

	public JTextField getJTextFieldSenha() {
		if (jTextFieldSenha == null) {
			jTextFieldSenha = new JTextField();
			jTextFieldSenha.setColumns(10);
			jTextFieldSenha.setBounds(322, 129, 139, 27);
		}
		return jTextFieldSenha;
	}

	public JLabel getJLabelSenha() {
		if (jLabelSenha == null) {
			jLabelSenha = new JLabel("Senha:");
			jLabelSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
			jLabelSenha.setBounds(253, 129, 68, 30);
		}
		return jLabelSenha;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(84, 205, 145, 40);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(274, 205, 145, 40);
		}
		return jButtonCancelar;
	}
}
