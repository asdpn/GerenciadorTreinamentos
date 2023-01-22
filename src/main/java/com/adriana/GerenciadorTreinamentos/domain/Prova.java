package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prova implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
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
	@JoinColumn(name = "id_treinamento")
	@MapsId
	private Treinamento treinamento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "prova")
	private List<Resultado> resultados  = new ArrayList<>();
	
	public Prova() {
		
	}

	public Prova(Integer id, String titulo, Double notaMaxima, Double notaMinima, Treinamento treinamento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.notaMaxima = notaMaxima;
		this.notaMinima = notaMinima;	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
		
}
