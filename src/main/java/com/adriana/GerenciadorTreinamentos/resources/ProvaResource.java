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

import com.adriana.GerenciadorTreinamentos.domain.Prova;
import com.adriana.GerenciadorTreinamentos.service.ProvaService;

@RestController
@RequestMapping("/prova")
public class ProvaResource {

	@Autowired
	private ProvaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Prova> getProva(@PathVariable Integer id) {
		Prova obj = service.getProva(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Prova> addProva(@RequestBody Prova prova) {
		prova = service.addProva(prova);
		return new ResponseEntity<>(prova, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Prova> editProva(@RequestBody Prova prova, @PathVariable Integer id) {
		prova.setId(id);
		prova = service.editProva(prova);
		return new ResponseEntity<>(prova, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProva(@PathVariable Integer id) {
		service.deleteProva(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Prova>> getProvas() {
		List<Prova> list = service.getProvas();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
