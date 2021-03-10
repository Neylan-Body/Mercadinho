package model;

public class Compra {

	private int idCompra;
	private int codigoCliente;
	private int dataCompra;
	private int valorTotal;
	private int valorPago;

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(int idCompra, int codigoCliente, int dataCompra, int valorTotal, int valorPago) {
		super();
		this.idCompra = idCompra;
		this.codigoCliente = codigoCliente;
		this.dataCompra = dataCompra;
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(int dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getValorPago() {
		return valorPago;
	}

	public void setValorPago(int valorPago) {
		this.valorPago = valorPago;
	}

}
