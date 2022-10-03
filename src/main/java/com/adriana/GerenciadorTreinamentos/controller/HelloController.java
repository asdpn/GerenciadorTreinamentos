package com.adriana.GerenciadorTreinamentos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value="/home")
	public String getPage() {
		return "Home!";
	}
}
