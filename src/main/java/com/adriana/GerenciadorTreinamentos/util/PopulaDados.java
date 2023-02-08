package com.adriana.GerenciadorTreinamentos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.domain.Certificado;
import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.domain.Funcao;
import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.domain.Resultado;
import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.domain.enuns.Permissao;
import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusCertificado;
import com.adriana.GerenciadorTreinamentos.domain.enuns.StatusResultado;
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
	public void cadastrar () throws ParseException {
		
		Categoria dev = new Categoria(null,"Desenvolvimento de Software","Treinamentos relacionados a Desenvolvimento de Software");
		Categoria lid = new Categoria(null,"Liderança","Treinamentos relacionados a Liderança");
		Categoria com = new Categoria(null,"Comunicação", "Treinamentos relacionados a Comunicação");
		
		Treinamento t1 = new Treinamento(null, "C++", "Básico de C++", null, dev, StatusTreinamento.Agendado, null,null,null);
		Treinamento t2 = new Treinamento(null, ".NET", "Básico de .NET", null, dev, StatusTreinamento.Criado, null,null,null);
		Treinamento t3 = new Treinamento(null, "Comunicação Não Violenta", "Básico de CNV", null, com, StatusTreinamento.Finalizado, null,null,null);
		
		Funcao gerente = new Funcao(null, "Gerente","Cargo com permissão de Gerente",Permissao.Gerente);
		Funcao pales = new Funcao(null, "Palestrante","Cargo com permissão de Palestrante",Permissao.Palestrante);
		Funcao prof = new Funcao(null, "Profissional","Cargo com permissão de Profissional",Permissao.Profissional);
		
		Profissional gerenteTreinamento = new Profissional(null, "Adriana Sodré", "91234 5678", "Radix", "adriana@teste.com", "adrianaspdn", "123456", gerente);
		Profissional palestrante = new Profissional(null, "Adriana Palestrante", "91234 5678", "Radix", "adrianaPalestrante@teste.com", "adrianaspdn_pales", "123456", pales);
		Profissional profissional = new Profissional(null, "Adriana Profissional", "91234 5678", "Radix", "adrianaProf@teste.com", "adrianaspdn_prof", "123456", prof);
			
		Prova p1 = new Prova(null, "Prova 1", 5.0, 3.5, t1);
		Prova p2 = new Prova(null, "Prova 2", 10.0, 7.0, t2);
		Prova p3 = new Prova(null, "Prova 3", 10.0, 7.0, t3);
		
		Certificado cert1 =  new Certificado(null, "Certificado 1", StatusCertificado.Criado, null);
		Certificado cert2 =  new Certificado(null, "Certificado 2", StatusCertificado.Enviado, null);
		Certificado cert3 =  new Certificado(null, "Certificado 3", StatusCertificado.Validado, null);
		
		
		Resultado r1 = new Resultado(null, "Resultado 1", 4.5, StatusResultado.Criado, cert1, gerenteTreinamento, p1);
		Resultado r2 = new Resultado(null, "Resultado 2", 8.5, StatusResultado.Criado, cert2, palestrante, p2);
		Resultado r3 = new Resultado(null, "Resultado 3", 10.5, StatusResultado.Criado, cert3, profissional, p3);
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
	    Convite c1 = new Convite(null, "Convite 1", "Sala 1", sdf.parse("02/11/2022 16:15"), t1);
	    Convite c2 = new Convite(null, "Convite 2", "Sala 1", sdf.parse("02/11/2022 16:15"), t2);
	    Convite c3 = new Convite(null, "Convite 3", "Sala 1", sdf.parse("02/11/2022 16:15"), t3);
	    
		
		Questao q1 = new Questao(null, "Um menino tem 3 laranjas e comeu 2, com quantas ele ficou?", "1");
		Questao q2 = new Questao(null, "Um menino tem 10 laranjas e comeu 2, com quantas ele ficou?", "8");
		Questao q3 = new Questao(null, "Um menino tem 5 laranjas e comeu 2, com quantas ele ficou?", "3");
		Questao q4 = new Questao(null, "Um menino tem 50 laranjas e comeu 2, com quantas ele ficou?", "48");
		Questao q5 = new Questao(null, "Um menino tem 20 laranjas e comeu 10, com quantas ele ficou?", "10");

		Turma tu1 = new Turma(null, "Turma 1", 10, 2);
		Turma tu2 = new Turma(null, "Turma 2", 10, 2);
		Turma tu3 = new Turma(null, "Turma 3", 10, 2);
	    
	    t1.setConvite(c1);
	    t2.setConvite(c2);
	    t3.setConvite(c3);
	    
	    t1.setProva(p1);
	    t2.setProva(p2);
	    t3.setProva(p3);    
	    
	    cert1.setResultado(r1);
	    cert2.setResultado(r2);
	    cert3.setResultado(r3);
	    
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));
		treinamentoRepository.saveAll(Arrays.asList(t1,t2,t3));
		funcaoRepository.saveAll(Arrays.asList(gerente, pales, prof));
		profissionalRepository.saveAll(Arrays.asList(gerenteTreinamento, palestrante, profissional));
		provaRepository.saveAll(Arrays.asList(p1,p2,p3));
		certificadoRepository.saveAll(Arrays.asList(cert1, cert2, cert3));
		resultadoRepository.saveAll(Arrays.asList(r1,r2,r3));
		conviteRepository.saveAll(Arrays.asList(c1, c2, c3));
		questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
		turmaRepository.saveAll(Arrays.asList(tu1,tu2, tu3));
		
	    t1.setTurma(tu1);
	    t2.setTurma(tu2);
	    t3.setTurma(tu3);
	    
		treinamentoRepository.saveAll(Arrays.asList(t1,t2,t3));

		
		p1.getQuestoes().addAll(Arrays.asList(q1,q2,q3));
		p2.getQuestoes().addAll(Arrays.asList(q3,q4,q5));
		
		q1.getProvas().addAll(Arrays.asList(p1));
		q2.getProvas().addAll(Arrays.asList(p1));
		q3.getProvas().addAll(Arrays.asList(p1,p2));
		q4.getProvas().addAll(Arrays.asList(p2));
		q5.getProvas().addAll(Arrays.asList(p2));

		provaRepository.saveAll(Arrays.asList(p1,p2));
		questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
		
		
		gerenteTreinamento.getTreinamentos().addAll(Arrays.asList(t1,t2));
		palestrante.getTreinamentos().addAll(Arrays.asList(t1,t2,t3));
		profissional.getTreinamentos().addAll(Arrays.asList(t1,t3));
		
		gerenteTreinamento.getTurmas().addAll(Arrays.asList(tu1,tu2));
		palestrante.getTurmas().addAll(Arrays.asList(tu1,tu2,tu3));
		profissional.getTurmas().addAll(Arrays.asList(tu1,tu3));

		palestrante.getTreinamentos().addAll(Arrays.asList(t1,t2,t3));
		
		profissionalRepository.saveAll(Arrays.asList(gerenteTreinamento, palestrante, profissional));
	}
}
