package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusResultado {

	Criado("Criado"),
	Aprovado("Aprovado"),
	Reprovado("Reprovado");

		private String descricao;
		
		private StatusResultado(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
}
