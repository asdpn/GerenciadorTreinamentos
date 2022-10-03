package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Profissional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	@JoinTable(name = "PROFISSIONAL_TURMA",
			joinColumns = @JoinColumn(name = "id_profissional"),
			inverseJoinColumns = @JoinColumn(name = "id_turma"))
	
	private List<Turma> turmas = new ArrayList<>();
	
	@ManyToMany(mappedBy = "profissionais")
	private List<Treinamento> treinamentos = new ArrayList<>();
	
	@ManyToMany(mappedBy = "profissionais")
	private List<Prova> provas = new ArrayList<>();
	
	public Profissional() {
		
	}

	public Profissional(Integer id) {
		super();
		this.id = id;
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
	
}
