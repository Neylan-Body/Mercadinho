package model;

import java.sql.Date;

public class HistoricoContaCliente {

	private int idHistorico;
	private int idCompra;
	private int idConta;
	private int codigoCliente;
	private int valorPago;
	private Date dataPagamento;

	public HistoricoContaCliente() {
		// TODO Auto-generated constructor stub
	}

	public HistoricoContaCliente(int idHistorico, int idCompra, int idConta, int codigoCliente, int valorPago,
			Date dataPagamento) {
		super();
		this.idHistorico = idHistorico;
		this.idCompra = idCompra;
		this.idConta = idConta;
		this.codigoCliente = codigoCliente;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
	}

	public int getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getValorPago() {
		return valorPago;
	}

	public void setValorPago(int valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}