package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.repository.ProfissionalRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repo;
	
	public Profissional find (Integer id) {
		Optional<Profissional> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Profissional.class.getName()));
	}
	
	public Profissional insert (Profissional obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Profissional update (Profissional obj) {
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
	
	public List<Profissional> findAll() {
		return repo.findAll();
	}
}
