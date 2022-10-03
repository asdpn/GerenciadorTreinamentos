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
public class Prova implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double notaMaxima;
	private Double notaMinima;
	
	
	@ManyToMany
	@JoinTable(name = "PROVA_PROFISSIONAL",
			joinColumns = @JoinColumn(name = "id_prova"),
			inverseJoinColumns = @JoinColumn(name = "id_profissional"))
	
	private List<Profissional> profissionais = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "PROVA_QUESTAO",
			joinColumns = @JoinColumn(name = "id_prova"),
			inverseJoinColumns = @JoinColumn(name = "id_questao"))
	
	private List<Questao> questoes = new ArrayList<>();
	
	public Prova() {
		
	}

	public Prova(Integer id, Double notaMaxima, Double notaMinima) {
		super();
		this.id = id;
		this.notaMaxima = notaMaxima;
		this.notaMinima = notaMinima;	}
	
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
		Prova other = (Prova) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(Double notaMaxima) {
		this.notaMaxima = notaMaxima;
	}
	
	public Double getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Double notaMinima) {
		this.notaMinima = notaMinima;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
}
