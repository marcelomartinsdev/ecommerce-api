package com.api.ecommerce.service;

import com.api.ecommerce.dto.ItemPedidoDTO;
import com.api.ecommerce.dto.ProdutoRequestDTO;
import com.api.ecommerce.model.Produto;
import com.api.ecommerce.repositories.ProdutoRepository;
import com.api.ecommerce.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;


    public ProdutoService(ProdutoMapper produtoMapper) {
        this.produtoMapper = produtoMapper;
    }

    public String cadastroProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.toProduto(produtoRequestDTO);
        produto.setDataCadastro(LocalDateTime.now());
        produto.setDataModificacao(LocalDateTime.now());
        produto.setDataInsercao(LocalDateTime.now());
        produtoRepository.save(produto);
        return "Produto: " + produto.getNome() + " cadastrado com sucesso!";
    }

    public List<Produto> buscarProdutos(List<ItemPedidoDTO> itemPedidoDTOList) {
        List<Long> ids = new ArrayList<>();
        itemPedidoDTOList.forEach(itemPedidoDTO -> ids.add(itemPedidoDTO.getProdutoId()));
        return produtoRepository.findAllById(ids);
    }
}
