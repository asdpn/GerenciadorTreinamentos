package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusTreinamento {
	Criado("Criado"),
	Agendado("Agendado"),
	Finalizado("Finalizado");
		
		private String descricao;
		
		private StatusTreinamento(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
}
