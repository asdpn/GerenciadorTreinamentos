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

import com.adriana.GerenciadorTreinamentos.domain.Convite;
import com.adriana.GerenciadorTreinamentos.service.ConviteService;

@RestController
@RequestMapping("/convite")
public class ConviteResource {

	@Autowired
	private ConviteService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Convite> getConvite(@PathVariable Integer id) {
		Convite obj = service.getConvite(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Convite> addConvite(@RequestBody Convite convite) {
		convite = service.addConvite(convite);
		return new ResponseEntity<>(convite, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Convite> editConvite(@RequestBody Convite convite, @PathVariable Integer id) {
		convite.setId(id);
		convite = service.editConvite(convite);
		return new ResponseEntity<>(convite, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteConvite(@PathVariable Integer id) {
		service.deleteConvite(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Convite>> getConvites() {
		List<Convite> list = service.getConvites();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
