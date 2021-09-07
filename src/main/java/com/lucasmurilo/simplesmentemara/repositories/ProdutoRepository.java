package com.lucasmurilo.simplesmentemara.repositories;

import com.lucasmurilo.simplesmentemara.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
