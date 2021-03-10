package model;

import java.sql.Date;

public class Funcionario extends Endereco {
	private int codigo;
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
	private Date cadastradoEm;
	private String email;
	private String telefone;
	private String celular;
	private int idOcupacao;
	private int idEndereco;
	private double salario;
	private String senha;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String municipio, String uf, int codigo, String nome, String cpf, String rg, String orgaoEmissor,
			Date dtEmissao, String estadoCivil, Date dtNascimento, String nacionalidade, String ufDoc,
			String naturalidade, String sexo, Date cadastradoEm, String email, String telefone, String celular,
			int idOcupacao, double salario, String senha) {
		super(idEndereco, cep, logradouro, numero, complemento, bairro, municipio, uf);
		this.codigo = codigo;
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
		this.cadastradoEm = cadastradoEm;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.idOcupacao = idOcupacao;
		this.idEndereco = idEndereco;
		this.salario = salario;
		this.senha = senha;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getIdOcupacao() {
		return idOcupacao;
	}

	public void setIdOcupacao(int idOcupacao) {
		this.idOcupacao = idOcupacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
