package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.repository.ProvaRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repo;
	
	public Prova find (Integer id) {
		Optional<Prova> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Prova.class.getName()));
	}
	
	public Prova insert (Prova obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Prova update (Prova obj) {
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
