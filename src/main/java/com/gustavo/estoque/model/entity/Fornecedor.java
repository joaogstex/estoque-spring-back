package com.gustavo.estoque.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.gustavo.estoque.enums.StatusFornecedor;
import com.gustavo.estoque.enums.UF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long id;

    @Column(name = "nome_fornecedor", length = 120)
    private String nome;

    @Column(name = "email_fornecedor")
    private String email;

    @Column(name = "telefone_fornecedor")
    private String telefone;

    @Column(name = "endereco_fornecedor")
    private String endereco;

    @Column(name = "cnpj_fornecedor", length = 14)
    private String cnpj;

    @Column(name = "status_fornecedor")
    @Enumerated(EnumType.ORDINAL)
    private StatusFornecedor status;

    @Column(name = "uf_fornecedor")
    @Enumerated(EnumType.ORDINAL)
    private UF uf;

    @Column(name = "cidade_fornecedor")
    private String cidade;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}
