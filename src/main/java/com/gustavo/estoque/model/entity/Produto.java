package com.gustavo.estoque.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sku;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    @Column(name = "categoria_id")  
    private Categoria categoria;
    @Column(name = "fornecedor_id")
    private Fornecedor fornecedor;
}
