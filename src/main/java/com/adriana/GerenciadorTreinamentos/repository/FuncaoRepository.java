package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Funcao;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {

}
