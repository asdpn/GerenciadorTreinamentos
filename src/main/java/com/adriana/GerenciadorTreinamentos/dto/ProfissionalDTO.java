package com.adriana.GerenciadorTreinamentos.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;

@Entity
public class ProfissionalDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nomeCompleto;
	private String email;

	
	public ProfissionalDTO() {
		
	}

	public ProfissionalDTO(Profissional obj) {
		this.nomeCompleto = obj.getNomeCompleto();
		this.email = obj.getEmail();
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
