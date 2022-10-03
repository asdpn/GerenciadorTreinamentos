package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Resultado;
import com.adriana.GerenciadorTreinamentos.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository repo;
	
	public Resultado find (Integer id) {
		Optional<Resultado> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
