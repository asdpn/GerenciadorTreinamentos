package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;	
	
	@Column(nullable = false)
	private Integer tamanhoMaximo;
	
	@Column(nullable = false)
	private Integer tamanhoMinimo;
	
	@OneToOne
	@JoinColumn(name = "id_treinamento")
	@MapsId
	private Treinamento treinamento;	
	
	@ManyToMany(mappedBy = "turmas")
	private List<Profissional> profissionais = new ArrayList<>();
	
	public Turma() {
		
	}

	public Turma(Integer id, String titulo, Integer tamanhoMaximo, Integer tamanhoMinimo, Treinamento treinamento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.tamanhoMinimo = tamanhoMinimo;	
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
		Turma other = (Turma) obj;
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

	public Integer getTamanhoMinimo() {
		return tamanhoMinimo;
	}

	public void setTamanhoMinimo(Integer tamanhoMinimo) {
		this.tamanhoMinimo = tamanhoMinimo;
	}
	
	public Integer getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoMaximo(Integer tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}
	
}
