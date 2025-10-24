package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.model.entity.Categoria;
import com.gustavo.estoque.repository.CategoriaRepository;
import com.gustavo.estoque.service.impl.CategoriaServiceImpl;

@Service
public class CategoriaService implements CategoriaServiceImpl{
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override 
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria, Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de categoria não encontrado"));
        categoriaExistente.setNome(categoria.getNome());
        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public Categoria deletarCategoria(Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de categoria não encontrado"));
        categoriaRepository.delete(categoriaExistente);
        return categoriaExistente;
    }
}
