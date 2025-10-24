package com.gustavo.estoque.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.estoque.model.entity.Categoria;
import com.gustavo.estoque.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/criar/categoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.salvarCategoria(categoria));
    }

    @GetMapping("/listar/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @PutMapping("/atualizar/categoria/id/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.atualizarCategoria(categoria, id));
    }

    @DeleteMapping("/deletar/categoria/id/{id}")
    public ResponseEntity<Categoria> deletarCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.deletarCategoria(id));
    }
}