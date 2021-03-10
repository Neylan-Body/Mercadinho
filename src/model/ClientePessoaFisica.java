package model;

import java.sql.Date;

public class ClientePessoaFisica extends Cliente {

	private String nome;
	private String cpf;
	private String rg;
	private String orgaoEmissor;
	private Date dtEmissao;
	private String estadoCivil;
	private Date dtNascimento;
	private String nacionalidade;
	private String ufDoc;
	private String naturalidade;
	private String sexo;

	public ClientePessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public ClientePessoaFisica(int idEndereco, String cep, String logradouro, String numero, String complemento,
			String bairro, String municipio, String uf, int codigo, Date cadastradoEm, String email, String telefone,
			String celular, double credito, String situacao, String nome, String cpf, String rg, String orgaoEmissor,
			Date dtEmissao, String estadoCivil, Date dtNascimento, String nacionalidade, String ufDoc,
			String naturalidade, String sexo) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf, codigo, cadastradoEm, email,
				telefone, celular, credito, situacao);
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.dtEmissao = dtEmissao;
		this.estadoCivil = estadoCivil;
		this.dtNascimento = dtNascimento;
		this.nacionalidade = nacionalidade;
		this.ufDoc = ufDoc;
		this.naturalidade = naturalidade;
		this.sexo = sexo;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getUfDoc() {
		return ufDoc;
	}

	public void setUfDoc(String ufDoc) {
		this.ufDoc = ufDoc;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
