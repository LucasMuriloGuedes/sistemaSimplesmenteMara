package com.lucasmurilo.simplesmentemara.repositories;

import com.lucasmurilo.simplesmentemara.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
