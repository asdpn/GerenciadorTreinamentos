package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusCertificado;

@Entity
public class Certificado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private StatusCertificado statusCertificado;
	

	@OneToOne
	@JoinColumn(name = "id_resultado")
	@MapsId
	private Resultado resultado;	
	
	public Certificado() {
		
	}

	public Certificado(Integer id, String titulo, StatusCertificado statusCertificado, Resultado resultado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.statusCertificado = statusCertificado;
		this.resultado = resultado;
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
		Certificado other = (Certificado) obj;
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

	public StatusCertificado getStatusCertificado() {
		return statusCertificado;
	}

	public void setStatusCertificado(StatusCertificado statusCertificado) {
		this.statusCertificado = statusCertificado;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
}
