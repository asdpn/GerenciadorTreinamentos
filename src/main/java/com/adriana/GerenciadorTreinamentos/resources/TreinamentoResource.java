package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.service.TreinamentoService;

@RestController
@RequestMapping(value = "/treinamento")
public class TreinamentoResource {

	@Autowired
	TreinamentoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Treinamento> find(@PathVariable Integer id) {
		Treinamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
