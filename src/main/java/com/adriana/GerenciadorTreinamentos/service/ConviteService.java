package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.repository.ConviteRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class ConviteService {

	@Autowired
	private ConviteRepository repo;
	
	public Convite get (Integer id) {
		Optional<Convite> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Convite.class.getName()));
	}
	
	public Convite create (Convite obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Convite edit (Convite obj) {
		get(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		get(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar, pois existem referências externas.");
		}
	} 
}
