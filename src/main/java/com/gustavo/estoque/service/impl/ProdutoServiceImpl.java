package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.model.entity.Produto;

public interface ProdutoServiceImpl {
    Produto salvarProduto(Produto produto);

    List<Produto> listarProdutos();
    List<Produto> listarProdutosAtivos();

    Produto buscarProdutoPorId(Long id);
    Produto buscarProdutoPorSku(String sku);
    List<Produto> buscarProdutosPorCategoria(Long categoriaId);
    List<Produto> buscarProdutosPorFornecedor(Long fornecedorId);

    Produto atualizarProduto(Produto produto, Long id);
    Produto deletarProduto(Long id);
}
