package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.service.ProvaService;

@RestController
@RequestMapping(value = "/prova")
public class ProvaResource {

	@Autowired
	ProvaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prova> find(@PathVariable Integer id) {
		Prova obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
