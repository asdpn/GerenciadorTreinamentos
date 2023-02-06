package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum Permissao {
	Gerente("Gerente de Treinamentos"),
	Palestrante("Palestrante"),
	Profissional("Profissional");

	private String descricao;
	
	private Permissao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
