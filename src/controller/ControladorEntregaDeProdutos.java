package controller;

import view.FrameEntregaDeProduto;
import view.PainelEntregaDeProduto;

public class ControladorEntregaDeProdutos {

	private static FrameEntregaDeProduto frameEntregaDeProduto;
	private static PainelEntregaDeProduto painelEntregaDeProduto;

	public ControladorEntregaDeProdutos(FrameEntregaDeProduto frameEntregaDeProduto,
			PainelEntregaDeProduto painelEntregaDeProduto) {
		this.frameEntregaDeProduto = frameEntregaDeProduto;
		this.frameEntregaDeProduto = frameEntregaDeProduto;
		
		
		
	}

	public static FrameEntregaDeProduto getFrameEntregaDeProdutos() {
		if (frameEntregaDeProduto == null) {
			frameEntregaDeProduto = new FrameEntregaDeProduto();
		}
		return frameEntregaDeProduto;
	}

	public static PainelEntregaDeProduto getPainelEntregaDeProdutos() {
		if (painelEntregaDeProduto == null) {
			painelEntregaDeProduto = new PainelEntregaDeProduto();
		}
		return painelEntregaDeProduto;
	}

}
