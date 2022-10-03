package com.adriana.GerenciadorTreinamentos.util;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adriana.GerenciadorTreinamentos.domain.Categoria;
import com.adriana.GerenciadorTreinamentos.repository.CategoriaRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostConstruct //Comentar isso quando mudar pro banco de dados Postgre
	public void cadastrar () {
		Categoria dev = new Categoria(null,"Desenvolvimento");
		Categoria lid = new Categoria(null,"Liderança");
		Categoria com = new Categoria(null,"Comunicação");
		
		categoriaRepository.saveAll(Arrays.asList(dev, lid, com));

	}
}
