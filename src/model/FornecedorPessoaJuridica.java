package model;

import java.sql.Date;

public class FornecedorPessoaJuridica extends Fornecedor{
	
	private String razaoSocial;
	private String cnpj;
	private String ie;

	
	public FornecedorPessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public FornecedorPessoaJuridica(int idEndereco, String cep, String logradouro, String numero, String complemento,
			String bairro, String municipio, String uf, int codigo, Date cadastradoEm, String email, String telefone,
			String celular, String situacao, String razaoSocial, String cnpj, String ie) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf, codigo, cadastradoEm, email,
				telefone, celular, situacao);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ie = ie;
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
	
	
}
