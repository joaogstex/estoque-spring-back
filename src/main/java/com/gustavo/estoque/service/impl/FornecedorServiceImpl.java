package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.model.entity.Fornecedor;

public interface FornecedorServiceImpl {
    Fornecedor salvarFornecedor(Fornecedor fornecedor);
    List<Fornecedor> listarFornecedores();
    List<Fornecedor> listarFornecedoresAtivos();
    Fornecedor atualizarFornecedor(Fornecedor fornecedor, Long id);
    Fornecedor deletarFornecedor(Long id);
}
