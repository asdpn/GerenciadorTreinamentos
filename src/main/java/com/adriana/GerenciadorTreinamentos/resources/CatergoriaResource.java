package com.adriana.GerenciadorTreinamentos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;

@RestController
@RequestMapping(value = "/categoria")
public class CatergoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> mostrar() {
		
		Categoria dev = new Categoria(1, "Desenvolvimento");
		Categoria lid = new Categoria(2, "Liderança");
		Categoria com = new Categoria(3, "Comunicação");
		
		List<Categoria> lista = new ArrayList<>();
		
		lista.add(dev);
		lista.add(lid);
		lista.add(com);		
		
		return lista;
	}
}
