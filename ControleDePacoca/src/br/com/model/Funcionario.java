package br.com.model;

public class Funcionario {
	
	private Long id;
	private String nome;
	private String setor;
	private Integer quantPacocas;
	
	public Funcionario() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Integer getQuantPacocas() {
		return quantPacocas;
	}

	public void setQuantPacocas(Integer quantPacocas) {
		this.quantPacocas = quantPacocas;
	}
}
