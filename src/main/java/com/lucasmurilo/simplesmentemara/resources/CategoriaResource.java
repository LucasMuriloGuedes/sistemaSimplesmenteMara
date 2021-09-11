package com.lucasmurilo.simplesmentemara.resources;

import com.lucasmurilo.simplesmentemara.DTO.CategoriaDTO;
import com.lucasmurilo.simplesmentemara.entities.Categoria;
import com.lucasmurilo.simplesmentemara.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id){
        Categoria obj = service.findById(id);
        CategoriaDTO objDTO = new CategoriaDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> listDTO = service.findAll();
        return ResponseEntity.ok().body(listDTO);
    }
}
