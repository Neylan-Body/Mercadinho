package controller;

import view.FrameDevolucaoDeProdutos;
import view.PainelDevolucaoDeProdutos;

public class ControladorTelaDevolucaoDeProdutos {

	private static FrameDevolucaoDeProdutos frameDevolucaoDeProdutos;
	private static PainelDevolucaoDeProdutos painelDevolucaoDeProdutos;

	public ControladorTelaDevolucaoDeProdutos(FrameDevolucaoDeProdutos frameDevolucaoDeProdutos,
			PainelDevolucaoDeProdutos painelDevolucaoDeProdutos) {
		this.frameDevolucaoDeProdutos = frameDevolucaoDeProdutos;
		this.painelDevolucaoDeProdutos = painelDevolucaoDeProdutos;
	}

	public static FrameDevolucaoDeProdutos getFrameDevolucaoDeProdutos() {
		if (frameDevolucaoDeProdutos == null) {
			frameDevolucaoDeProdutos = new FrameDevolucaoDeProdutos();
		}
		return frameDevolucaoDeProdutos;
	}

	public static PainelDevolucaoDeProdutos getPainelDevolucaoDeProdutos() {
		if (painelDevolucaoDeProdutos == null) {
			painelDevolucaoDeProdutos = new PainelDevolucaoDeProdutos();
		}
		return painelDevolucaoDeProdutos;
	}
}
