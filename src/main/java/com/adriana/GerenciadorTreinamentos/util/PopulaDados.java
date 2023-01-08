package com.adriana.GerenciadorTreinamentos.util;

//import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.domain.Funcao;
import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.domain.enuns.Permissao;
import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusTreinamento;
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
	ProfissionalRepository profissionalRepository;
	
	@Autowired
	FuncaoRepository funcaoRepository;
	
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

	
	//@PostConstruct //Comentar isso quando mudar pro banco de dados Postgre
	public void cadastrar () {
		
		//Profissional adriana = new Profissional(null, "Adriana Sodré", "Coordenadora", "Radix", "adriana@teste.com", "91234 5678", null);
		
		
		
		Categoria dev = new Categoria(null,"Desenvolvimento de Software",null);
		Categoria lid = new Categoria(null,"Liderança",null);
		Categoria com = new Categoria(null,"Comunicação", null);
		
		//Prova p1 = new Prova(null, 10.0, 7.5,null);
		//Prova p2 = new Prova(null, 10.0, 7.0, null);
		
		//Questao q1 = new Questao(null, "Um menino tem 3 laranjas e comeu 2, com quantas ele ficou?", "1");
		//Questao q2 = new Questao(null, "Um menino tem 10 laranjas e comeu 2, com quantas ele ficou?", "8");
		//Questao q3 = new Questao(null, "Um menino tem 5 laranjas e comeu 2, com quantas ele ficou?", "3");
		//Questao q4 = new Questao(null, "Um menino tem 50 laranjas e comeu 2, com quantas ele ficou?", "48");
		//Questao q5 = new Questao(null, "Um menino tem 20 laranjas e comeu 10, com quantas ele ficou?", "10");
		
		
		
		//Treinamento t1 = new Treinamento(null, "C++", "Básico de C++", null, dev, StatusTreinamento.AGENDADO, null,null,p1);
		//Treinamento t2 = new Treinamento(null, ".NET", "Básico de .NET", null, dev, StatusTreinamento.CRIADO, null,null,p2);
		//Treinamento t3 = new Treinamento(null, "Comunicação Não Violenta", "Básico de CNV", null, com, StatusTreinamento.FINALIZADO, null,null,p1);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Turma tu1 = new Turma(null, 10, 2, t1);
	    //Convite c1 = new Convite(null, "Sala 1", sdf.parse("02/11/2022 16:15"), t1);
	    //Convite c2 = new Convite(null, "Sala 1", sdf.parse("02/11/2022 16:15"), t2);
	    //Convite c3 = new Convite(null, "Sala 1", sdf.parse("02/11/2022 16:15"), t3);
		
	    //Convite c1 = new Convite(null, "Sala 1", null, t1);
	    //Convite c2 = new Convite(null, "Sala 1", null, t2);
	    //Convite c3 = new Convite(null, "Sala 1", null, t3);

	    
	    //t1.setTurma(tu1);
	    //t2.setTurma(tu1);
	    //t3.setTurma(tu1);
	    
	    //t1.setConvite(c1);
	    //t2.setConvite(c2);
	    //t3.setConvite(c3);
		
		Funcao gerente = new Funcao(null, "Gerente","",Permissao.GERENTE);
		//Funcao coordenador = new Funcao(null, "Coordenador", Permissao.CONSULTA);
		
		Profissional adriana = new Profissional(null, "Adriana Sodré", "91234 5678", "Radix", "adriana@teste.com", "adrianaspdn", "123456", gerente);
		//Profissional pf2 = new Profissional(null, coordenador, TipoProfissional.INTERNO, "Adriana", "Radix", "adriana@teste123.com", "012384569", "0125892");
		
	
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));
		//usuarioRepository.saveAll(Arrays.asList(adrianasdpn));
		
		//provaRepository.saveAll(Arrays.asList(p1,p2));
		//questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
		//treinamentoRepository.saveAll(Arrays.asList(t1,t2,t3));
		funcaoRepository.saveAll(Arrays.asList(gerente));
		profissionalRepository.saveAll(Arrays.asList(adriana));
		//turmaRepository.saveAll(Arrays.asList(tu1));
		//conviteRepository.saveAll(Arrays.asList(c1,c2,c3));

		//p1.getQuestoes().addAll(Arrays.asList(q1,q2,q3));
		//p2.getQuestoes().addAll(Arrays.asList(q3,q4,q5));
		
		//q1.getProvas().addAll(Arrays.asList(p1));
		//q2.getProvas().addAll(Arrays.asList(p1));
		//q3.getProvas().addAll(Arrays.asList(p1,p2));
		//q4.getProvas().addAll(Arrays.asList(p2));
		//q5.getProvas().addAll(Arrays.asList(p2));

		//provaRepository.saveAll(Arrays.asList(p1,p2));
		//questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
	
	}
}
