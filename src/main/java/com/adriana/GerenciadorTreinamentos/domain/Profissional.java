package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.TipoProfissional;
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
	private TipoProfissional tipoProfissional;
	
	@Column(nullable = false)
	private String empresa;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="id_funcao")
	private Funcao funcao;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PROFISSIONAL_TURMA",
			joinColumns = @JoinColumn(name = "id_profissional"),
			inverseJoinColumns = @JoinColumn(name = "id_turma"))
	
	private List<Turma> turmas = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "profissionais")
	private List<Treinamento> treinamentos = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "profissional")
	private Prova prova;	
	
	public Profissional() {
		
	}

	public Profissional(Integer id, Funcao funcao, TipoProfissional tipoProfissional, String nomeCompleto, String empresa, String email, String telefone, String senha, Prova prova) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.funcao = funcao;
		this.tipoProfissional = tipoProfissional;
		this.empresa = empresa;
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.prova = prova;
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

	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}	

	public List<Treinamento> getTreinamentos() {
		return treinamentos;
	}

	public void setTreinamentos(List<Treinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}
	
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public TipoProfissional getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(TipoProfissional tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
		
}
