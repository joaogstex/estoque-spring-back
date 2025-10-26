package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.dto.CategoriaDTO;
import com.gustavo.estoque.model.entity.Categoria;

public interface CategoriaServiceImpl {
    CategoriaDTO salvarCategoria(Categoria categoria);
    List<CategoriaDTO> listarCategorias();
    CategoriaDTO atualizarCategoria(Categoria categoria, Long id);
    CategoriaDTO deletarCategoria(Long id);
}
