package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
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
	
	public Convite getConvite (Integer id) {
		Optional<Convite> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Convite.class.getName()));
	}
	
	public Convite addConvite (Convite obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Convite editConvite (Convite obj) {
		getConvite(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteConvite (Integer id) {
		getConvite(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Convite, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Convite> getConvites() {
		return repo.findAll();
	}
}
