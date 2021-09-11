package com.lucasmurilo.simplesmentemara.resources;

import com.lucasmurilo.simplesmentemara.DTO.ProdutoDTO;
import com.lucasmurilo.simplesmentemara.entities.Produto;
import com.lucasmurilo.simplesmentemara.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> objDTO = service.findAll();
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id){
        Produto obj = service.findById(id);
        ProdutoDTO objDTO = new ProdutoDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }
}
