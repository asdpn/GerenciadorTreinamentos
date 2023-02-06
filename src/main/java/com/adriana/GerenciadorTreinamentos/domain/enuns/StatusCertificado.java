package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusCertificado {

	 Criado("Criado"),
	 Validado("Validado"),
	 Enviado("Enviado");
		
		private String descricao;
		
		private StatusCertificado(String descricao) {
			this.descricao = descricao;
		}
		

		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
}
