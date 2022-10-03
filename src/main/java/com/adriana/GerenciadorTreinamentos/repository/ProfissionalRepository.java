package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

}
