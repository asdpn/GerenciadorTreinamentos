package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.repository.TreinamentoRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class TreinamentoService {

	@Autowired
	private TreinamentoRepository repo;
	
	public Treinamento find (Integer id) {
		Optional<Treinamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Treinamento.class.getName()));
	}
	
	public Treinamento insert (Treinamento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Treinamento update (Treinamento obj) {
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
	
	public List<Treinamento> findAll() {
		return repo.findAll();
	}
}
