package model;

public class Ocupacao {

	private int id;
	private String ocupacao;

	public Ocupacao() {
		// TODO Auto-generated constructor stub
	}

	public Ocupacao(int id, String ocupacao) {
		super();
		this.id = id;
		this.ocupacao = ocupacao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getOcupacao() {
		return ocupacao;
	}

}
