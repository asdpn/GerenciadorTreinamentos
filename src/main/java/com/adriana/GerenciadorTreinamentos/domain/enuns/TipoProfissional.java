package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum TipoProfissional {
 INTERNO(1, "Interno"),
 EXTERNO(2, "Externo");
	
	private Integer cod;
	private String descricao;
	
	private TipoProfissional(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	private static TipoProfissional toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoProfissional tp : TipoProfissional.values()) {
			if (cod.equals(tp.getCod())) {
				return tp;
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
