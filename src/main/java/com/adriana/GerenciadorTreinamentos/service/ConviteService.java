package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.repository.ConviteRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;

@Service
public class ConviteService {

	@Autowired
	private ConviteRepository repo;
	
	public Convite find (Integer id) {
		Optional<Convite> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID:" + id + "Tipo:" + Convite.class.getName()));
	}
}
