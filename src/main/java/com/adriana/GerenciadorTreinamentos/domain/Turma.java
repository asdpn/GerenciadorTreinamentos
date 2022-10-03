package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer tamanhoMaximo;
	private Integer tamanhoMinimo;
	
	
	@ManyToMany(mappedBy = "turmas")
	
	private List<Profissional> profissionais = new ArrayList<>();
	
	public Turma() {
		
	}

	public Turma(Integer id, Integer tamanhoMaximo, Integer tamanhoMinimo) {
		super();
		this.id = id;
		this.tamanhoMaximo = tamanhoMaximo;
		this.tamanhoMinimo = tamanhoMinimo;	
		
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
	
	
}
