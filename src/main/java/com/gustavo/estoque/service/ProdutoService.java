package com.gustavo.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.estoque.dto.ProdutoDTO;
import com.gustavo.estoque.enums.StatusProduto;
import com.gustavo.estoque.model.entity.Produto;
import com.gustavo.estoque.repository.ProdutoRepository;
import com.gustavo.estoque.service.impl.ProdutoServiceImpl;

@Service
public class ProdutoService implements ProdutoServiceImpl{

    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoDTO salvarProduto(Produto produto) {
        Produto salvar = produtoRepository.save(produto);
        return ProdutoDTO.convertToDto(salvar);
    }

    @Override
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> listar = produtoRepository.findAll();
        return ProdutoDTO.convertToDto(listar);
    }

    @Override 
    public List<ProdutoDTO> listarProdutosAtivos() {
        List<Produto> listarAtivos = produtoRepository.findByStatus(StatusProduto.ATIVO).stream().toList();
        return ProdutoDTO.convertToDto(listarAtivos);
    }

    @Override 
    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto buscarProdPorId = produtoRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
        return ProdutoDTO.convertToDto(buscarProdPorId);
    }

    @Override
    public ProdutoDTO buscarProdutoPorSku(String sku) {
        Produto buscarProdPorSku = produtoRepository.findBySku(sku).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
        return ProdutoDTO.convertToDto(buscarProdPorSku);
    }

    @Override
    public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId) {
        List<Produto> buscarProdsPorCategoria = produtoRepository.findByCategoriaId(categoriaId).stream().filter(produto -> 
        produto.getCategoria().getId().equals(categoriaId)).toList();
        return ProdutoDTO.convertToDto(buscarProdsPorCategoria);
    }

    @Override 
    public List<ProdutoDTO> buscarProdutosPorFornecedor(Long fornecedorId) {
        List<Produto> buscarProsPorFornecedor = produtoRepository.findByFornecedorId(fornecedorId).stream().filter(produto ->
        produto.getFornecedor().getId().equals(fornecedorId)).toList();
        return ProdutoDTO.convertToDto(buscarProsPorFornecedor);
    }

    @Override
    public ProdutoDTO atualizarProduto(Produto produto, Long id) {
        Produto produtoExistente = produtoRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setSku(produto.getSku());
        produtoExistente.setStatus(produto.getStatus());
        produtoExistente.setCategoria(produto.getCategoria());
        produtoExistente.setFornecedor(produto.getFornecedor());
        Produto produtoAtualizado = produtoRepository.save(produtoExistente);
        return ProdutoDTO.convertToDto(produtoAtualizado);
    }

    @Override 
    public ProdutoDTO deletarProduto(Long id) {
        Produto produtoExistente = produtoRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produtoExistente);
        return ProdutoDTO.convertToDto(produtoExistente);
    }
}
