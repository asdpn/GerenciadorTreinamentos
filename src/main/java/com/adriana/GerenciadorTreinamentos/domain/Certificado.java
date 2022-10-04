package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusCertificado;

@Entity
public class Certificado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private StatusCertificado statusCertificado;
	
	@OneToOne
	@JoinColumn(name = "id_resultado")
	@MapsId
	private Resultado resultado;	
	
	public Certificado() {
		
	}

	public Certificado(Integer id, StatusCertificado statusCertificado) {
		super();
		this.id = id;
		this.statusCertificado = statusCertificado;
		
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

	public StatusCertificado getStatusCertificado() {
		return statusCertificado;
	}

	public void setStatusCertificado(StatusCertificado statusCertificado) {
		this.statusCertificado = statusCertificado;
	}
	
}
