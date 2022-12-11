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

import com.adriana.GerenciadorTreinamentos.domain.Usuario;
import com.adriana.GerenciadorTreinamentos.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
		Usuario obj = service.getUsuario(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
		usuario = service.addUsuario(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> editUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
		usuario.setId(id);
		usuario = service.editUsuario(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
		service.deleteUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> list = service.getUsuarios();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
