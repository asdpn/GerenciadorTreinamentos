package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Usuario;
import com.adriana.GerenciadorTreinamentos.repository.UsuarioRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario getUsuario (Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario addUsuario (Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Usuario editUsuario (Usuario obj) {
		getUsuario(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteUsuario (Integer id) {
		getUsuario(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Usuario, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Usuario> getUsuarios() {
		return repo.findAll();
	}
}
