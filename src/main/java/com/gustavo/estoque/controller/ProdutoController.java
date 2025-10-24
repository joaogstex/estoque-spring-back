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

import com.gustavo.estoque.model.entity.Produto;
import com.gustavo.estoque.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/criar/produto")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @GetMapping("/listar/produtos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/listar/produtos/ativos")
    public ResponseEntity<List<Produto>> listarProdutosAtivos() {
        return ResponseEntity.ok(produtoService.listarProdutosAtivos());
    }

    @GetMapping("/buscar/produtos/id/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping("/buscar/produtos/sku/{sku}")
    public ResponseEntity<Produto> buscarProdutoPorSku(@PathVariable String sku) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorSku(sku));
    }

    @GetMapping("/buscar/produtos/categoria/{categoriaId}")
    public ResponseEntity<List<Produto>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(produtoService.buscarProdutosPorCategoria(categoriaId));
    }

    @GetMapping("/buscar/produtos/fornecedor/{fornecedorId}")
    public ResponseEntity<List<Produto>> buscarProdutosPorFornecedor(@PathVariable Long fornecedorId) {
        return ResponseEntity.ok(produtoService.buscarProdutosPorFornecedor(fornecedorId));
    }

    @PutMapping("/atualizar/produto/{id}")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.atualizarProduto(produto, id));
    }

    @DeleteMapping("/deletar/produto/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.deletarProduto(id));
    }
}
