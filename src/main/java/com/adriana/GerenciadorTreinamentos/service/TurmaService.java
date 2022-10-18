package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.repository.TurmaRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;
	
	public Turma getTurma (Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Turma.class.getName()));
	}
	
	public Turma addTurma (Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Turma editTurma (Turma obj) {
		getTurma(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteTurma (Integer id) {
		getTurma(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Turma, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Turma> getTurmas() {
		return repo.findAll();
	}
}
