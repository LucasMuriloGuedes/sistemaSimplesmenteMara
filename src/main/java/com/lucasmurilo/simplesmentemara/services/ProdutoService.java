package com.lucasmurilo.simplesmentemara.services;

import com.lucasmurilo.simplesmentemara.DTO.ProdutoDTO;
import com.lucasmurilo.simplesmentemara.entities.Produto;
import com.lucasmurilo.simplesmentemara.repositories.ProdutoRepository;
import com.lucasmurilo.simplesmentemara.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> findAll(){
        List<Produto> list = repository.findAll();
        return list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }

    public Produto findById(Integer id){
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado! Id: " + id + ", da classe" + Produto.class.getName()));
    }


}
