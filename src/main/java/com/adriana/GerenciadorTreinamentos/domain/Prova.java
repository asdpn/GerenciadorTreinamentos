package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prova implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float notaMaxima;
	private Float notaMinima;
	
	public Prova() {
		
	}

	public Prova(Integer id, Float notaMaxima, Float notaMinima) {
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

	public Float getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(Float notaMaxima) {
		this.notaMaxima = notaMaxima;
	}
	
	public Float getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Float notaMinima) {
		this.notaMinima = notaMinima;
	}
	
	
}
