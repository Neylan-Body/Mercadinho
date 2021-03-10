package model;

import java.sql.Date;

public class ClientePessoaJuridica extends Cliente {

	private String razaoSocial;
	private String cnpj;
	private String ie;
	private Date abertura;

	public ClientePessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ClientePessoaJuridica(int idEndereco, String cep, String logradouro, String numero, String complemento,
			String bairro, String municipio, String uf, int codigo, Date cadastradoEm, String email, String telefone,
			String celular, double credito, String situacao, String razaoSocial, String cnpj, String ie,
			Date abertura) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf, codigo, cadastradoEm, email,
				telefone, celular, credito, situacao);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ie = ie;
		this.abertura = abertura;
	}



	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

}
