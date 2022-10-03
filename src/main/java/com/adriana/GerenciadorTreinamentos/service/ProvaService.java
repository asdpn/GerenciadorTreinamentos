package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repo;
	
	public Prova find (Integer id) {
		Optional<Prova> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
