package model;

import java.sql.Date;

public class EntregaDeProduto {

	private int idEndereco;
	private Date data;
	private int codigoCliente;
	private int codigoProduto;
	private int idCompra;

	public EntregaDeProduto() {
		// TODO Auto-generated constructor stub
	}

	public EntregaDeProduto(int idEndereco, Date data, int codigoCliente, int codigoProduto, int idCompra) {
		super();
		this.idEndereco = idEndereco;
		this.data = data;
		this.codigoCliente = codigoCliente;
		this.codigoProduto = codigoProduto;
		this.idCompra = idCompra;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

}
