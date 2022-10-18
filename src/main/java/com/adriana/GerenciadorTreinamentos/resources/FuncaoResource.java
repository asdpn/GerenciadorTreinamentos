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

import com.adriana.GerenciadorTreinamentos.domain.Funcao;
import com.adriana.GerenciadorTreinamentos.service.FuncaoService;

@RestController
@RequestMapping("/funcao")
public class FuncaoResource {

	@Autowired
	private FuncaoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcao> getFuncao(@PathVariable Integer id) {
		Funcao obj = service.getFuncao(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Funcao> addFuncao(@RequestBody Funcao funcao) {
		funcao = service.addFuncao(funcao);
		return new ResponseEntity<>(funcao, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Funcao> editFuncao(@RequestBody Funcao funcao, @PathVariable Integer id) {
		funcao.setId(id);
		funcao = service.editFuncao(funcao);
		return new ResponseEntity<>(funcao, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFuncao(@PathVariable Integer id) {
		service.deleteFuncao(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Funcao>> getFuncoes() {
		List<Funcao> list = service.getFuncoes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
