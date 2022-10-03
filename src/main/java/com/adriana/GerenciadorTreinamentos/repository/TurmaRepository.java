package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
