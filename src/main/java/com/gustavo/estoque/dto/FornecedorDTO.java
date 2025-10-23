package com.gustavo.estoque.dto;

import com.gustavo.estoque.enums.StatusFornecedor;
import com.gustavo.estoque.enums.UF;
import com.gustavo.estoque.model.entity.Fornecedor;

public record FornecedorDTO(String nome, String cnpj, String telefone, 
String email, StatusFornecedor status, UF uf) {

    public FornecedorDTO convertToDto(Fornecedor fornecedor) {
        return new FornecedorDTO(
            fornecedor.getNome(),
            fornecedor.getCnpj(),
            fornecedor.getTelefone(),
            fornecedor.getEmail(),
            fornecedor.getStatus(),
            fornecedor.getUf()
        );
    }
}
