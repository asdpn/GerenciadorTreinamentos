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

import com.adriana.GerenciadorTreinamentos.domain.Resultado;
import com.adriana.GerenciadorTreinamentos.service.ResultadoService;

@RestController
@RequestMapping("/resultado")
public class ResultadoResource {

	@Autowired
	private ResultadoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Resultado> getResultado(@PathVariable Integer id) {
		Resultado obj = service.getResultado(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Resultado> addResultado(@RequestBody Resultado resultado) {
		resultado = service.addResultado(resultado);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Resultado> editResultado(@RequestBody Resultado resultado, @PathVariable Integer id) {
		resultado.setId(id);
		resultado = service.editResultado(resultado);
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteResultado(@PathVariable Integer id) {
		service.deleteResultado(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Resultado>> getResultados() {
		List<Resultado> list = service.getResultados();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
