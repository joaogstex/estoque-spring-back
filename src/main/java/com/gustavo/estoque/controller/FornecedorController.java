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

import com.gustavo.estoque.dto.FornecedorDTO;
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
    public ResponseEntity<FornecedorDTO> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        FornecedorDTO dto = fornecedorService.salvarFornecedor(fornecedor);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar/fornecedores")
    public ResponseEntity<List<FornecedorDTO>> listarFornecedores() {
        List<FornecedorDTO> dto = fornecedorService.listarFornecedores();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar/fornecedores/ativos")
    public ResponseEntity<List<FornecedorDTO>> listarFornecedoresAtivos() {
        List<FornecedorDTO> dto = fornecedorService.listarFornecedoresAtivos();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/atualizar/fornecedor/id/{id}")
    public ResponseEntity<FornecedorDTO> atualizarFornecedor(@RequestBody Fornecedor fornecedor, @PathVariable Long id) {
        FornecedorDTO dto = fornecedorService.atualizarFornecedor(fornecedor, id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deletar/fornecedor/id/{id}")
    public ResponseEntity<FornecedorDTO> deletarFornecedor(@PathVariable Long id) {
        FornecedorDTO dto = fornecedorService.deletarFornecedor(id);
        return ResponseEntity.ok(dto);
    }
}
