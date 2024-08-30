package com.api.ecommerce.service;

import com.api.ecommerce.dto.ItemPedidoDTO;
import com.api.ecommerce.dto.ProdutoRequestDTO;
import com.api.ecommerce.model.Produto;
import com.api.ecommerce.repositories.ProdutoRepository;
import com.api.ecommerce.service.mapper.ProdutoMapper;
import jakarta.transaction.Transactional;
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
        List<Produto> response = new ArrayList<>();
        for (ItemPedidoDTO itemPedido : itemPedidoDTOList) {
            Produto produto = getProduto(itemPedido.getProdutoId());
            if (produto.getQuantidadeEstoque() < itemPedido.getQuantidade()) {
                throw new RuntimeException("O produto: " + produto.getNome() + " não possui estoque suficiente!");
            }
            response.add(produto);
        }
        return response;
    }

    public Produto getProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto: " + id + " nao cadastrado!"));
    }

    @Transactional
    public void consumirEstoque(List<Produto> produtoList, List<ItemPedidoDTO> itemPedidoDTOList) {
        int cont = 0;
        for (Produto produto : produtoList) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemPedidoDTOList.get(cont).getQuantidade());
            cont++;
        }
        produtoRepository.saveAll(produtoList);
    }
}
