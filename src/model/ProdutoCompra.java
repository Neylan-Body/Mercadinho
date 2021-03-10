package model;

public class ProdutoCompra {
	
	private int idCompra;
	private int codigoProduto;
	private int quantidade;
	private int codigoCliente;
	
	public ProdutoCompra() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoCompra(int idCompra, int codigoProduto, int quantidade, int codigoCliente) {
		super();
		this.idCompra = idCompra;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.setCodigoCliente(codigoCliente);
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	

}
