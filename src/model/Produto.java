package model;

public class Produto {
	private int codigo;
	private String descricao;
	private int codigoBarra;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private double valorCusto;
	private double lucro;
	private double valorVenda;
	private int idUnidade;
	private int idTipo;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Produto(int codigo, String descricao, int codigoBarra, int estoqueMinimo, int estoqueMaximo,
			double valorCusto, double lucro, double valorVenda, int idUnidade, int idTipo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoBarra = codigoBarra;
		this.estoqueMinimo = estoqueMinimo;
		this.estoqueMaximo = estoqueMaximo;
		this.valorCusto = valorCusto;
		this.lucro = lucro;
		this.valorVenda = valorVenda;
		this.idUnidade = idUnidade;
		this.idTipo = idTipo;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public double getLucro() {
		return lucro;
	}

	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
