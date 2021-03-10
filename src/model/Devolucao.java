package model;

public class Devolucao {

	private int codigoCompra;
	private int codigoProduto;
	private String unidade;
	private int quantidadeTotal;
	private int quantidadeDevolvida;

	public Devolucao() {
		// TODO Auto-generated constructor stub
	}

	public Devolucao(int codigoCompra, int codigoProduto, String unidade, int quantidadeTotal,
			int quantidadeDevolvida) {
		super();
		this.codigoCompra = codigoCompra;
		this.codigoProduto = codigoProduto;
		this.unidade = unidade;
		this.quantidadeTotal = quantidadeTotal;
		this.quantidadeDevolvida = quantidadeDevolvida;
	}

	public int getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(int quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public int getQuantidadeDevolvida() {
		return quantidadeDevolvida;
	}

	public void setQuantidadeDevolvida(int quantidadeDevolvida) {
		this.quantidadeDevolvida = quantidadeDevolvida;
	}
	
	
}
