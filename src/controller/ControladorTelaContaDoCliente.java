package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarCliente;
import view.FrameContaDoCliente;
import view.PainelBuscarCliente;
import view.PainelContaDoCliente;

public class ControladorTelaContaDoCliente implements ActionListener {

	private static FrameContaDoCliente frameContaDoCliente;
	private static FrameBuscarCliente frameBuscarCliente;
	
	private static PainelContaDoCliente painelContaDoCliente;
	private static PainelBuscarCliente painelBuscarCliente;
	
	private static ControladorTelaBuscarCliente controladorTelaBuscarCliente;

	public ControladorTelaContaDoCliente(FrameContaDoCliente frameContaDoCliente,
			PainelContaDoCliente painelContaDoCliente) {

		this.frameContaDoCliente = frameContaDoCliente;
		this.painelContaDoCliente = painelContaDoCliente;
		Eventos();
	}

	private void Eventos() {
		// TODO Auto-generated method stub
		getPainelContaDoCliente().getJButtonPesquisar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getPainelContaDoCliente().getJButtonPesquisar()) {
			frameBuscarCliente = null;
			painelBuscarCliente = null;
			getFrameBuscarCliente().setContentPane(getPainelBuscarCliente());
			getFrameBuscarCliente().repaint();
			getFrameBuscarCliente().validate();
			getControladorTelaBuscarCliente();
		}
	}

	public static FrameContaDoCliente getFrameContaDoCliente() {
		if (frameContaDoCliente == null) {
			frameContaDoCliente = new FrameContaDoCliente();
		}
		return frameContaDoCliente;
	}

	public static PainelContaDoCliente getPainelContaDoCliente() {
		if (painelContaDoCliente == null) {
			painelContaDoCliente = new PainelContaDoCliente();
		}
		return painelContaDoCliente;
	}

	public static FrameBuscarCliente getFrameBuscarCliente() {
		if(frameBuscarCliente == null) {
			frameBuscarCliente = new FrameBuscarCliente();
		}
		return frameBuscarCliente;
	}

	public static PainelBuscarCliente getPainelBuscarCliente() {
		if(painelBuscarCliente == null) {
			painelBuscarCliente = new PainelBuscarCliente();
		}
		return painelBuscarCliente;
	}
	
	public static ControladorTelaBuscarCliente getControladorTelaBuscarCliente() {
		if (controladorTelaBuscarCliente == null) {
			controladorTelaBuscarCliente = new ControladorTelaBuscarCliente(getFrameBuscarCliente(),
					getPainelBuscarCliente());
		}
		return controladorTelaBuscarCliente;
	}

}
