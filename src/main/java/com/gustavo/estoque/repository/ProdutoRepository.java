package com.gustavo.estoque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.estoque.enums.StatusProduto;
import com.gustavo.estoque.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        Optional<Produto> findBySku(String sku);
        Optional<Produto> findByNome(String nome);
        List<Produto> findByStatus(StatusProduto status);
        List<Produto> findByCategoriaId(Long categoriaId);
        List<Produto> findByFornecedorId(Long fornecedorId);
}