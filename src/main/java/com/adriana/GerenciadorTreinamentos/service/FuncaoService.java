package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Funcao;
import com.adriana.GerenciadorTreinamentos.repository.FuncaoRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class FuncaoService {

	@Autowired
	private FuncaoRepository repo;
	
	public Funcao find (Integer id) {
		Optional<Funcao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Funcao.class.getName()));
	}
	
	public Funcao insert (Funcao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcao update (Funcao obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar, pois existem referências externas.");
		}
	} 
}
