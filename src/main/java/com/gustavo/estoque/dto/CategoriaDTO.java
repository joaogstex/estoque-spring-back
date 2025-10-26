package com.gustavo.estoque.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.gustavo.estoque.model.entity.Categoria;

public record CategoriaDTO(Long id, String nome, LocalDateTime dataCriacao) {

    public static CategoriaDTO convertToDto(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDataCriacao());
    }

    public static List<CategoriaDTO> convertToDto(List<Categoria> categorias) {
        return categorias.stream().filter(Objects::nonNull).map(CategoriaDTO::convertToDto).toList();
    }
}
