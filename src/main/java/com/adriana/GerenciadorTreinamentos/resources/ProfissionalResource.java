package com.adriana.GerenciadorTreinamentos.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.dto.ProfissionalDTO;
import com.adriana.GerenciadorTreinamentos.service.ProfissionalService;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalResource {

	@Autowired
	ProfissionalService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profissional> find(@PathVariable Integer id) {
		Profissional obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profissional> insert (@RequestBody Profissional obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Profissional obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Juntar findAll para mostrar DTO para consulta e normal para quem não tem perfil edição
	//@RequestMapping(method = RequestMethod.GET)
	//public ResponseEntity<List<?>> findAll() {
	//	List<Profissional> list = service.findAll();
	//	return ResponseEntity.ok().body(list);
	//}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfissionalDTO>> findAllDTO() {
		List<Profissional> list = service.findAll();
		List<ProfissionalDTO> listDTO = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
