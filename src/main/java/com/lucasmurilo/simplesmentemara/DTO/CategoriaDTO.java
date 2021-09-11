package com.lucasmurilo.simplesmentemara.DTO;

import com.lucasmurilo.simplesmentemara.entities.Categoria;
import com.lucasmurilo.simplesmentemara.entities.Produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO implements Serializable {

    private Integer id;
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public CategoriaDTO(){

    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.produtos = categoria.getProdutos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
