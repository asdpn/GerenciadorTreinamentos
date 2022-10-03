package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repo;
	
	public Profissional find (Integer id) {
		Optional<Profissional> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
