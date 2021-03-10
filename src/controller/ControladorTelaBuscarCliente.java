package controller;

import view.FrameBuscarCliente;
import view.PainelBuscarCliente;

public class ControladorTelaBuscarCliente {

	private static FrameBuscarCliente frameBuscarCliente;
	private static PainelBuscarCliente painelBuscarCliente;

	public ControladorTelaBuscarCliente(FrameBuscarCliente frameBuscarCliente,
			PainelBuscarCliente painelBuscarCliente) {
		this.frameBuscarCliente = frameBuscarCliente;
		this.painelBuscarCliente = painelBuscarCliente;
	}

	public static FrameBuscarCliente getFrameBuscarCliente() {
		if (frameBuscarCliente == null) {
			frameBuscarCliente = new FrameBuscarCliente();
		}
		return frameBuscarCliente;
	}

	public static PainelBuscarCliente getPainelBuscarCliente() {
		if (painelBuscarCliente == null) {
			painelBuscarCliente = new PainelBuscarCliente();
		}
		return painelBuscarCliente;
	}
}
