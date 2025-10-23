package com.gustavo.estoque.model.entity;

import java.math.BigDecimal;

import com.gustavo.estoque.enums.StatusProduto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_produto", length = 200)
    private String nome;

    @Column(name = "sku_produto")
    private String sku;

    @Column(name = "descricao_produto", length = 500)
    private String descricao;

    @Column(name = "preco_produto")
    private BigDecimal preco;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @Column(name = "status_produto")
    private StatusProduto status;

    @Column(name = "id_categoria")  
    @ManyToOne
    private Categoria categoria;
    @Column(name = "id_fornecedor")
    @ManyToOne
    private Fornecedor fornecedor;
}
