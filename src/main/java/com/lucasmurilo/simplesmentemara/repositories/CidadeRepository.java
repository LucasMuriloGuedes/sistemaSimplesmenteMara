package com.lucasmurilo.simplesmentemara.repositories;

import com.lucasmurilo.simplesmentemara.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
