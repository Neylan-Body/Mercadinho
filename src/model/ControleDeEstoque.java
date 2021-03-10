package model;

import java.sql.Date;

public class ControleDeEstoque {

	private int codigoFornecedor;
	private String endereco;
	private String natureza;
	private Date data;
	private String hora;
	private int codigoProduto;
	private int quantidade;
	private int unidade;
	private double valorCusto;

	public ControleDeEstoque() {
		// TODO Auto-generated constructor stub
	}

	public ControleDeEstoque(int codigoFornecedor, String endereco, String natureza, Date data, String hora,
			int codigoProduto, int quantidade, int unidade, double valorCusto) {
		super();
		this.codigoFornecedor = codigoFornecedor;
		this.endereco = endereco;
		this.natureza = natureza;
		this.data = data;
		this.hora = hora;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.valorCusto = valorCusto;
	}

	public int getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(int codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
}
