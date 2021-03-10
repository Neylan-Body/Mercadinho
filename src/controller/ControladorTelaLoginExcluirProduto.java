package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarProduto;
import view.FrameExcluirProduto;
import view.FrameLoginExcluirProduto;
import view.PainelExcluirProduto;
import view.PainelLoginExcluirProduto;

public class ControladorTelaLoginExcluirProduto implements ActionListener {

	private static FrameLoginExcluirProduto frameLoginExcluirProduto;
	private static FrameExcluirProduto frameExcluirProduto;

	private static PainelLoginExcluirProduto painelLoginExcluirProduto;
	private static PainelExcluirProduto painelExcluirProduto;
	
	private static ControladorTelaExcluirProduto controladorTelaExcluirProduto;

	public ControladorTelaLoginExcluirProduto(FrameLoginExcluirProduto frameLoginExcluirProduto,
			PainelLoginExcluirProduto painelLoginExcluirProduto) {
		this.frameLoginExcluirProduto = frameLoginExcluirProduto;
		this.painelLoginExcluirProduto = painelLoginExcluirProduto;
		Eventos();
	}

	private void Eventos() {
		// TODO Auto-generated method stub
		getPainelLoginExcluirProduto().getJButtonConfirmar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getPainelLoginExcluirProduto().getJButtonConfirmar()) {
			frameExcluirProduto = null;
			painelExcluirProduto = null;
			controladorTelaExcluirProduto = null;
			getFrameExcluirProduto().setContentPane(getPainelExcluirProduto());
			getFrameExcluirProduto().repaint();
			getFrameExcluirProduto().validate();
			getControladorTelaExcluirProduto();
		}
	}

	public static FrameLoginExcluirProduto getFrameLoginExcluirProduto() {
		if (frameLoginExcluirProduto == null) {
			frameLoginExcluirProduto = new FrameLoginExcluirProduto();
		}
		return frameLoginExcluirProduto;
	}

	public static PainelLoginExcluirProduto getPainelLoginExcluirProduto() {
		if (painelLoginExcluirProduto == null) {
			painelLoginExcluirProduto = new PainelLoginExcluirProduto();
		}
		return painelLoginExcluirProduto;
	}

	public static FrameExcluirProduto getFrameExcluirProduto() {
		if(frameExcluirProduto == null) {
			frameExcluirProduto = new FrameExcluirProduto();
		}
		return frameExcluirProduto;
	}

	public static PainelExcluirProduto getPainelExcluirProduto() {
		if(painelExcluirProduto == null) {
			painelExcluirProduto = new PainelExcluirProduto();
		}
		return painelExcluirProduto;
	}

	public static ControladorTelaExcluirProduto getControladorTelaExcluirProduto() {
		if(controladorTelaExcluirProduto == null) {
			controladorTelaExcluirProduto = new ControladorTelaExcluirProduto(getFrameExcluirProduto(), getPainelExcluirProduto());
		}
		return controladorTelaExcluirProduto;
	}

}
