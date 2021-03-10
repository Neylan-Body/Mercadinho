package controller;

import view.FrameExcluirProduto;
import view.PainelExcluirProduto;

public class ControladorTelaExcluirProduto {

	private static PainelExcluirProduto painelExcluirProduto;
	private static FrameExcluirProduto frameExcluirProduto;

	public ControladorTelaExcluirProduto(FrameExcluirProduto frameExcluirProduto,
			PainelExcluirProduto painelExcluirProduto) {
		
		this.frameExcluirProduto = frameExcluirProduto;
		this.painelExcluirProduto = painelExcluirProduto;
	}

	public static PainelExcluirProduto getPainelExcluirProduto() {
		if (painelExcluirProduto == null) {
			painelExcluirProduto = new PainelExcluirProduto();
		}
		return painelExcluirProduto;
	}

	public static FrameExcluirProduto getFrameExcluirProduto() {
		if (frameExcluirProduto == null) {
			frameExcluirProduto = new FrameExcluirProduto();
		}
		return frameExcluirProduto;
	}
}
