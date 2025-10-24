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

import com.gustavo.estoque.model.entity.Fornecedor;
import com.gustavo.estoque.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping("/criar/fornecedor")
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.salvarFornecedor(fornecedor));
    }

    @GetMapping("/listar/fornecedores")
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        return ResponseEntity.ok(fornecedorService.listarFornecedores());
    }

    @GetMapping("/listar/fornecedores/ativos")
    public ResponseEntity<List<Fornecedor>> listarFornecedoresAtivos() {
        return ResponseEntity.ok(fornecedorService.listarFornecedoresAtivos());
    }

    @PutMapping("/atualizar/fornecedor/id/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@RequestBody Fornecedor fornecedor, @PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.atualizarFornecedor(fornecedor, id));
    }

    @DeleteMapping("/deletar/fornecedor/id/{id}")
    public ResponseEntity<Fornecedor> deletarFornecedor(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.deletarFornecedor(id));
    }
}
