package com.adriana.GerenciadorTreinamentos.util;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.repository.CategoriaRepository;
import com.adriana.GerenciadorTreinamentos.repository.CertificadoRepository;
import com.adriana.GerenciadorTreinamentos.repository.ConviteRepository;
import com.adriana.GerenciadorTreinamentos.repository.FuncaoRepository;
import com.adriana.GerenciadorTreinamentos.repository.ProfissionalRepository;
import com.adriana.GerenciadorTreinamentos.repository.ProvaRepository;
import com.adriana.GerenciadorTreinamentos.repository.QuestaoRepository;
import com.adriana.GerenciadorTreinamentos.repository.ResultadoRepository;
import com.adriana.GerenciadorTreinamentos.repository.TreinamentoRepository;
import com.adriana.GerenciadorTreinamentos.repository.TurmaRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	CertificadoRepository certificadoRepository;
	
	@Autowired
	ConviteRepository conviteRepository;

	@Autowired
	FuncaoRepository funcaoRepository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	@Autowired
	ProvaRepository provaRepository;
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Autowired
	ResultadoRepository resultadoRepository;
	
	@Autowired
	TreinamentoRepository treinamentoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;	
	
	@PostConstruct //Comentar isso quando mudar pro banco de dados Postgre
	public void cadastrar () {
		Categoria dev = new Categoria(null,"Desenvolvimento");
		Categoria lid = new Categoria(null,"Liderança");
		Categoria com = new Categoria(null,"Comunicação");
		
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));
		
	}
}
