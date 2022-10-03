package com.adriana.GerenciadorTreinamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Certificado;
import com.adriana.GerenciadorTreinamentos.repository.CertificadoRepository;

@Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repo;
	
	public Certificado find (Integer id) {
		Optional<Certificado> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
