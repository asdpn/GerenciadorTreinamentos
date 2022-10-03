package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Integer> {

}
