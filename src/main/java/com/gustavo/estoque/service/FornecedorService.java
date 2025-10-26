package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.enums.StatusFornecedor;
import com.gustavo.estoque.model.entity.Fornecedor;
import com.gustavo.estoque.repository.FornecedorRepository;
import com.gustavo.estoque.service.impl.FornecedorServiceImpl;

@Service
public class FornecedorService implements FornecedorServiceImpl{

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override 
    public List<Fornecedor> listarFornecedoresAtivos() {
        return fornecedorRepository.findByStatus(StatusFornecedor.ATIVO).stream().toList();
    }

    @Override
    public Fornecedor atualizarFornecedor(Fornecedor fornecedor, Long id) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de fornecedor não encontrado"));
        fornecedorExistente.setNome(fornecedor.getNome());
        fornecedorExistente.setCnpj(fornecedor.getCnpj());
        fornecedorExistente.setTelefone(fornecedor.getTelefone());
        fornecedorExistente.setEmail(fornecedor.getEmail());
        fornecedorExistente.setEndereco(fornecedor.getEndereco());
        fornecedorExistente.setStatus(fornecedor.getStatus());
        fornecedorExistente.setUf(fornecedor.getUf());
        fornecedorExistente.setCidade(fornecedor.getCidade());
        return fornecedorRepository.save(fornecedorExistente);
    }

    @Override
    public Fornecedor deletarFornecedor(Long id) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Id de fornecedor não encontrado"));
        fornecedorRepository.delete(fornecedorExistente);
        return fornecedorExistente;
    }
}
