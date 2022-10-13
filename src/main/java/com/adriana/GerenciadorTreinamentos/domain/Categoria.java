package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
//import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	private String descricao;
	
	//@OneToMany(mappedBy = "categoria")
	//private List<Treinamento> treinamentos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	//public List<Treinamento> getTreinamentos() {
	//	return treinamentos;
	//}

	//public void setTreinamentos(List<Treinamento> treinamentos) {
	//	this.treinamentos = treinamentos;
	//}
		
}
