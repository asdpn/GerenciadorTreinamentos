package com.adriana.GerenciadorTreinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriana.GerenciadorTreinamentos.domain.Convite;

@Repository
public interface ConviteRepository extends JpaRepository<Convite, Integer> {

}
