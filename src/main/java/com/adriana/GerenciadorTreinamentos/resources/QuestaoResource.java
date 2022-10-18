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

import com.adriana.GerenciadorTreinamentos.domain.Questao;
import com.adriana.GerenciadorTreinamentos.service.QuestaoService;

@RestController
@RequestMapping("/questao")
public class QuestaoResource {

	@Autowired
	private QuestaoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Questao> getQuestao(@PathVariable Integer id) {
		Questao obj = service.getQuestao(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Questao> addQuestao(@RequestBody Questao questao) {
		questao = service.addQuestao(questao);
		return new ResponseEntity<>(questao, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Questao> editQuestao(@RequestBody Questao questao, @PathVariable Integer id) {
		questao.setId(id);
		questao = service.editQuestao(questao);
		return new ResponseEntity<>(questao, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteQuestao(@PathVariable Integer id) {
		service.deleteQuestao(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Questao>> getQuestoes() {
		List<Questao> list = service.getQuestoes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
