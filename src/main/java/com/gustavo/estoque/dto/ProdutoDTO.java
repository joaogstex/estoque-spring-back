package com.gustavo.estoque.dto;

import java.time.LocalDateTime;

import com.gustavo.estoque.enums.StatusProduto;
import com.gustavo.estoque.model.entity.Produto;

public record ProdutoDTO(String nome, String descricao,
        Double preco, String sku, StatusProduto status, Long categoriaId, Long fornecedorId,
        LocalDateTime dataCriacao) {

    public ProdutoDTO convertToDto(Produto produto) {
        return new ProdutoDTO(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco().doubleValue(),
                produto.getSku(),
                produto.getStatus(),
                produto.getCategoria().getId(),
                produto.getFornecedor().getId(),
                produto.getDataCriacao());
    }
}
