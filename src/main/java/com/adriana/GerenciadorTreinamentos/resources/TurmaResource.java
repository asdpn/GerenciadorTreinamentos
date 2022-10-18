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

import com.adriana.GerenciadorTreinamentos.domain.Turma;
import com.adriana.GerenciadorTreinamentos.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

	@Autowired
	private TurmaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> getTurma(@PathVariable Integer id) {
		Turma obj = service.getTurma(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Turma> addTurma(@RequestBody Turma turma) {
		turma = service.addTurma(turma);
		return new ResponseEntity<>(turma, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Turma> editTurma(@RequestBody Turma turma, @PathVariable Integer id) {
		turma.setId(id);
		turma = service.editTurma(turma);
		return new ResponseEntity<>(turma, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTurma(@PathVariable Integer id) {
		service.deleteTurma(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Turma>> getTurmas() {
		List<Turma> list = service.getTurmas();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
