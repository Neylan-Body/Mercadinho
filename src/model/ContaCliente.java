package model;

public class ContaCliente {

	private int idConta;
	private int codigoCliente;
	private double limiteUltilizado;
	private double limiteTotal;
	private double totalPagar;
	
	public ContaCliente() {
		// TODO Auto-generated constructor stub
	}
	
	public ContaCliente(int idConta, int codigoCliente, double limiteUltilizado, double limiteTotal,
			double totalPagar) {
		super();
		this.idConta = idConta;
		this.codigoCliente = codigoCliente;
		this.limiteUltilizado = limiteUltilizado;
		this.limiteTotal = limiteTotal;
		this.totalPagar = totalPagar;	
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

	public double getLimiteUltilizado() {
		return limiteUltilizado;
	}

	public void setLimiteUltilizado(double limiteUltilizado) {
		this.limiteUltilizado = limiteUltilizado;
	}

	public double getLimiteTotal() {
		return limiteTotal;
	}

	public void setLimiteTotal(double limiteTotal) {
		this.limiteTotal = limiteTotal;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	
}
