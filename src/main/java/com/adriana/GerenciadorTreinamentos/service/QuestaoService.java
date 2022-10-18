package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.repository.QuestaoRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repo;
	
	public Questao getQuestao (Integer id) {
		Optional<Questao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Questao.class.getName()));
	}
	
	public Questao addQuestao (Questao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Questao editQuestao (Questao obj) {
		getQuestao(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteQuestao (Integer id) {
		getQuestao(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Questao, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Questao> getQuestoes() {
		return repo.findAll();
	}
}
