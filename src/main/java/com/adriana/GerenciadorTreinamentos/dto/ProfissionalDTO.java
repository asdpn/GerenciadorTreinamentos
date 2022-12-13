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
	private String email;
	private String senha;

	
	public ProfissionalDTO() {
		
	}

	public ProfissionalDTO(Profissional obj) {
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

}
