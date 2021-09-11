package com.lucasmurilo.simplesmentemara.config;

import com.lucasmurilo.simplesmentemara.entities.Categoria;
import com.lucasmurilo.simplesmentemara.entities.Produto;
import com.lucasmurilo.simplesmentemara.repositories.CategoriaRepository;
import com.lucasmurilo.simplesmentemara.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Chipas");
        Categoria cat2 = new Categoria(null, "Cappuccino");

        Produto p1 = new Produto(null, "Chipa de Frango", 24.00);
        Produto p2 = new Produto(null, "Chipa de Carne Seca", 24.00);
        Produto p3 = new Produto(null, "Chipa tradicional", 24.00);

        Produto p4 = new Produto(null, "Cappuccino Tradicional", 12.00);
        Produto p5 = new Produto(null,"Cappuccino de Marshimelow", 15.00);

        p1.getCategoria().add(cat1);
        p2.getCategoria().add(cat1);
        p3.getCategoria().add(cat1);
        p4.getCategoria().add(cat2);
        p5.getCategoria().add(cat2);


        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p4, p5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));



    }
}
