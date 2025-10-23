package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.model.entity.Categoria;

public interface CategoriaServiceImpl {
    Categoria salvarCategoria(Categoria categoria);
    List<Categoria> listarCategorias();
    List<Categoria> listarCategoriasAtivas();
    Categoria atualizarCategoria(Categoria categoria, Long id);
    Categoria deletarCategoria(Long id);
}
