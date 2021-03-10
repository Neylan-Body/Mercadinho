package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarProduto;
import view.FrameControleDeEstoque;
import view.PainelBuscarProduto;
import view.PainelControleDeEstoque;

public class ControladorTelaBuscarProduto implements ActionListener {

	private static FrameBuscarProduto frameBuscarProduto;

	private static PainelBuscarProduto painelBuscarProduto;

	public ControladorTelaBuscarProduto(FrameBuscarProduto frameBuscarProduto,
			PainelBuscarProduto painelBuscarProduto) {
		this.frameBuscarProduto = frameBuscarProduto;
		this.painelBuscarProduto = painelBuscarProduto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static FrameBuscarProduto getFrameBuscarProduto() {
		if (frameBuscarProduto == null) {
			frameBuscarProduto = new FrameBuscarProduto();
		}
		return frameBuscarProduto;
	}

	public static PainelBuscarProduto getPainelBuscarProduto() {
		if (painelBuscarProduto == null) {
			painelBuscarProduto = new PainelBuscarProduto();
		}
		return painelBuscarProduto;
	}

}
