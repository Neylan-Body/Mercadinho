package controller;

import view.FrameQuantidade;
import view.PainelQuantidade;

public class ControladorTelaQuantidade {

	
	private static FrameQuantidade frameQuantidade;
	private static PainelQuantidade painelQuantidade;
	
	
	public ControladorTelaQuantidade(FrameQuantidade frameQuantidade, PainelQuantidade painelQuantidade)
	{
		this.frameQuantidade = frameQuantidade;
		this.painelQuantidade = painelQuantidade;
		
		getFrameQuantidade().setContentPane(getPainelQuantidade());
		getFrameQuantidade().repaint();
		getFrameQuantidade().validate();
	}
	
	
	public static FrameQuantidade getFrameQuantidade()
	{
		if(frameQuantidade == null)
		{
			frameQuantidade = new FrameQuantidade();
		}
		return frameQuantidade;
	}
	public static PainelQuantidade getPainelQuantidade()
	{
		if(painelQuantidade == null)
		{
			painelQuantidade = new PainelQuantidade();
		}
		return painelQuantidade;
	}
}
