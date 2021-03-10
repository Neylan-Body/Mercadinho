package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PainelMenuPrincipal extends JPanel {

	private JMenuBar jMenuBarPrincipal;
	private JMenu jMenuSair;
	private JMenu jMenu;
	private JMenuItem jMenuItemGerenciarProduto;
	private JMenuItem jMenuItemGerenciarFuncionario;
	private JMenuItem jMenuItemGerenciarCliente;
	private JMenuItem jMenuItemGerenciarFornecedor;
	private JMenuItem jMenuItemBuscarCliente;
	private JMenuItem jMenuItemRelatorio;
	private JMenuItem jMenuItemDevolucaoDeProduto;
	private JMenuItem jMenuItemContaDoCliente;
	private JMenuItem jMenuItemControleDeEstoque;
	private JMenu jMenuPDV;
	private JMenuItem itemSair;
	private JMenuItem pdv;


	public PainelMenuPrincipal() {
		setSize(1197, 693);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		add(getMenuPrincipal());

	}

	public JMenuBar getMenuPrincipal() {
		if (jMenuBarPrincipal == null) {
			jMenuBarPrincipal = new JMenuBar();
			jMenuBarPrincipal.setBounds(0, 0, 1187, 21);
			jMenuBarPrincipal.setBackground(Color.LIGHT_GRAY);
			jMenuBarPrincipal.setBorder(new LineBorder(Color.WHITE));
			jMenuBarPrincipal.add(getMenu());
			jMenuBarPrincipal.add(getMenuPDV());
			jMenuBarPrincipal.add(getSair());
		}
		return jMenuBarPrincipal;
	}

	public JMenu getSair() {
		if (jMenuSair == null) {
			jMenuSair = new JMenu("SAIR");
			jMenuSair.setForeground(Color.BLACK);
			jMenuSair.setBackground(new Color(0, 0, 0));
			jMenuSair.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuSair.add(getJMenuItemSair());
		}
		return jMenuSair;
	}

	public JMenu getMenu() {
		if (jMenu == null) {
			jMenu = new JMenu("MENU");
			jMenu.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenu.setForeground(Color.BLACK);
			jMenu.setBackground(new Color(0, 0, 0));
			jMenu.add(getJMenuItemBuscarCliente());
			jMenu.add(getJMenuItemGerenciarCliente());
			jMenu.add(getJMenuItemGerenciarFornecedor());
			jMenu.add(getJMenuItemGerenciarFuncionario());
			jMenu.add(getJMenuItemGerenciarProduto());
			jMenu.add(getJMenuItemContaDoCliente());
			jMenu.add(getJMenuItemControleDeEstoque());
			jMenu.add(getJMenuItemDevolucaoDeProduto());
			jMenu.add(getJMenuItemRelatorio());

		}
		return jMenu;
	}

	public JMenu getMenuPDV() {
		if (jMenuPDV == null) {
			jMenuPDV = new JMenu("PDV");
			jMenuPDV.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuPDV.setForeground(Color.BLACK);
			jMenuPDV.setBackground(new Color(0, 0, 0));
			jMenuPDV.add(getJMenuItemPDV());
		}
		return jMenuPDV;
	}

	public JMenuItem getJMenuItemGerenciarProduto() {
		if (jMenuItemGerenciarProduto == null) {
			jMenuItemGerenciarProduto = new JMenuItem("Gerenciar Produto");
			jMenuItemGerenciarProduto.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemGerenciarProduto.setForeground(Color.BLACK);
			jMenuItemGerenciarProduto.setBorder(new LineBorder(Color.WHITE));
			jMenuItemGerenciarProduto.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemGerenciarProduto;
	}

	public JMenuItem getJMenuItemGerenciarFuncionario() {
		if (jMenuItemGerenciarFuncionario == null) {
			jMenuItemGerenciarFuncionario = new JMenuItem("Gerenciar Funcionário");
			jMenuItemGerenciarFuncionario.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemGerenciarFuncionario.setForeground(Color.BLACK);
			jMenuItemGerenciarFuncionario.setBorder(new LineBorder(Color.WHITE));
			jMenuItemGerenciarFuncionario.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemGerenciarFuncionario;
	}

	public JMenuItem getJMenuItemGerenciarCliente() {
		if (jMenuItemGerenciarCliente == null) {
			jMenuItemGerenciarCliente = new JMenuItem("Gerenciar Cliente");
			jMenuItemGerenciarCliente.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemGerenciarCliente.setForeground(Color.BLACK);
			jMenuItemGerenciarCliente.setBorder(new LineBorder(Color.WHITE));
			jMenuItemGerenciarCliente.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemGerenciarCliente;
	}

	public JMenuItem getJMenuItemGerenciarFornecedor() {
		if (jMenuItemGerenciarFornecedor == null) {
			jMenuItemGerenciarFornecedor = new JMenuItem("Gerenciar Fornecedor");
			jMenuItemGerenciarFornecedor.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemGerenciarFornecedor.setForeground(Color.BLACK);
			jMenuItemGerenciarFornecedor.setBorder(new LineBorder(Color.WHITE));
			jMenuItemGerenciarFornecedor.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemGerenciarFornecedor;
	}

	public JMenuItem getJMenuItemBuscarCliente() {
		if (jMenuItemBuscarCliente == null) {
			jMenuItemBuscarCliente = new JMenuItem("Buscar Cliente");
			jMenuItemBuscarCliente.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemBuscarCliente.setForeground(Color.BLACK);
			jMenuItemBuscarCliente.setBorder(new LineBorder(Color.WHITE));
			jMenuItemBuscarCliente.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemBuscarCliente;
	}

	public JMenuItem getJMenuItemRelatorio() {
		if (jMenuItemRelatorio == null) {
			jMenuItemRelatorio = new JMenuItem("Relatório");
			jMenuItemRelatorio.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemRelatorio.setForeground(Color.BLACK);
			jMenuItemRelatorio.setBorder(new LineBorder(Color.WHITE));
			jMenuItemRelatorio.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemRelatorio;
	}

	public JMenuItem getJMenuItemDevolucaoDeProduto() {
		if (jMenuItemDevolucaoDeProduto == null) {
			jMenuItemDevolucaoDeProduto = new JMenuItem("Devolução de Produto");
			jMenuItemDevolucaoDeProduto.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemDevolucaoDeProduto.setForeground(Color.BLACK);
			jMenuItemDevolucaoDeProduto.setBorder(new LineBorder(Color.WHITE));
			jMenuItemDevolucaoDeProduto.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemDevolucaoDeProduto;
	}

	public JMenuItem getJMenuItemContaDoCliente() {
		if (jMenuItemContaDoCliente == null) {
			jMenuItemContaDoCliente = new JMenuItem("Conta do cliente");
			jMenuItemContaDoCliente.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemContaDoCliente.setForeground(Color.BLACK);
			jMenuItemContaDoCliente.setBorder(new LineBorder(Color.WHITE));
			jMenuItemContaDoCliente.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemContaDoCliente;
	}

	public JMenuItem getJMenuItemControleDeEstoque() {
		if (jMenuItemControleDeEstoque == null) {
			jMenuItemControleDeEstoque = new JMenuItem("Controle de estoque");
			jMenuItemControleDeEstoque.setFont(new Font("Dialog", Font.BOLD, 12));
			jMenuItemControleDeEstoque.setForeground(Color.BLACK);
			jMenuItemControleDeEstoque.setBorder(new LineBorder(Color.WHITE));
			jMenuItemControleDeEstoque.setBackground(Color.LIGHT_GRAY);
		}
		return jMenuItemControleDeEstoque;
	}

	public JMenuItem getJMenuItemSair() {
		if (itemSair == null) {
			itemSair = new JMenuItem("Sair");
			itemSair.setFont(new Font("Dialog", Font.BOLD, 12));
			itemSair.setForeground(Color.BLACK);
			itemSair.setBorder(new LineBorder(Color.WHITE));
			itemSair.setBackground(Color.LIGHT_GRAY);
		}
		return itemSair;
	}

	public JMenuItem getJMenuItemPDV() {
		if (pdv == null) {
			pdv = new JMenuItem("PDV");
			pdv.setFont(new Font("Dialog", Font.BOLD, 12));
			pdv.setForeground(Color.BLACK);
			pdv.setBorder(new LineBorder(Color.WHITE));
			pdv.setBackground(Color.LIGHT_GRAY);
		}
		return pdv;
	}

}
