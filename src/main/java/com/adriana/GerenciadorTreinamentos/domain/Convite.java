package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Convite implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String localLink;
	
	@Column(nullable = false)
	private Date dataHora;
	
	@OneToOne
	@JoinColumn(name = "id_treinamento")
	@MapsId
	private Treinamento treinamento;
	
	public Convite() {
		
	}

	public Convite(Integer id, String titulo, String localLink, Date dataHora, Treinamento treinamento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.localLink = localLink;
		this.dataHora = dataHora;	
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
		Convite other = (Convite) obj;
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

	public String getLocalLink() {
		return localLink;
	}

	public void setLocalLink(String localLink) {
		this.localLink = localLink;
	}
	
	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}
	
	
}
