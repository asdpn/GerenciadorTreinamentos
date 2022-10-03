package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.repository.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repo;
	
	public Questao find (Integer id) {
		Optional<Questao> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
