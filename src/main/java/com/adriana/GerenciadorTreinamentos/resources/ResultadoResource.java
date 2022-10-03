package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Resultado;
import com.adriana.GerenciadorTreinamentos.service.ResultadoService;

@RestController
@RequestMapping(value = "/Resultado")
public class ResultadoResource {

	@Autowired
	ResultadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resultado> find(@PathVariable Integer id) {
		Resultado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
