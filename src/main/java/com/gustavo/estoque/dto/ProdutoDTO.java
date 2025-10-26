package com.gustavo.estoque.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.gustavo.estoque.enums.StatusProduto;
import com.gustavo.estoque.model.entity.Produto;

public record ProdutoDTO(Long id, String nome, String descricao,
        Double preco, String sku, StatusProduto status, Long categoriaId, Long fornecedorId,
        LocalDateTime dataCriacao) {

    public static ProdutoDTO convertToDto(Produto produto) {
        if (produto == null) {
            return null;
        }
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco().doubleValue(),
                produto.getSku(),
                produto.getStatus(),
                produto.getCategoria() != null ? produto.getCategoria().getId() : null,
                produto.getFornecedor() != null ? produto.getFornecedor().getId() : null,
                produto.getDataCriacao());
    }

    public static List<ProdutoDTO> convertToDto(List<Produto> produtos) {
        return produtos.stream().filter(Objects::nonNull).map(ProdutoDTO::convertToDto).toList();
    }
}
