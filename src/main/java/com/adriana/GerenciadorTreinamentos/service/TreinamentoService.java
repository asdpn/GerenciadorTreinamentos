package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.repository.TreinamentoRepository;

@Service
public class TreinamentoService {

	@Autowired
	private TreinamentoRepository repo;
	
	public Treinamento find (Integer id) {
		Optional<Treinamento> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
