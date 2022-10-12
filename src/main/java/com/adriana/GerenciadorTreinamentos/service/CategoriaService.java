package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.repository.CategoriaRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria getCategoria (Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria addCategoria (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria editCategoria (Categoria obj) {
		getCategoria(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteCategoria (Integer id) {
		getCategoria(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Categoria, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Categoria> getCategorias() {
		return repo.findAll();
	}
}
