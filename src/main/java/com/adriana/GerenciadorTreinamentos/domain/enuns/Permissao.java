package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum Permissao {
	GERENTE(1, "Gerente de Treinamentos"),
	PALESTRANTE(2, "Palestrante"),
	PROFISSIONAL(3,"Profissional");
	
	private Integer cod;
	private String descricao;
	
	private Permissao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static Permissao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Permissao p : Permissao.values()) {
			if (cod.equals(p.getCod())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
