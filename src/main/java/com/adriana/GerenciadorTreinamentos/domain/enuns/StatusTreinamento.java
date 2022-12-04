package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusTreinamento {
	 CRIADO (1, "Criado"),
	 AGENDADO(2, "Agendado"),
	 FINALIZADO(3, "Finalizado");
		
		private Integer cod;
		private String descricao;
		
		private StatusTreinamento(Integer cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}
		
		public static StatusTreinamento toEnum(Integer cod) {
			if (cod == null) {
				return null;
			}
			
			for (StatusTreinamento stT : StatusTreinamento.values()) {
				if (cod.equals(stT.getCod())) {
					return stT;
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
