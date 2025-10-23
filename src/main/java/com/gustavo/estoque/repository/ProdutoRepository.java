package com.gustavo.estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.estoque.model.entity.Categoria;
import com.gustavo.estoque.model.entity.Fornecedor;
import com.gustavo.estoque.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        Optional<Produto> findBySku(String sku);
        Optional<Produto> findByNome(String nome);
        Optional<Categoria> findByCategoria(String categoriaNome);
        Optional<Fornecedor> findByFornecedor(String fornecedorNome);
}