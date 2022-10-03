package com.adriana.GerenciadorTreinamentos.util;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.domain.Questao;
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
		
		Prova p1 = new Prova(null, 10.0, 7.5);
		Prova p2 = new Prova(null, 10.0, 7.0);
		
		Questao q1 = new Questao(null, "Um menino tem 3 laranjas e comeu 2, com quantas ele ficou?", "1");
		Questao q2 = new Questao(null, "Um menino tem 10 laranjas e comeu 2, com quantas ele ficou?", "8");
		Questao q3 = new Questao(null, "Um menino tem 5 laranjas e comeu 2, com quantas ele ficou?", "3");
		Questao q4 = new Questao(null, "Um menino tem 50 laranjas e comeu 2, com quantas ele ficou?", "48");
		Questao q5 = new Questao(null, "Um menino tem 20 laranjas e comeu 10, com quantas ele ficou?", "10");
		
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));
		provaRepository.saveAll(Arrays.asList(p1,p2));
		questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));

		p1.getQuestoes().addAll(Arrays.asList(q1,q2,q3));
		p2.getQuestoes().addAll(Arrays.asList(q3,q4,q5));
		
		q1.getProvas().addAll(Arrays.asList(p1));
		q2.getProvas().addAll(Arrays.asList(p1));
		q3.getProvas().addAll(Arrays.asList(p1,p2));
		q4.getProvas().addAll(Arrays.asList(p2));
		q5.getProvas().addAll(Arrays.asList(p2));
		
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));
		provaRepository.saveAll(Arrays.asList(p1,p2));
		questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
	
	}
}
