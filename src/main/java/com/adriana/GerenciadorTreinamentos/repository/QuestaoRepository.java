package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}
