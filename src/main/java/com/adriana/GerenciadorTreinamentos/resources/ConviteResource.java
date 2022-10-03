package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.service.ConviteService;

@RestController
@RequestMapping(value = "/convite")
public class ConviteResource {

	@Autowired
	ConviteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Convite> find(@PathVariable Integer id) {
		Convite obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
