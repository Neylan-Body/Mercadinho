package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarFornecedor;
import view.FrameBuscarProduto;
import view.FrameControleDeEstoque;
import view.PainelBuscarFornecedor;
import view.PainelBuscarProduto;
import view.PainelControleDeEstoque;

public class ControladorTelaControleDeEstoque implements ActionListener {

	private static FrameControleDeEstoque frameControleDeEstoque;
	private static FrameBuscarFornecedor frameBuscarFornecedor;
	private static FrameBuscarProduto frameBuscarProduto;

	private static PainelControleDeEstoque painelControleDeEstoque;
	private static PainelBuscarFornecedor painelBuscarFornecedor;
	private static PainelBuscarProduto painelBuscarProduto;

	private static ControladorTelaBuscarProduto controladorTelaBuscarProduto;
	private static ControladorTelaBuscarFornecedor controladorTelaBuscarFornecedor;

	public ControladorTelaControleDeEstoque(FrameControleDeEstoque frameControleDeEstoque,
			PainelControleDeEstoque painelControleDeEstoque) {
		this.frameControleDeEstoque = frameControleDeEstoque;
		this.painelControleDeEstoque = painelControleDeEstoque;
		Eventos();
	}

	private void Eventos() {
		// TODO Auto-generated method stub
		getPainelControleDeEstoque().getJButtonPesquisarProduto().addActionListener(this);
		getPainelControleDeEstoque().getJButtonPesquisarFornecedor().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getPainelControleDeEstoque().getJButtonPesquisarProduto()) {
			frameBuscarProduto = null;
			painelBuscarProduto = null;
			getFrameBuscarProduto().setContentPane(getPainelBuscarProduto());
			getFrameBuscarProduto().repaint();
			getFrameBuscarProduto().validate();
			getControladorTelaBuscarProduto();
		}
		if (e.getSource() == getPainelControleDeEstoque().getJButtonPesquisarFornecedor()) {
			frameBuscarFornecedor = null;
			painelBuscarFornecedor = null;
			getFrameBuscarFornecedor().setContentPane(getPainelBuscarFornecedor());
			getFrameBuscarFornecedor().repaint();
			getFrameBuscarFornecedor().validate();
			getControladorTelaBuscarFornecedor();
		}
	}

	public static FrameControleDeEstoque getFrameControleDeEstoque() {
		if (frameControleDeEstoque == null) {
			frameControleDeEstoque = new FrameControleDeEstoque();
		}
		return frameControleDeEstoque;
	}

	public static PainelControleDeEstoque getPainelControleDeEstoque() {
		if (painelControleDeEstoque == null) {
			painelControleDeEstoque = new PainelControleDeEstoque();
		}
		return painelControleDeEstoque;
	}

	public static FrameBuscarFornecedor getFrameBuscarFornecedor() {
		if (frameBuscarFornecedor == null) {
			frameBuscarFornecedor = new FrameBuscarFornecedor();
		}
		return frameBuscarFornecedor;
	}

	public static FrameBuscarProduto getFrameBuscarProduto() {
		if (frameBuscarProduto == null) {
			frameBuscarProduto = new FrameBuscarProduto();
		}
		return frameBuscarProduto;
	}

	public static PainelBuscarFornecedor getPainelBuscarFornecedor() {
		if (painelBuscarFornecedor == null) {
			painelBuscarFornecedor = new PainelBuscarFornecedor();
		}
		return painelBuscarFornecedor;
	}

	public static PainelBuscarProduto getPainelBuscarProduto() {
		if (painelBuscarProduto == null) {
			painelBuscarProduto = new PainelBuscarProduto();
		}
		return painelBuscarProduto;
	}

	public static ControladorTelaBuscarProduto getControladorTelaBuscarProduto() {
		if (controladorTelaBuscarProduto == null) {
			controladorTelaBuscarProduto = new ControladorTelaBuscarProduto(getFrameBuscarProduto(),
					getPainelBuscarProduto());
		}
		return controladorTelaBuscarProduto;
	}

	public static ControladorTelaBuscarFornecedor getControladorTelaBuscarFornecedor() {
		if (controladorTelaBuscarFornecedor == null) {
			controladorTelaBuscarFornecedor = new ControladorTelaBuscarFornecedor(getFrameBuscarFornecedor(),
					getPainelBuscarFornecedor());
		}
		return controladorTelaBuscarFornecedor;
	}
}
