package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.service.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class CertificadoResource {

	@Autowired
	TurmaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> find(@PathVariable Integer id) {
		Turma obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
