package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Prova implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private Double notaMaxima;
	
	@Column(nullable = false)
	private Double notaMinima;
	
	
	@ManyToMany
	@JoinTable(name = "PROVA_QUESTAO",
			joinColumns = @JoinColumn(name = "id_prova"),
			inverseJoinColumns = @JoinColumn(name = "id_questao"))
	private List<Questao> questoes = new ArrayList<>();
	

	@OneToOne
	@JoinColumn(name = "id_profissional")
	@MapsId
	private Profissional profissional;
	
	@ManyToOne
	@JoinColumn(name="id_treinamento")
	private Treinamento treinamento;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "prova")
	private Resultado resultado;
	
	public Prova() {
		
	}

	public Prova(Integer id, Double notaMaxima, Double notaMinima, Resultado resultado, Profissional profissional, Treinamento treinamento) {
		super();
		this.id = id;
		this.notaMaxima = notaMaxima;
		this.notaMinima = notaMinima;	
		this.resultado = resultado;
		this.profissional = profissional;
		this.treinamento = treinamento;
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

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}


	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}
		
}
