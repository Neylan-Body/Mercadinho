package model;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home {
	
	 private JPasswordField Senha;
	 private JTextField	login;
	 
	 public Home(JPasswordField Senha, JTextField	login )
	 {
		 this.login = login;
		 this.Senha = Senha;
	 }
	 
	public JPasswordField getSenha() {
		return Senha;
	}
	public void setSenha(JPasswordField senha) {
		Senha = senha;
	}
	public JTextField getLogin() {
		return login;
	}
	public void setLogin(JTextField login) {
		this.login = login;
	}

}
