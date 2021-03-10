package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameLogin;
import view.FrameMenuPrincipal;
import view.PainelLogin;
import view.PainelMenuPrincipal;

public class ControladorTelaLogin implements ActionListener {

	private static FrameLogin frameLogin;
	private static FrameMenuPrincipal frameMenuPrincipal;

	private static PainelLogin painelLogin;
	private static PainelMenuPrincipal painelMenuPrincipal;

	private static ControladorTelaMenuPrincipal controladorTelaMenuPrincipal;

	public ControladorTelaLogin(FrameLogin frameLogin, PainelLogin painelLogin) {
		this.frameLogin = frameLogin;
		this.painelLogin = painelLogin;
		getFrameLogin().setContentPane(getPainelLogin());
		getFrameLogin().repaint();
		getFrameLogin().validate();
		addAcaoBotoes();
	}

	public void addAcaoBotoes() {
		getPainelLogin().getJButtonEntrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelLogin().getJButtonEntrar()) {
			frameMenuPrincipal = null;
			painelMenuPrincipal = null;
			controladorTelaMenuPrincipal = null;
			getFrameMenuPrincipal().setContentPane(getPainelMenuPrincipal());
			getFrameMenuPrincipal().repaint();
			getFrameMenuPrincipal().validate();
			getControladorTelaMenuPrincipal();
			getFrameLogin().dispose();
			getFrameLogin().repaint();
			getFrameLogin().validate();
		}
	}

	public static PainelLogin getPainelLogin() {
		if (painelLogin == null) {
			painelLogin = new PainelLogin();
		}
		return painelLogin;
	}

	public static FrameLogin getFrameLogin() {
		if (frameLogin == null) {
			frameLogin = new FrameLogin();
		}
		return frameLogin;
	}

	public static FrameMenuPrincipal getFrameMenuPrincipal() {
		if (frameMenuPrincipal == null) {
			frameMenuPrincipal = new FrameMenuPrincipal();
		}
		return frameMenuPrincipal;
	}

	public static PainelMenuPrincipal getPainelMenuPrincipal() {
		if (painelMenuPrincipal == null) {
			painelMenuPrincipal = new PainelMenuPrincipal();
		}
		return painelMenuPrincipal;
	}

	public static ControladorTelaMenuPrincipal getControladorTelaMenuPrincipal() {
		if (controladorTelaMenuPrincipal == null) {
			controladorTelaMenuPrincipal = new ControladorTelaMenuPrincipal(getFrameMenuPrincipal(),
					getPainelMenuPrincipal());
		}
		return controladorTelaMenuPrincipal;
	}

	public static void main(String[] args) {
		new ControladorTelaLogin(getFrameLogin(), getPainelLogin());
	}
}
