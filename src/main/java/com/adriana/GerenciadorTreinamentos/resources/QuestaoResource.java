package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.service.QuestaoService;

@RestController
@RequestMapping(value = "/questao")
public class QuestaoResource {

	@Autowired
	QuestaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Questao> find(@PathVariable Integer id) {
		Questao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
