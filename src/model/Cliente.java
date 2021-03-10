package model;

import java.sql.Date;

public class Cliente extends Endereco {
	private int codigo;
	private Date cadastradoEm;
	private String email;
	private String telefone;
	private String celular;
	private double credito;
	private String situacao;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String municipio, String uf, int codigo, Date cadastradoEm, String email, String telefone, String celular,
			double credito, String situacao) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf);
		this.codigo = codigo;
		this.cadastradoEm = cadastradoEm;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.credito = credito;
		this.situacao = situacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getCadastradoEm() {
		return cadastradoEm;
	}

	public void setCadastradoEm(Date cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
