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
	
	public Resultado find (Integer id) {
		Optional<Resultado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Resultado.class.getName()));
	}
	
	public Resultado insert (Resultado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Resultado update (Resultado obj) {
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
	
	public List<Resultado> findAll() {
		return repo.findAll();
	}
}
