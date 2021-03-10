package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameConfirmarPagamento;
import view.FrameReferenciarCliente;
import view.PainelConfirmarPagamento;
import view.PainelReferenciarCliente;

public class ControladorTelaConfirmarPagamento implements ActionListener{

	private static FrameConfirmarPagamento frameConfirmarPagamento;
	private static FrameReferenciarCliente frameReferenciarCliente;
	
	private static PainelConfirmarPagamento painelConfirmarPagamento;
	private static PainelReferenciarCliente painelReferenciarCliente;

	public ControladorTelaConfirmarPagamento(FrameConfirmarPagamento frameConfirmarPagamento,
			PainelConfirmarPagamento painelConfirmarPagamento) {	
		this.frameConfirmarPagamento = frameConfirmarPagamento;
		this.painelConfirmarPagamento = painelConfirmarPagamento;	
		Eventos();
	}
	
	private void Eventos() {
		// TODO Auto-generated method stub
		getPainelConfirmarPagamento().getJButtonReferenciarCliente().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getPainelConfirmarPagamento().getJButtonReferenciarCliente()) {
			frameReferenciarCliente = null;
			painelReferenciarCliente = null;
			getFrameReferenciarCliente().setContentPane(getPainelReferenciarCliente());
			getFrameReferenciarCliente().repaint();
			getFrameReferenciarCliente().validate();
		}
	}

	public static FrameConfirmarPagamento getFrameConfirmarPagamento() {
		if (frameConfirmarPagamento == null) {
			frameConfirmarPagamento = new FrameConfirmarPagamento();
		}
		return frameConfirmarPagamento;
	}

	public static PainelConfirmarPagamento getPainelConfirmarPagamento() {
		if (painelConfirmarPagamento == null) {
			painelConfirmarPagamento = new PainelConfirmarPagamento();
		}
		return painelConfirmarPagamento;
	}

	public static FrameReferenciarCliente getFrameReferenciarCliente() {
		if(frameReferenciarCliente == null) {
			frameReferenciarCliente = new FrameReferenciarCliente();
		}
		return frameReferenciarCliente;
	}

	public static PainelReferenciarCliente getPainelReferenciarCliente() {
		if(painelReferenciarCliente == null) {
			painelReferenciarCliente = new PainelReferenciarCliente();
		}
		return painelReferenciarCliente;
	}
}
