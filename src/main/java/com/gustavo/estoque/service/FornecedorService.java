package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.dto.FornecedorDTO;
import com.gustavo.estoque.enums.StatusFornecedor;
import com.gustavo.estoque.model.entity.Fornecedor;
import com.gustavo.estoque.repository.FornecedorRepository;
import com.gustavo.estoque.service.impl.FornecedorServiceImpl;

@Service
public class FornecedorService implements FornecedorServiceImpl {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public FornecedorDTO salvarFornecedor(Fornecedor fornecedor) {
        Fornecedor salvar = fornecedorRepository.save(fornecedor);
        return FornecedorDTO.convertToDto(salvar);
    }

    @Override
    public List<FornecedorDTO> listarFornecedores() {
        List<Fornecedor> listar = fornecedorRepository.findAll();
        return FornecedorDTO.convertToDto(listar);
    }

    @Override
    public List<FornecedorDTO> listarFornecedoresAtivos() {
        List<Fornecedor> listarAtivos = fornecedorRepository.findByStatus(StatusFornecedor.ATIVO).stream().toList();
        return FornecedorDTO.convertToDto(listarAtivos);
    }

    @Override
    public FornecedorDTO atualizarFornecedor(Fornecedor fornecedor, Long id) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id de fornecedor não encontrado"));
        fornecedorExistente.setNome(fornecedor.getNome());
        fornecedorExistente.setCnpj(fornecedor.getCnpj());
        fornecedorExistente.setTelefone(fornecedor.getTelefone());
        fornecedorExistente.setEmail(fornecedor.getEmail());
        fornecedorExistente.setEndereco(fornecedor.getEndereco());
        fornecedorExistente.setStatus(fornecedor.getStatus());
        fornecedorExistente.setUf(fornecedor.getUf());
        fornecedorExistente.setCidade(fornecedor.getCidade());
        Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedorExistente);
        return FornecedorDTO.convertToDto(fornecedorAtualizado);
    }

    @Override
    public FornecedorDTO deletarFornecedor(Long id) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id de fornecedor não encontrado"));
        fornecedorRepository.delete(fornecedorExistente);
        return FornecedorDTO.convertToDto(fornecedorExistente);
    }
}
