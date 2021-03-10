package model;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import view.PainelGerenciarProduto;

public class ValidarTelaProduto {

	private static PainelGerenciarProduto painelGerenciarProduto;

	public ValidarTelaProduto(PainelGerenciarProduto painelGerenciarProduto) {

		this.painelGerenciarProduto = painelGerenciarProduto;

	}

	public boolean TesteDescricao() {
		if (getPainelGerenciarProduto().getJTextFieldDescricao().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Descricão incorreta");
			getPainelGerenciarProduto().getJTextFieldDescricao().grabFocus();
			getPainelGerenciarProduto().getJTextFieldDescricao().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarProduto().getJTextFieldDescricao().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteCodigoBarra() {
		try {
			if (getPainelGerenciarProduto().getJTextFieldCodigoBarra().getText().length() <= 8
					&& getPainelGerenciarProduto().getJTextFieldCodigoBarra().getText().length() > 0) {
				int codigoBarra = Integer.parseInt(getPainelGerenciarProduto().getJTextFieldCodigoBarra().getText());
				getPainelGerenciarProduto().getJTextFieldCodigoBarra().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
				return true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Codigo de barra incorreto");
			getPainelGerenciarProduto().getJTextFieldCodigoBarra().grabFocus();
			getPainelGerenciarProduto().getJTextFieldCodigoBarra().setBorder(new LineBorder(Color.RED));
			return false;
		}
		JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Codigo de barra incorreto");
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().grabFocus();
		getPainelGerenciarProduto().getJTextFieldCodigoBarra().setBorder(new LineBorder(Color.RED));
		return false;
	}

	// campo código de barra, a mascara.

	public boolean TesteEstoqueMinimo() {
		try {

			int estoqueMinimo = Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().getText());
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Estoque minimo incorreto");
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().grabFocus();
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteEstoqueMaximo() {
		try {

			int estoqueMaximo = Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().getText());
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Estoque maximo incorreto");
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().grabFocus();
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean EstoqueMaximoMenorEstoqueMinimo() {

		int estoqueMinimo = Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().getText());
		int estoqueMaximo = Integer.parseInt(getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().getText());
		if (estoqueMinimo > estoqueMaximo) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Estoque minimo maior que estoque maximo");
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().grabFocus();
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().grabFocus();
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarProduto().getJTextFieldEstoqueMinimo().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			getPainelGerenciarProduto().getJTextFieldEstoqueMaximo().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteValorCusto() {
		try {
			double valorcusto = Double
					.parseDouble(getPainelGerenciarProduto().getJTextFieldValorCusto().getText().replace(",", "."));
			getPainelGerenciarProduto().getJTextFieldValorCusto().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Valor custo incorreto");
			getPainelGerenciarProduto().getJTextFieldValorCusto().grabFocus();
			getPainelGerenciarProduto().getJTextFieldValorCusto().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteLucro() {
		try {
			double lucro = Double
					.parseDouble(getPainelGerenciarProduto().getJTextFieldLucro().getText().replace(",", "."));
			getPainelGerenciarProduto().getJTextFieldLucro().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Lucro incorreto");
			getPainelGerenciarProduto().getJTextFieldLucro().grabFocus();
			getPainelGerenciarProduto().getJTextFieldLucro().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteValorVenda() {
		try {

			double valorvenda = Double
					.parseDouble(getPainelGerenciarProduto().getJTextFieldValorVenda().getText().replace(",", "."));
			getPainelGerenciarProduto().getJTextFieldValorVenda().setBorder(getPainelGerenciarProduto().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Valor da venda incorreto");
			getPainelGerenciarProduto().getJTextFieldValorVenda().grabFocus();
			getPainelGerenciarProduto().getJTextFieldValorVenda().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteUnidade() {
		if (getPainelGerenciarProduto().getJComboBoxUnidade().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Selecione uma unidade");
			getPainelGerenciarProduto().getJComboBoxUnidade().grabFocus();
			getPainelGerenciarProduto().getJComboBoxUnidade().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarProduto().getJComboBoxUnidade().setBorder(getPainelGerenciarProduto().getJComboBoxPesquisa().getBorder());
			return true;
		}

	}

	public boolean TesteTipo() {
		if (getPainelGerenciarProduto().getJComboBoxTipo().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarProduto(), "Selecione um tipo");
			getPainelGerenciarProduto().getJComboBoxTipo().grabFocus();
			getPainelGerenciarProduto().getJComboBoxTipo().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarProduto().getJComboBoxTipo().setBorder(getPainelGerenciarProduto().getJComboBoxPesquisa().getBorder());
			return true;
		}

	}

	public static PainelGerenciarProduto getPainelGerenciarProduto() {
		if (painelGerenciarProduto == null) {
			painelGerenciarProduto = new PainelGerenciarProduto();
		}
		return painelGerenciarProduto;
	}
}
