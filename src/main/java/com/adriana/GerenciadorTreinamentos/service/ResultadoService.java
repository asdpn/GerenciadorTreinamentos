package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Resultado;
import com.adriana.GerenciadorTreinamentos.repository.ResultadoRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository repo;
	
	public Resultado getResultado (Integer id) {
		Optional<Resultado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Resultado.class.getName()));
	}
	
	public Resultado addResultado (Resultado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Resultado editResultado (Resultado obj) {
		getResultado(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteResultado (Integer id) {
		getResultado(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Resultado, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Resultado> getResultados() {
		return repo.findAll();
	}
}
