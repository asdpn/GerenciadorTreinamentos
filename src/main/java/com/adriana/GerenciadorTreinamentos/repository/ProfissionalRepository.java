package com.adriana.GerenciadorTreinamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;
import com.adriana.GerenciadorTreinamentos.dto.ProfissionalDTO;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
	
	//public Profissional findByEmailSenha(ProfissionalDTO profissionalDTO);
	
	//findByEmailSenha(ProfissionalDTO profissionalDTO){
	//	Optional<Profissional> profissionalEmail = profissionalDTO.
	//}
	
}
