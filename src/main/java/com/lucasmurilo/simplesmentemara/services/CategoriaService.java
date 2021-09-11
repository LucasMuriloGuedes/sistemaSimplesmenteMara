package com.lucasmurilo.simplesmentemara.services;

import com.lucasmurilo.simplesmentemara.DTO.CategoriaDTO;
import com.lucasmurilo.simplesmentemara.entities.Categoria;
import com.lucasmurilo.simplesmentemara.repositories.CategoriaRepository;
import com.lucasmurilo.simplesmentemara.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ProdutoService produtoService;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria nao encontrada! Verifique se o Id: " + id + " realmente existe. " + Categoria.class.getName()));
    }

    public List<CategoriaDTO> findAll() {
        List<Categoria> list = repository.findAll();
        return list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        }
}
