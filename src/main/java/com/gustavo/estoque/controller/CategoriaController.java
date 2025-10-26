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

import com.gustavo.estoque.dto.CategoriaDTO;
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
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody Categoria categoria) {
        CategoriaDTO dto = categoriaService.salvarCategoria(categoria);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar/categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> dto = categoriaService.listarCategorias();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/atualizar/categoria/id/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        CategoriaDTO dto = categoriaService.atualizarCategoria(categoria, id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deletar/categoria/id/{id}")
    public ResponseEntity<CategoriaDTO> deletarCategoria(@PathVariable Long id) {
        CategoriaDTO dto = categoriaService.deletarCategoria(id);
        return ResponseEntity.ok(dto);
    }
}