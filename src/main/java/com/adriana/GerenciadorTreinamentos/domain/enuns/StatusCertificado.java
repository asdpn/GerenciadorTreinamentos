package com.adriana.GerenciadorTreinamentos.domain.enuns;

public enum StatusCertificado {

	 CRIADO(1, "Criado"),
	 VALIDADO(2, "Validado"),
	 ENVIADO(3, "Enviado");
		
		private Integer cod;
		private String descricao;
		
		private StatusCertificado(Integer cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}
		
		private static StatusCertificado toEnum(Integer cod) {
			if (cod == null) {
				return null;
			}
			
			for (StatusCertificado stC : StatusCertificado.values()) {
				if (cod.equals(stC.getCod())) {
					return stC;
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
