package controller;

import view.FrameRelatorio;
import view.PainelRelatorio;

public class ControladorTelaRelatorio {

	private static FrameRelatorio frameRelatorio;
	private static PainelRelatorio painelRelatorio;

	public ControladorTelaRelatorio(FrameRelatorio frameRelatorio, PainelRelatorio painelRelatorio) {

		this.frameRelatorio = frameRelatorio;
		this.painelRelatorio = painelRelatorio;
		
	}

	private static FrameRelatorio getFrameRelatorio() {
		if (frameRelatorio == null) {
			frameRelatorio = new FrameRelatorio();
		}
		return frameRelatorio;
	}

	private static PainelRelatorio getPainelRelatorio() {
		if (painelRelatorio == null) {
			painelRelatorio = new PainelRelatorio();
		}
		return painelRelatorio;
	}

}
