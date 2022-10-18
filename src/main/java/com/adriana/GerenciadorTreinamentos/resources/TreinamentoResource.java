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

import com.adriana.GerenciadorTreinamentos.domain.Treinamento;
import com.adriana.GerenciadorTreinamentos.service.TreinamentoService;

@RestController
@RequestMapping("/treinamento")
public class TreinamentoResource {

	@Autowired
	private TreinamentoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Treinamento> getTreinamento(@PathVariable Integer id) {
		Treinamento obj = service.getTreinamento(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Treinamento> addTreinamento(@RequestBody Treinamento treinamento) {
		treinamento = service.addTreinamento(treinamento);
		return new ResponseEntity<>(treinamento, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Treinamento> editTreinamento(@RequestBody Treinamento treinamento, @PathVariable Integer id) {
		treinamento.setId(id);
		treinamento = service.editTreinamento(treinamento);
		return new ResponseEntity<>(treinamento, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTreinamento(@PathVariable Integer id) {
		service.deleteTreinamento(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Treinamento>> getTreinamentos() {
		List<Treinamento> list = service.getTreinamentos();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
