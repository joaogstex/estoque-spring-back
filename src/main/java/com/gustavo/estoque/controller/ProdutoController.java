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

import com.gustavo.estoque.dto.ProdutoDTO;
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
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody Produto produto) {
        ProdutoDTO dto = produtoService.salvarProduto(produto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar/produtos")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> dto = produtoService.listarProdutos();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar/produtos/ativos")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosAtivos() {
        List<ProdutoDTO> dto = produtoService.listarProdutosAtivos();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar/produtos/id/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO dto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar/produtos/sku/{sku}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorSku(@PathVariable String sku) {
        ProdutoDTO dto = produtoService.buscarProdutoPorSku(sku);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar/produtos/categoria/{categoriaId}")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<ProdutoDTO> dto = produtoService.buscarProdutosPorCategoria(categoriaId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar/produtos/fornecedor/{fornecedorId}")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorFornecedor(@PathVariable Long fornecedorId) {
        List<ProdutoDTO> dto = produtoService.buscarProdutosPorFornecedor(fornecedorId);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/atualizar/produto/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody Produto produto, @PathVariable Long id) {
        ProdutoDTO dto = produtoService.atualizarProduto(produto, id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deletar/produto/{id}")
    public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Long id) {
        ProdutoDTO dto = produtoService.deletarProduto(id);
        return ResponseEntity.ok(dto);
    }
}
