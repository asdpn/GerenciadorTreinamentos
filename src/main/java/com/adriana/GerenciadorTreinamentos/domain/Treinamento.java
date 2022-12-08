package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusTreinamento;

@Entity
public class Treinamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	private String descricao;
	
	@Column(nullable = false)
	private StatusTreinamento statusTreinamento; 

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Turma turma;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Convite convite;
	
	@OneToMany(mappedBy = "treinamento")
	private List<Prova> provas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="id_profissional")
	private Profissional palestrante;
		
	public Treinamento() {
		
	}

	public Treinamento(Integer id, String titulo, String descricao, String motivoReprovacao, Categoria categoria, StatusTreinamento statusTreinamento, Turma turma, Convite convite, Prova prova, Profissional palestrante) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;	
		this.statusTreinamento = statusTreinamento;
		this.categoria = categoria;
		this.turma = turma;
		this.convite = convite;
		this.palestrante = palestrante;
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
		Treinamento other = (Treinamento) obj;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Profissional getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Profissional palestrante) {
		this.palestrante = palestrante;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public StatusTreinamento getStatusTreinamento() {
		return statusTreinamento;
	}

	public void setStatusTreinamento(StatusTreinamento statusTreinamento) {
		this.statusTreinamento = statusTreinamento;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Convite getConvite() {
		return convite;
	}

	public void setConvite(Convite convite) {
		this.convite = convite;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}
		
}
