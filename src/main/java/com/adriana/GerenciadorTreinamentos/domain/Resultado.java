package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusResultado;

@Entity
public class Resultado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private Double notaObtida;
	
	@Column(nullable = false)
	private StatusResultado statusResultado;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "resultado")
	private Certificado certificado;
	
	
	@ManyToOne
	@JoinColumn(name="id_prova")
	private Prova prova;
	
	@ManyToOne
	@JoinColumn(name="id_profissional")
	private Profissional profissional;
	
	public Resultado() {
		
	}

	public Resultado(Integer id, String titulo, Double notaObtida, StatusResultado statusResultado, Certificado certificado, Profissional profissional, Prova prova) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.notaObtida = notaObtida;
		this.statusResultado = statusResultado;
		this.certificado = certificado;
		this.prova = prova;
		this.profissional = profissional;
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
		Resultado other = (Resultado) obj;
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

	public Double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(Double notaObtida) {
		this.notaObtida = notaObtida;
	}

	public StatusResultado getStatusResultado() {
		return statusResultado;
	}

	public void setStatusResultado(StatusResultado statusResultado) {
		this.statusResultado = statusResultado;
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
			
}
