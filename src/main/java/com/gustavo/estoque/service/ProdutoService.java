package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.enums.StatusProduto;
import com.gustavo.estoque.model.entity.Produto;
import com.gustavo.estoque.repository.ProdutoRepository;
import com.gustavo.estoque.service.impl.ProdutoServiceImpl;

@Service
public class ProdutoService implements ProdutoServiceImpl{

    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override 
    public List<Produto> listarProdutosAtivos() {
        return produtoRepository.findByAtivo(StatusProduto.ATIVO).stream().toList();
    }

    @Override 
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
    }

    @Override
    public Produto buscarProdutoPorSku(String sku) {
        return produtoRepository.findBySku(sku).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId).stream().filter(produto -> 
        produto.getCategoria().getId().equals(categoriaId)).toList();
    }

    @Override 
    public List<Produto> buscarProdutosPorFornecedor(Long fornecedorId) {
        return produtoRepository.findByFornecedorId(fornecedorId).stream().filter(produto ->
        produto.getFornecedor().getId().equals(fornecedorId)).toList();
    }

    @Override
    public Produto atualizarProduto(Produto produto, Long id) {
        Produto produtoExistente = buscarProdutoPorId(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setSku(produto.getSku());
        produtoExistente.setStatus(produto.getStatus());
        produtoExistente.setCategoria(produto.getCategoria());
        produtoExistente.setFornecedor(produto.getFornecedor());
        return produtoRepository.save(produtoExistente);
    }

    @Override 
    public Produto deletarProduto(Long id) {
        Produto produtoExistente = buscarProdutoPorId(id);
        produtoRepository.delete(produtoExistente);
        return produtoExistente;
    }
}
