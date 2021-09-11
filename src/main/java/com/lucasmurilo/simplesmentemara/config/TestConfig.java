package com.lucasmurilo.simplesmentemara.config;

import com.lucasmurilo.simplesmentemara.entities.*;
import com.lucasmurilo.simplesmentemara.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

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

        Estado e1 = new Estado(null, "Mato Grosso");

        Cidade cid1 = new Cidade(null, "Cuiabá", e1);
        Cidade cid2 = new Cidade(null, "Barra do Garças", e1);

        estadoRepository.save(e1);
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2));

        Endereco end1 = new Endereco(null, "Rua dos pardais", "19", "Parque Ohara", "em frente ao ginásio", cid1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cli1 = new Cliente(null, "Lucas Murilo Guedes", "65988799454", sdf.parse("29/03/1988"), end1);

        enderecoRepository.save(end1);
        clienteRepository.save(cli1);




    }
}
