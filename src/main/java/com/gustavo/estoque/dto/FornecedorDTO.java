package com.gustavo.estoque.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.gustavo.estoque.enums.StatusFornecedor;
import com.gustavo.estoque.enums.UF;
import com.gustavo.estoque.model.entity.Fornecedor;

public record FornecedorDTO(Long id, String nome, String cnpj, String telefone,
        String email, StatusFornecedor status, UF uf, String cidade, LocalDateTime dataCriacao) {

    public static FornecedorDTO convertToDto(Fornecedor fornecedor) {
        return new FornecedorDTO(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getEmail(),
                fornecedor.getStatus(),
                fornecedor.getUf(),
                fornecedor.getCidade(),
                fornecedor.getDataCriacao());
    }

    public static List<FornecedorDTO> convertToDto(List<Fornecedor> fornecedores) {
        return fornecedores.stream().filter(Objects::nonNull).map(FornecedorDTO::convertToDto).toList();
    }
}
