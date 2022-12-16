package com.escolinha.futebol.repository;


import com.escolinha.futebol.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
