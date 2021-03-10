package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class PainelLogin extends JPanel{

	private JLabel jLabelLogin;
	private JTextField jTextFieldLogin;
	private JLabel jLabelSenha;
	private JTextField jTextFieldSenha;
	private JLabel jLabelImagem;
	private JButton jButtonEntrar;
	
	public PainelLogin() {
		setSize(1197, 693);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		add(getJLabelLogin());
		add(getJTextFieldLogin());
		add(getJLabelSenha());
		add(getJTextFieldSenha());
		add(getJButtonEntrar());
		add(getjLabelImagem());
	
	}

	public JLabel getJLabelLogin() {
		if (jLabelLogin == null) {
			jLabelLogin = new JLabel("Login");
			jLabelLogin.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelLogin.setBounds(73, 297, 68, 22);
		}
		return jLabelLogin;
	}

	public JTextField getJTextFieldLogin() {
		if (jTextFieldLogin == null) {
			jTextFieldLogin = new JTextField();
			jTextFieldLogin.setColumns(10);
			jTextFieldLogin.setBounds(73, 323, 240, 22);
		}
		return jTextFieldLogin;
	}

	public JLabel getJLabelSenha() {
		if (jLabelSenha == null) {
			jLabelSenha = new JLabel("Senha");
			jLabelSenha.setFont(new Font("Dialog", Font.BOLD, 17));
			jLabelSenha.setBounds(73, 378, 68, 22);
		}
		return jLabelSenha;
	}

	public JTextField getJTextFieldSenha() {
		if (jTextFieldSenha == null) {
			jTextFieldSenha = new JTextField();
			jTextFieldSenha.setColumns(10);
			jTextFieldSenha.setBounds(73, 404, 240, 22);
		}
		return jTextFieldSenha;
	}
	public JButton getJButtonEntrar() {
		if (jButtonEntrar == null) {
			jButtonEntrar = new JButton("Entrar");
			jButtonEntrar.setForeground(Color.WHITE);
			jButtonEntrar.setBackground(Color.DARK_GRAY);
			jButtonEntrar.setBounds(224, 461, 89, 23);
		}
		return jButtonEntrar;
	}
	
	
	public JLabel getjLabelImagem() {
		if (jLabelImagem == null) {
			jLabelImagem = new JLabel();
			jLabelImagem.setIcon(new ImageIcon(PainelLogin.class.getResource("imagem.jpg")));
			jLabelImagem.setBounds(650, 200, 600, 300);
		}
		return jLabelImagem;
	}
}
