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

import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.service.ProfissionalService;

@RestController
@RequestMapping("/profissional")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Profissional> getProfissional(@PathVariable Integer id) {
		Profissional obj = service.getProfissional(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Profissional> addProfissional(@RequestBody Profissional profissional) {
		profissional = service.addProfissional(profissional);
		return new ResponseEntity<>(profissional, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Profissional> editProfissional(@RequestBody Profissional profissional, @PathVariable Integer id) {
		profissional.setId(id);
		profissional = service.editProfissional(profissional);
		return new ResponseEntity<>(profissional, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProfissional(@PathVariable Integer id) {
		service.deleteProfissional(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Profissional>> getProfissionais() {
		List<Profissional> list = service.getProfissionais();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<Profissional> authenticatProfissional(@RequestBody Profissional profissional) {
		Profissional profissionalEncontrado = service.authenticateProfissional(profissional.getEmail(), profissional.getSenha());
		return new ResponseEntity<>(profissionalEncontrado, HttpStatus.OK);
	}
}
