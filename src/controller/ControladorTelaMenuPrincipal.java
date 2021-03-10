package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrameBuscarCliente;
import view.FrameContaDoCliente;
import view.FrameControleDeEstoque;
import view.FrameDevolucaoDeProdutos;
import view.FrameGerenciarCliente;
import view.FrameGerenciarFornecedor;
import view.FrameGerenciarFuncionario;
import view.FrameGerenciarProduto;
import view.FrameLogin;
import view.FrameMenuPrincipal;
import view.FramePDV;
import view.FrameRelatorio;
import view.PainelBuscarCliente;
import view.PainelContaDoCliente;
import view.PainelControleDeEstoque;
import view.PainelDevolucaoDeProdutos;
import view.PainelGerenciarCliente;
import view.PainelGerenciarFornecedor;
import view.PainelGerenciarFuncionario;
import view.PainelGerenciarProduto;
import view.PainelLogin;
import view.PainelMenuPrincipal;
import view.PainelPDV;
import view.PainelRelatorio;

public class ControladorTelaMenuPrincipal implements ActionListener {

	private static FrameMenuPrincipal frameMenuPrincipal;
	private static FrameBuscarCliente frameBuscarCliente;
	private static FrameGerenciarCliente frameGerenciarCliente;
	private static FrameGerenciarFornecedor frameGerenciarFornecedor;
	private static FrameGerenciarFuncionario frameGerenciarFuncionario;
	private static FrameGerenciarProduto frameGerenciarProduto;
	private static FrameContaDoCliente frameContaDoCliente;
	private static FrameControleDeEstoque frameControleDeEstoque;
	private static FrameDevolucaoDeProdutos frameDevolucaoDeProdutos;
	private static FrameRelatorio frameRelatorio;
	private static FramePDV framePDV;
	private static FrameLogin frameLogin;

	private static PainelMenuPrincipal painelMenuPrincipal;
	private static PainelBuscarCliente painelBuscarCliente;
	private static PainelGerenciarCliente painelGerenciarCliente;
	private static PainelGerenciarFornecedor painelGerenciarFornecedor;
	private static PainelGerenciarFuncionario painelGerenciarFuncionario;
	private static PainelGerenciarProduto painelGerenciarProduto;
	private static PainelContaDoCliente painelContaDoCliente;
	private static PainelControleDeEstoque painelControleDeEstoque;
	private static PainelDevolucaoDeProdutos painelDevolucaoDeProdutos;
	private static PainelRelatorio painelRelatorio;
	private static PainelPDV painelPDV;
	private static PainelLogin painelLogin;

	private static ControladorTelaBuscarCliente controladorTelaBuscarCliente;
	private static ControladorTelaGerenciarCliente controladorTelaGerenciarCliente;
	private static ControladorTelaGerenciarFornecedor controladorTelaGerenciarFornecedor;
	private static ControladorTelaGerenciarFuncionario controladorTelaGerenciarFuncionario;
	private static ControladorTelaGerenciarProduto controladorTelaGerenciarProduto;
	private static ControladorTelaContaDoCliente controladorTelaContaDoCliente;
	private static ControladorTelaControleDeEstoque controladorTelaControleDeEstoque;
	private static ControladorTelaDevolucaoDeProdutos controladorTelaDevolucaoDeProdutos;
	private static ControladorTelaRelatorio controladorTelaRelatorio;
	private static ControladorTelaPDV controladorTelaPDV;
	private static ControladorTelaLogin controladorTelaLogin;

	public ControladorTelaMenuPrincipal(FrameMenuPrincipal frameMenuPrincipal,
			PainelMenuPrincipal painelMenuPrincipal) {
		this.frameMenuPrincipal = frameMenuPrincipal;
		this.painelMenuPrincipal = painelMenuPrincipal;
		addAcao();
	}

	public void addAcao() {
		getPainelMenuPrincipal().getJMenuItemBuscarCliente().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemGerenciarCliente().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemGerenciarFornecedor().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemGerenciarFuncionario().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemGerenciarProduto().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemContaDoCliente().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemControleDeEstoque().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemDevolucaoDeProduto().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemRelatorio().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemPDV().addActionListener(this);
		getPainelMenuPrincipal().getJMenuItemSair().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemBuscarCliente()) {
			frameBuscarCliente = null;
			painelBuscarCliente = null;
			controladorTelaBuscarCliente = null;
			getFrameBuscarCliente().setContentPane(getPainelBuscarCliente());
			getFrameBuscarCliente().repaint();
			getFrameBuscarCliente().validate();
			getControladorTelaBuscarCliente();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemGerenciarCliente()) {
			frameGerenciarCliente = null;
			painelGerenciarCliente = null;
			controladorTelaGerenciarCliente = null;
			getFrameGerenciarCliente().setContentPane(getPainelGerenciarCliente());
			getFrameGerenciarCliente().repaint();
			getFrameGerenciarCliente().validate();
			getControladorTelaGerenciarCliente();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemGerenciarFornecedor()) {
			frameGerenciarFornecedor = null;
			painelGerenciarFornecedor = null;
			controladorTelaGerenciarFornecedor = null;
			getFrameGerenciarFornecedor().setContentPane(getPainelGerenciarFornecedor());
			getFrameGerenciarFornecedor().repaint();
			getFrameGerenciarFornecedor().validate();
			getControladorTelaGerenciarFornecedor();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemGerenciarFuncionario()) {
			frameGerenciarFuncionario = null;
			painelGerenciarFuncionario = null;
			controladorTelaGerenciarFuncionario = null;
			getFrameGerenciarFuncionario().setContentPane(getPainelGerenciarFuncionario());
			getFrameGerenciarFuncionario().repaint();
			getFrameGerenciarFuncionario().validate();
			getControladorTelaGerenciarFuncionario();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemGerenciarProduto()) {
			frameGerenciarProduto = null;
			painelGerenciarProduto = null;
			controladorTelaGerenciarProduto = null;
			getFrameGerenciarProduto().setContentPane(getPainelGerenciarProduto());
			getFrameGerenciarProduto().repaint();
			getFrameGerenciarProduto().validate();
			getControladorTelaGerenciarProduto();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemContaDoCliente()) {
			frameContaDoCliente = null;
			painelContaDoCliente = null;
			controladorTelaContaDoCliente = null;
			getFrameContaDoCliente().setContentPane(getPainelContaDoCliente());
			getFrameContaDoCliente().repaint();
			getFrameContaDoCliente().validate();
			getControladorTelaContaDoCliente();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemControleDeEstoque()) {
			frameControleDeEstoque = null;
			painelControleDeEstoque = null;
			controladorTelaControleDeEstoque = null;
			getFrameControleDeEstoque().setContentPane(getPainelControleDeEstoque());
			getFrameControleDeEstoque().repaint();
			getFrameControleDeEstoque().validate();
			getControladorTelaControleDeEstoque();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemDevolucaoDeProduto()) {
			frameDevolucaoDeProdutos = null;
			painelDevolucaoDeProdutos = null;
			controladorTelaDevolucaoDeProdutos = null;
			getFrameDevolucaoDeProdutos().setContentPane(getPainelDevolucaoDeProdutos());
			getFrameDevolucaoDeProdutos().repaint();
			getFrameDevolucaoDeProdutos().validate();
			getControladorTelaDevolucaoDeProdutos();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemRelatorio()) {
			frameRelatorio = null;
			painelRelatorio = null;
			controladorTelaRelatorio = null;
			getFrameRelatorio().setContentPane(getPainelRelatorio());
			getFrameRelatorio().repaint();
			getFrameRelatorio().validate();
			getControladorTelaRelatorio();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemPDV()) {
			framePDV = null;
			painelPDV = null;
			controladorTelaPDV = null;
			getFramePDV().setContentPane(getPainelPDV());
			getFramePDV().repaint();
			getFramePDV().validate();
			getControladorTelaPDV();
		}
		if (e.getSource() == getPainelMenuPrincipal().getJMenuItemSair()) {
			frameLogin = null;
			painelLogin = null;
			controladorTelaLogin = null;
			getFrameLogin().setContentPane(getPainelLogin());
			getFrameLogin().repaint();
			getFrameLogin().validate();
			getControladorTelaLogin();
			getFrameMenuPrincipal().dispose();
			getFrameMenuPrincipal().repaint();
			getFrameMenuPrincipal().validate();
		}

	}

	public static FrameMenuPrincipal getFrameMenuPrincipal() {
		if (frameMenuPrincipal == null) {
			frameMenuPrincipal = new FrameMenuPrincipal();
		}
		return frameMenuPrincipal;
	}

	private static FrameBuscarCliente getFrameBuscarCliente() {
		if (frameBuscarCliente == null) {
			frameBuscarCliente = new FrameBuscarCliente();
		}
		return frameBuscarCliente;
	}

	private static FrameGerenciarCliente getFrameGerenciarCliente() {
		if (frameGerenciarCliente == null) {
			frameGerenciarCliente = new FrameGerenciarCliente();
		}
		return frameGerenciarCliente;
	}

	private static FrameGerenciarFornecedor getFrameGerenciarFornecedor() {
		if (frameGerenciarFornecedor == null) {
			frameGerenciarFornecedor = new FrameGerenciarFornecedor();
		}
		return frameGerenciarFornecedor;
	}

	private static FrameGerenciarFuncionario getFrameGerenciarFuncionario() {
		if (frameGerenciarFuncionario == null) {
			frameGerenciarFuncionario = new FrameGerenciarFuncionario();
		}
		return frameGerenciarFuncionario;
	}

	private static FrameGerenciarProduto getFrameGerenciarProduto() {
		if (frameGerenciarProduto == null) {
			frameGerenciarProduto = new FrameGerenciarProduto();
		}
		return frameGerenciarProduto;
	}

	private static FrameContaDoCliente getFrameContaDoCliente() {
		if (frameContaDoCliente == null) {
			frameContaDoCliente = new FrameContaDoCliente();
		}
		return frameContaDoCliente;
	}

	private static FrameControleDeEstoque getFrameControleDeEstoque() {
		if (frameControleDeEstoque == null) {
			frameControleDeEstoque = new FrameControleDeEstoque();
		}
		return frameControleDeEstoque;
	}

	private static FrameDevolucaoDeProdutos getFrameDevolucaoDeProdutos() {
		if (frameDevolucaoDeProdutos == null) {
			frameDevolucaoDeProdutos = new FrameDevolucaoDeProdutos();
		}
		return frameDevolucaoDeProdutos;
	}

	private static FrameRelatorio getFrameRelatorio() {
		if (frameRelatorio == null) {
			frameRelatorio = new FrameRelatorio();
		}
		return frameRelatorio;
	}

	public static PainelMenuPrincipal getPainelMenuPrincipal() {
		if (painelMenuPrincipal == null) {
			painelMenuPrincipal = new PainelMenuPrincipal();
		}
		return painelMenuPrincipal;
	}

	private static PainelBuscarCliente getPainelBuscarCliente() {
		if (painelBuscarCliente == null) {
			painelBuscarCliente = new PainelBuscarCliente();
		}
		return painelBuscarCliente;
	}

	private static PainelGerenciarCliente getPainelGerenciarCliente() {
		if (painelGerenciarCliente == null) {
			painelGerenciarCliente = new PainelGerenciarCliente();
		}
		return painelGerenciarCliente;
	}

	private static PainelGerenciarFornecedor getPainelGerenciarFornecedor() {
		if (painelGerenciarFornecedor == null) {
			painelGerenciarFornecedor = new PainelGerenciarFornecedor();
		}
		return painelGerenciarFornecedor;
	}

	private static PainelGerenciarFuncionario getPainelGerenciarFuncionario() {
		if (painelGerenciarFuncionario == null) {
			painelGerenciarFuncionario = new PainelGerenciarFuncionario();
		}
		return painelGerenciarFuncionario;
	}

	private static PainelGerenciarProduto getPainelGerenciarProduto() {
		if (painelGerenciarProduto == null) {
			painelGerenciarProduto = new PainelGerenciarProduto();
		}
		return painelGerenciarProduto;
	}

	private static PainelContaDoCliente getPainelContaDoCliente() {
		if (painelContaDoCliente == null) {
			painelContaDoCliente = new PainelContaDoCliente();
		}
		return painelContaDoCliente;
	}

	private static PainelControleDeEstoque getPainelControleDeEstoque() {
		if (painelControleDeEstoque == null) {
			painelControleDeEstoque = new PainelControleDeEstoque();
		}
		return painelControleDeEstoque;
	}

	private static PainelDevolucaoDeProdutos getPainelDevolucaoDeProdutos() {
		if (painelDevolucaoDeProdutos == null) {
			painelDevolucaoDeProdutos = new PainelDevolucaoDeProdutos();
		}
		return painelDevolucaoDeProdutos;
	}

	private static PainelRelatorio getPainelRelatorio() {
		if (painelRelatorio == null) {
			painelRelatorio = new PainelRelatorio();
		}
		return painelRelatorio;
	}

	public static ControladorTelaBuscarCliente getControladorTelaBuscarCliente() {
		if (controladorTelaBuscarCliente == null) {
			controladorTelaBuscarCliente = new ControladorTelaBuscarCliente(getFrameBuscarCliente(),
					getPainelBuscarCliente());
		}
		return controladorTelaBuscarCliente;
	}

	public static ControladorTelaGerenciarCliente getControladorTelaGerenciarCliente() {
		if (controladorTelaGerenciarCliente == null) {
			controladorTelaGerenciarCliente = new ControladorTelaGerenciarCliente(getFrameGerenciarCliente(),
					getPainelGerenciarCliente());
			;
		}
		return controladorTelaGerenciarCliente;
	}

	public static ControladorTelaGerenciarFornecedor getControladorTelaGerenciarFornecedor() {
		if (controladorTelaGerenciarFornecedor == null) {
			controladorTelaGerenciarFornecedor = new ControladorTelaGerenciarFornecedor(getFrameGerenciarFornecedor(),
					getPainelGerenciarFornecedor());
		}
		return controladorTelaGerenciarFornecedor;
	}

	public static ControladorTelaGerenciarFuncionario getControladorTelaGerenciarFuncionario() {
		if (controladorTelaGerenciarFuncionario == null) {
			controladorTelaGerenciarFuncionario = new ControladorTelaGerenciarFuncionario(
					getFrameGerenciarFuncionario(), getPainelGerenciarFuncionario());
		}
		return controladorTelaGerenciarFuncionario;
	}

	public static ControladorTelaGerenciarProduto getControladorTelaGerenciarProduto() {
		if (controladorTelaGerenciarProduto == null) {
			controladorTelaGerenciarProduto = new ControladorTelaGerenciarProduto(getFrameGerenciarProduto(),
					getPainelGerenciarProduto());
		}
		return controladorTelaGerenciarProduto;
	}

	public static ControladorTelaContaDoCliente getControladorTelaContaDoCliente() {
		if (controladorTelaContaDoCliente == null) {
			controladorTelaContaDoCliente = new ControladorTelaContaDoCliente(getFrameContaDoCliente(),
					getPainelContaDoCliente());
		}
		return controladorTelaContaDoCliente;
	}

	public static ControladorTelaControleDeEstoque getControladorTelaControleDeEstoque() {
		if (controladorTelaControleDeEstoque == null) {
			controladorTelaControleDeEstoque = new ControladorTelaControleDeEstoque(getFrameControleDeEstoque(),
					getPainelControleDeEstoque());
		}
		return controladorTelaControleDeEstoque;
	}

	public static ControladorTelaDevolucaoDeProdutos getControladorTelaDevolucaoDeProdutos() {
		if (controladorTelaDevolucaoDeProdutos == null) {
			controladorTelaDevolucaoDeProdutos = new ControladorTelaDevolucaoDeProdutos(getFrameDevolucaoDeProdutos(),
					getPainelDevolucaoDeProdutos());
		}
		return controladorTelaDevolucaoDeProdutos;
	}

	public static ControladorTelaRelatorio getControladorTelaRelatorio() {
		if (controladorTelaRelatorio == null) {
			controladorTelaRelatorio = new ControladorTelaRelatorio(getFrameRelatorio(), getPainelRelatorio());
		}
		return controladorTelaRelatorio;
	}

	public static FramePDV getFramePDV() {
		if (framePDV == null) {
			framePDV = new FramePDV();
		}
		return framePDV;
	}

	public static PainelPDV getPainelPDV() {
		if (painelPDV == null) {
			painelPDV = new PainelPDV();
		}
		return painelPDV;
	}

	public static ControladorTelaPDV getControladorTelaPDV() {
		if (controladorTelaPDV == null) {
			controladorTelaPDV = new ControladorTelaPDV(getFramePDV(), getPainelPDV());
		}
		return controladorTelaPDV;
	}

	public static FrameLogin getFrameLogin() {
		if (frameLogin == null) {
			frameLogin = new FrameLogin();
		}
		return frameLogin;
	}

	public static PainelLogin getPainelLogin() {
		if (painelLogin == null) {
			painelLogin = new PainelLogin();
		}
		return painelLogin;
	}

	public static ControladorTelaLogin getControladorTelaLogin() {
		if (controladorTelaLogin == null) {
			controladorTelaLogin = new ControladorTelaLogin(getFrameLogin(), getPainelLogin());
		}
		return controladorTelaLogin;
	}
}
