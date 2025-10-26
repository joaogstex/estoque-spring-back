package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.dto.ProdutoDTO;
import com.gustavo.estoque.model.entity.Produto;

public interface ProdutoServiceImpl {
    ProdutoDTO salvarProduto(Produto produto);

    List<ProdutoDTO> listarProdutos();
    List<ProdutoDTO> listarProdutosAtivos();

    ProdutoDTO buscarProdutoPorId(Long id);
    ProdutoDTO buscarProdutoPorSku(String sku);
    List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId);
    List<ProdutoDTO> buscarProdutosPorFornecedor(Long fornecedorId);

    ProdutoDTO atualizarProduto(Produto produto, Long id);
    ProdutoDTO deletarProduto(Long id);
}
