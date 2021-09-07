package com.lucasmurilo.simplesmentemara.services;

import com.lucasmurilo.simplesmentemara.domain.Categoria;
import com.lucasmurilo.simplesmentemara.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow();
    }


}
