package com.api.ecommerce.service;

import com.api.ecommerce.dto.PedidoRequestDTO;
import com.api.ecommerce.enums.StatusPedido;
import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.model.ItemPedido;
import com.api.ecommerce.model.Pedido;
import com.api.ecommerce.model.Produto;
import com.api.ecommerce.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public String cadastroPedido(PedidoRequestDTO pedidoRequestDTO) {

        Cliente cliente = clienteService.retornarCliente(pedidoRequestDTO.getClienteId());
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setEndereco(cliente.getEnderecoList().get(0));

        List<ItemPedido> itemPedidoList = new ArrayList<>();
        List<Produto> produtoList = produtoService.buscarProdutos(pedidoRequestDTO.getItemPedidoDTOS());
        int cont = 0;
        for (Produto produto : produtoList) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(pedidoRequestDTO.getItemPedidoDTOS().get(cont).getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPreco());
            itemPedidoList.add(itemPedido);
            cont++;
        }

        pedido.setItemPedidoList(itemPedidoList);
        pedido.setValorTotal(valorTotalPedido(itemPedidoList));
        pedido.setStatusPedido(StatusPedido.EM_ATENDIMENTO);
        pedidoRepository.save(pedido);
        produtoService.consumirEstoque(produtoList, pedidoRequestDTO.getItemPedidoDTOS());
        log.info("Pedido criado para o cliente: {}", cliente.getName());
        return "Pedido criado com sucesso!";
    }

    private double valorTotalPedido(List<ItemPedido> itemPedidoList) {
        double valorTotal = 0;
        for (ItemPedido itemPedido : itemPedidoList) {
            valorTotal += itemPedido.getPrecoUnitario() * itemPedido.getQuantidade();
        }
        return valorTotal;
    }
}
