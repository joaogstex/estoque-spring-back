package com.gustavo.estoque.service.impl;

import java.util.List;

import com.gustavo.estoque.dto.FornecedorDTO;
import com.gustavo.estoque.model.entity.Fornecedor;

public interface FornecedorServiceImpl {
    FornecedorDTO salvarFornecedor(Fornecedor fornecedor);
    List<FornecedorDTO> listarFornecedores();
    List<FornecedorDTO> listarFornecedoresAtivos();
    FornecedorDTO atualizarFornecedor(Fornecedor fornecedor, Long id);
    FornecedorDTO deletarFornecedor(Long id);
}
