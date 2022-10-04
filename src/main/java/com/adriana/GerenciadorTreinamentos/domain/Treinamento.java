package com.adriana.GerenciadorTreinamentos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusTreinamento;

@Entity
public class Treinamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private String motivoReprovacao;
	private StatusTreinamento statusTreinamento; 

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Turma turma;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Convite convite;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Prova prova;

	@ManyToMany
	@JoinTable(name = "TREINAMENTO_PROFISSIONAL",
			joinColumns = @JoinColumn(name = "id_treinamento"),
			inverseJoinColumns = @JoinColumn(name = "id_profissional"))
	
	private List<Profissional> profissionais = new ArrayList<>();
	
	public Treinamento() {
		
	}

	public Treinamento(Integer id, String titulo, String descricao, String motivoReprovacao, Categoria categoria, StatusTreinamento statusTreinamento, Turma turma, Convite convite, Prova prova) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;	
		this.motivoReprovacao = motivoReprovacao;
		this.statusTreinamento = statusTreinamento;
		this.categoria = categoria;
		this.turma = turma;
		this.convite = convite;
		this.prova = prova;
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

	public String getMotivoReprovacao() {
		return motivoReprovacao;
	}

	public void setMotivoReprovacao(String motivoReprovacao) {
		this.motivoReprovacao = motivoReprovacao;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
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
	
	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	
}
