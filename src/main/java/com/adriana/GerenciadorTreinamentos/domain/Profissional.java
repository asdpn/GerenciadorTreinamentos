package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Profissional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nomeCompleto;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String empresa;
	
	@Column(nullable = false)
	private String email;
	
	
	@Column(nullable = false)
	private String nomeUsuario;
	
	@Column(nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="id_funcao")
	private Funcao funcao;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PROFISSIONAL_TREINAMENTO",
			joinColumns = @JoinColumn(name = "id_profissional"),
			inverseJoinColumns = @JoinColumn(name = "id_treinamento"))
	private List<Treinamento> treinamentos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PROFISSIONAL_TURMA",
			joinColumns = @JoinColumn(name = "id_profissional"),
			inverseJoinColumns = @JoinColumn(name = "id_turma"))
	private List<Turma> turmas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "profissional")
	private List<Resultado> resultados = new ArrayList<>();
	
			
	public Profissional() {
		
	}

	public Profissional(Integer id, String nomeCompleto, String telefone, String empresa, String email,
			String nomeUsuario, String senha, Funcao funcao) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.empresa = empresa;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Treinamento> getTreinamentos() {
		return treinamentos;
	}

	public void setTreinamentos(List<Treinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

}
