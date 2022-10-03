package com.adriana.GerenciadorTreinamentos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Certificado;
import com.adriana.GerenciadorTreinamentos.service.CertificadoService;

@RestController
@RequestMapping(value = "/certificado")
public class CertificadoResource {

	@Autowired
	CertificadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Certificado> find(@PathVariable Integer id) {
		Certificado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
