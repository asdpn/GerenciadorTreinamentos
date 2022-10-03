package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;
	
	public Turma find (Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
