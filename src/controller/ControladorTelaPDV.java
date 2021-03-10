package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import dao.ProdutoDAO;
import view.FrameBuscarProduto;
import view.FrameCodigo;
import view.FrameConfirmarPagamento;
import view.FrameLoginExcluirProduto;
import view.FramePDV;
import view.FrameQuantidade;
import view.PainelBuscarProduto;
import view.PainelCodigo;
import view.PainelConfirmarPagamento;
import view.PainelLoginExcluirProduto;
import view.PainelPDV;
import view.PainelQuantidade;

public class ControladorTelaPDV implements ActionListener, KeyListener, FocusListener {

	private static FramePDV framePDV;
	private static FrameQuantidade frameQuantidade;
	private static FrameCodigo frameCodigo;
	private static FrameConfirmarPagamento frameConfirmarPagamento;
	private static FrameLoginExcluirProduto frameLoginExcluirProduto;
	private static FrameBuscarProduto frameBuscarProduto;

	private static PainelQuantidade painelQuantidade;
	private static PainelCodigo painelCodigo;
	private static PainelPDV painelPDV;
	private static PainelConfirmarPagamento painelConfirmarPagamento;
	private static PainelLoginExcluirProduto painelLoginExcluirProduto;
	private static PainelBuscarProduto painelBuscarProduto;

	private static ControladorTelaBuscarProduto controladorTelaBuscarProduto;
	private static ControladorTelaLoginExcluirProduto controladorLoginExcluirProduto;
	private static ControladorTelaConfirmarPagamento controladorTelaConfirmarPagamento;
	private int telinha = 0;

	public ControladorTelaPDV(FramePDV framePDV, PainelPDV painelPDV) {
		this.framePDV = framePDV;
		this.painelPDV = painelPDV;
		Eventos();
	}

	private void Eventos() {
		getFramePDV().addKeyListener(this);
		getFramePDV().setFocusable(true);
		getPainelPDV().addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getPainelQuantidade().getJButtonCancelar()) {
			getFrameQuantidade().dispose();
			getFrameQuantidade().repaint();
			getFrameQuantidade().validate();
		}
		if (e.getSource() == getPainelQuantidade().getJButtonConfirmar()) {
			if (!getPainelQuantidade().getJTextFieldQuantidade().getText().equals("")) {
				try {
					int quantidade = Integer.parseInt(getPainelQuantidade().getJTextFieldQuantidade().getText());
					getPainelPDV().getJTextFieldQuantidade().setText(Integer.toString(quantidade));
					getFrameQuantidade().dispose();
					getFrameQuantidade().repaint();
					getFrameQuantidade().validate();
					if (!getPainelPDV().getJTextFieldCodigo().getText().equals("")) {
						getPainelPDV().getJTextFieldValorTotal()
								.setText(Double.toString(Double.parseDouble(
										getPainelPDV().getJTextFieldValorUnitario().getText().replace(",", "."))
										* quantidade).replace(".", ","));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getFrameQuantidade(), "Valor incorreto");
				}
			}
			telinha = 0;
		}
		if (e.getSource() == getPainelCodigo().getJButtonCancelar()) {
			getFrameCodigo().dispose();
			getFrameCodigo().repaint();
			getFrameCodigo().validate();
		}
		if (e.getSource() == getPainelCodigo().getJButtonConfirmar()) {
			if (!getPainelCodigo().getJTextFieldCodigo().getText().equals("")) {
				try {
					int codigo = Integer.parseInt(getPainelCodigo().getJTextFieldCodigo().getText());
					ProdutoDAO produtoDAO = new ProdutoDAO();
					if (!produtoDAO.ProdutoPorCodigo(codigo).getDescricao().equals("")) {
						getPainelPDV().getJTextFieldCodigo().setText(Integer.toString(codigo));
						getPainelPDV().getJTextFieldValorUnitario().setText(
								Double.toString(produtoDAO.ProdutoPorCodigo(codigo).getValorVenda()).replace(".", ","));
						getFrameCodigo().dispose();
						getFrameCodigo().repaint();
						getFrameCodigo().validate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getFrameCodigo(), "Valor incorreto");
				}
			}
			telinha = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!getPainelPDV().getJTextFieldCodigo().getText().equals("")
					&& !getPainelPDV().getJTextFieldQuantidade().getText().equals("")
					&& !getPainelPDV().getJTextFieldValorTotal().getText().equals("")
					&& !getPainelPDV().getJTextFieldValorUnitario().getText().equals("")) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				int codigo = Integer.parseInt(getPainelPDV().getJTextFieldCodigo().getText());
				int quantidade = Integer.parseInt(getPainelPDV().getJTextFieldQuantidade().getText());
				getPainelPDV().getDefaultTableModelPDV()
						.addRow(new Object[] { codigo, produtoDAO.ProdutoPorCodigo(codigo).getDescricao(), quantidade,
								getPainelPDV().getJTextFieldValorUnitario().getText(),
								getPainelPDV().getJTextFieldValorTotal().getText() });
				if (getPainelPDV().getJTextFieldSubtotal().getText().equals("")) {
					getPainelPDV().getJTextFieldSubtotal().setText(getPainelPDV().getJTextFieldValorTotal().getText());
				}
				else if (!getPainelPDV().getJTextFieldSubtotal().getText().equals("")) {
					getPainelPDV().getJTextFieldSubtotal().setText(Double.toString(Double
							.parseDouble(getPainelPDV().getJTextFieldValorTotal().getText().replace(",", "."))
							+ Double.parseDouble(getPainelPDV().getJTextFieldSubtotal().getText().replace(",", "."))));
				}
				LimparCampos();
			}
			if (telinha == 1) {
				if (!getPainelCodigo().getJTextFieldCodigo().getText().equals("")) {
					try {
						int codigo = Integer.parseInt(getPainelCodigo().getJTextFieldCodigo().getText());
						ProdutoDAO produtoDAO = new ProdutoDAO();
						if (!produtoDAO.ProdutoPorCodigo(codigo).getDescricao().equals("")) {
							getPainelPDV().getJTextFieldCodigo().setText(Integer.toString(codigo));
							getPainelPDV().getJTextFieldValorUnitario().setText(Double
									.toString(produtoDAO.ProdutoPorCodigo(codigo).getValorVenda()).replace(".", ","));
							getFrameCodigo().dispose();
							getFrameCodigo().repaint();
							getFrameCodigo().validate();
							if (!getPainelPDV().getJTextFieldQuantidade().getText().equals("")) {
								getPainelPDV().getJTextFieldValorTotal()
										.setText(Double.toString(Double.parseDouble(
												getPainelPDV().getJTextFieldValorUnitario().getText().replace(",", "."))
												* Double.parseDouble(getPainelPDV().getJTextFieldQuantidade().getText())).replace(".", ","));
							}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getFrameCodigo(), "Valor incorreto");
					}
				}
				telinha = 0;
			}
			if (telinha == 2) {
				if (!getPainelQuantidade().getJTextFieldQuantidade().getText().equals("")) {
					try {
						int quantidade = Integer.parseInt(getPainelQuantidade().getJTextFieldQuantidade().getText());
						getPainelPDV().getJTextFieldQuantidade().setText(Integer.toString(quantidade));
						getFrameQuantidade().dispose();
						getFrameQuantidade().repaint();
						getFrameQuantidade().validate();
						if (!getPainelPDV().getJTextFieldCodigo().getText().equals("")) {
							getPainelPDV().getJTextFieldValorTotal()
									.setText(Double.toString(Double.parseDouble(
											getPainelPDV().getJTextFieldValorUnitario().getText().replace(",", "."))
											* quantidade).replace(".", ","));
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getFrameQuantidade(), "Valor incorreto");
					}
				}
				telinha = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_F1) {
			frameCodigo = null;
			painelCodigo = null;
			getFrameCodigo().setContentPane(getPainelCodigo());
			getPainelCodigo().getJTextFieldCodigo().addKeyListener(this);
			getPainelCodigo().getJTextFieldCodigo().grabFocus();
			getPainelCodigo().getJButtonCancelar().addActionListener(this);
			getPainelCodigo().getJButtonConfirmar().addActionListener(this);
			getFrameCodigo().repaint();
			getFrameCodigo().validate();
			telinha = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_F2) {
			frameQuantidade = null;
			painelQuantidade = null;
			getFrameQuantidade().setContentPane(getPainelQuantidade());
			getPainelQuantidade().getJTextFieldQuantidade().addKeyListener(this);
			getPainelQuantidade().getJTextFieldQuantidade().grabFocus();
			getPainelQuantidade().getJButtonCancelar().addActionListener(this);
			getPainelQuantidade().getJButtonConfirmar().addActionListener(this);
			getFrameQuantidade().repaint();
			getFrameQuantidade().validate();
			telinha = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_F3) {
			frameBuscarProduto = null;
			painelBuscarProduto = null;
			getFrameBuscarProduto().setContentPane(getPainelBuscarProduto());
			getFrameBuscarProduto().repaint();
			getFrameBuscarProduto().validate();
			getControladorTelaBuscarProduto();
		}
		if (e.getKeyCode() == KeyEvent.VK_F4) {
			frameConfirmarPagamento = null;
			painelConfirmarPagamento = null;
			getFrameConfirmarPagamento().setContentPane(getPainelConfirmarPagamento());
			getFrameConfirmarPagamento().repaint();
			getFrameConfirmarPagamento().validate();
			getControladorTelaConfirmarPagamento();
		}
		if (e.getKeyCode() == KeyEvent.VK_F5) {
			frameLoginExcluirProduto = null;
			painelLoginExcluirProduto = null;
			controladorLoginExcluirProduto = null;
			getFrameLoginExcluirProduto().setContentPane(getPainelLoginExcluirProduto());
			getFrameLoginExcluirProduto().repaint();
			getFrameLoginExcluirProduto().validate();
			getControladorTelaLoginExcluirProduto();
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			getFramePDV().dispose();
			getFramePDV().repaint();
			getFramePDV().validate();
		}

	}

	private void LimparCampos() {
		// TODO Auto-generated method stub
		getPainelPDV().getJTextFieldCodigo().setText("");
		getPainelPDV().getJTextFieldQuantidade().setText("");
		getPainelPDV().getJTextFieldValorTotal().setText("");
		getPainelPDV().getJTextFieldValorUnitario().setText("");
	}

	@Override
	public void keyReleased(KeyEvent e) {

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

	public static FrameQuantidade getFrameQuantidade() {
		if (frameQuantidade == null) {
			frameQuantidade = new FrameQuantidade();
		}
		return frameQuantidade;
	}

	public static PainelQuantidade getPainelQuantidade() {
		if (painelQuantidade == null) {
			painelQuantidade = new PainelQuantidade();
		}
		return painelQuantidade;
	}

	public static FrameCodigo getFrameCodigo() {
		if (frameCodigo == null) {
			frameCodigo = new FrameCodigo();
		}
		return frameCodigo;
	}

	public static PainelCodigo getPainelCodigo() {
		if (painelCodigo == null) {
			painelCodigo = new PainelCodigo();
		}
		return painelCodigo;
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

	public static FrameLoginExcluirProduto getFrameLoginExcluirProduto() {
		if (frameLoginExcluirProduto == null) {
			frameLoginExcluirProduto = new FrameLoginExcluirProduto();
		}
		return frameLoginExcluirProduto;
	}

	public static FrameBuscarProduto getFrameBuscarProduto() {
		if (frameBuscarProduto == null) {
			frameBuscarProduto = new FrameBuscarProduto();
		}
		return frameBuscarProduto;
	}

	public static PainelLoginExcluirProduto getPainelLoginExcluirProduto() {
		if (painelLoginExcluirProduto == null) {
			painelLoginExcluirProduto = new PainelLoginExcluirProduto();
		}
		return painelLoginExcluirProduto;
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

	public static ControladorTelaLoginExcluirProduto getControladorTelaLoginExcluirProduto() {
		if (controladorLoginExcluirProduto == null) {
			controladorLoginExcluirProduto = new ControladorTelaLoginExcluirProduto(getFrameLoginExcluirProduto(),
					getPainelLoginExcluirProduto());
		}
		return controladorLoginExcluirProduto;
	}

	public static ControladorTelaConfirmarPagamento getControladorTelaConfirmarPagamento() {
		if (controladorTelaConfirmarPagamento == null) {
			controladorTelaConfirmarPagamento = new ControladorTelaConfirmarPagamento(getFrameConfirmarPagamento(),
					getPainelConfirmarPagamento());
		}
		return controladorTelaConfirmarPagamento;
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
}
