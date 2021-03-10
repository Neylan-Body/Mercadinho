package model;

import java.sql.Date;

public class Fornecedor extends Endereco{
	
	private int codigo;
	private int idEndereco;
	private Date cadastradoEm;
	private String email;
	private String telefone;
	private String celular;
	private String situacao;
	
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}


	public Fornecedor(int idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String municipio, String uf, int codigo, Date cadastradoEm, String email, String telefone,
			String celular, String situacao) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf);
		this.codigo = codigo;
		this.idEndereco = idEndereco;
		this.cadastradoEm = cadastradoEm;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.situacao = situacao;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
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


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
}
