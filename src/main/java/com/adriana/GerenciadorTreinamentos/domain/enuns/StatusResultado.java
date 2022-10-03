package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusResultado {

	 CRIADO(1, "Criado"),
	 APROVADO(2, "Aprovado"),
	 REPROVADO(3, "Reprovado");
		
		private Integer cod;
		private String descricao;
		
		private StatusResultado(Integer cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}
		
		private static StatusResultado toEnum(Integer cod) {
			if (cod == null) {
				return null;
			}
			
			for (StatusResultado stR : StatusResultado.values()) {
				if (cod.equals(stR.getCod())) {
					return stR;
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
