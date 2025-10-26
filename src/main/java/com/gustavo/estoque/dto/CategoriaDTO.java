package com.gustavo.estoque.dto;

import java.time.LocalDateTime;

import com.gustavo.estoque.model.entity.Categoria;

public record CategoriaDTO(Long id, String nome, LocalDateTime dataCriacao) {

    public CategoriaDTO convertToDto(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDataCriacao());
    }
}
