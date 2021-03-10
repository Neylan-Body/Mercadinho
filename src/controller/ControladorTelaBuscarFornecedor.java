package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarFornecedor;
import view.PainelBuscarFornecedor;

public class ControladorTelaBuscarFornecedor implements ActionListener {

	private static FrameBuscarFornecedor frameBuscarFornecedor;

	private static PainelBuscarFornecedor painelBuscarFornecedor;

	public ControladorTelaBuscarFornecedor(FrameBuscarFornecedor frameBuscarFornecedor,
			PainelBuscarFornecedor painelBuscarFornecedor) {
		this.frameBuscarFornecedor = frameBuscarFornecedor;
		this.painelBuscarFornecedor = painelBuscarFornecedor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static FrameBuscarFornecedor getFrameBuscarFornecedor() {
		if (frameBuscarFornecedor == null) {
			frameBuscarFornecedor = new FrameBuscarFornecedor();
		}
		return frameBuscarFornecedor;
	}

	public static PainelBuscarFornecedor getPainelBuscarFornecedor() {
		if (painelBuscarFornecedor == null) {
			painelBuscarFornecedor = new PainelBuscarFornecedor();
		}
		return painelBuscarFornecedor;
	}

}
