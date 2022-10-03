package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Funcao;
import com.adriana.GerenciadorTreinamentos.repository.FuncaoRepository;

@Service
public class FuncaoService {

	@Autowired
	private FuncaoRepository repo;
	
	public Funcao find (Integer id) {
		Optional<Funcao> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
