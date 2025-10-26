package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.dto.CategoriaDTO;
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
    public CategoriaDTO salvarCategoria(Categoria categoria) {
        Categoria salvar = categoriaRepository.save(categoria);
        return CategoriaDTO.convertToDto(salvar);
    }

    @Override 
    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> listar = categoriaRepository.findAll();
        return CategoriaDTO.convertToDto(listar);
    }

    @Override
    public CategoriaDTO atualizarCategoria(Categoria categoria, Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de categoria não encontrado"));
        categoriaExistente.setNome(categoria.getNome());
        Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistente);
        return CategoriaDTO.convertToDto(categoriaAtualizada);
    }

    @Override
    public CategoriaDTO deletarCategoria(Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de categoria não encontrado"));
        categoriaRepository.delete(categoriaExistente);
        return CategoriaDTO.convertToDto(categoriaExistente);
    }
}
