package com.adriana.GerenciadorTreinamentos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Certificado;
import com.adriana.GerenciadorTreinamentos.service.CertificadoService;

@RestController
@RequestMapping("/certificado")
public class CertificadoResource {

	@Autowired
	private CertificadoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Certificado> getCertificado(@PathVariable Integer id) {
		Certificado obj = service.getCertificado(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Certificado> addCertificado(@RequestBody Certificado certificado) {
		certificado = service.addCertificado(certificado);
		return new ResponseEntity<>(certificado, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Certificado> editCertificado(@RequestBody Certificado certificado, @PathVariable Integer id) {
		certificado.setId(id);
		certificado = service.editCertificado(certificado);
		return new ResponseEntity<>(certificado, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCertificado(@PathVariable Integer id) {
		service.deleteCertificado(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Certificado>> getCertificados() {
		List<Certificado> list = service.getCertificados();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
