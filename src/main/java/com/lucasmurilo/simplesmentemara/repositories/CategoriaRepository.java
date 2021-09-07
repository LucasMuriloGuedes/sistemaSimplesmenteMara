package com.lucasmurilo.simplesmentemara.repositories;

import com.lucasmurilo.simplesmentemara.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
