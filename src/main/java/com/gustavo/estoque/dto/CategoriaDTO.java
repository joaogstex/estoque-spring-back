package com.gustavo.estoque.dto;

import com.gustavo.estoque.model.entity.Categoria;

public record CategoriaDTO(Long id, String nome) {

    public CategoriaDTO convertToDto(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }
}
