package com.api.ecommerce.service;

import com.api.ecommerce.dto.AdicionarProdutoDTO;
import com.api.ecommerce.dto.PedidoRequestDTO;
import com.api.ecommerce.enums.StatusPedido;
import com.api.ecommerce.exceptions.EcommerceExceptions;
import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.model.ItemPedido;
import com.api.ecommerce.model.Pedido;
import com.api.ecommerce.model.Produto;
import com.api.ecommerce.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private PagamentoService pagamentoService;

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
        historicoService.salvarHistorico(pedido);
        return "Pedido criado com sucesso!";
    }

    private double valorTotalPedido(List<ItemPedido> itemPedidoList) {
        double valorTotal = 0;
        for (ItemPedido itemPedido : itemPedidoList) {
            valorTotal += itemPedido.getPrecoUnitario() * itemPedido.getQuantidade();
        }
        return valorTotal;
    }

    public Pedido getPedidoId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new EcommerceExceptions("Pedido com id: " + id + " não encontrado!", HttpStatus.CONFLICT));
    }

    @Transactional
    public String finalizarPedido(Long idPedido) {
        Pedido pedido = getPedidoId(idPedido);
        if (!pedido.getStatusPedido().equals(StatusPedido.EM_ATENDIMENTO)) {
            throw new EcommerceExceptions("Status do pedido: " + pedido.getStatusPedido() + " não pode ser finalizado!", HttpStatus.CONFLICT);
        }

        pagamentoService.gerarPagamento(pedido);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO_CONFIMACO_PAGAMENTO);
        log.info("Pedido {} em: {}", pedido.getPedidoId(), pedido.getStatusPedido());
        pedidoRepository.save(pedido);
        return "Pedido finalizado com sucesso!";
    }

    @Transactional
    public String adicionarProdutoNoPedido(AdicionarProdutoDTO adicionarProdutoDTO) {
        Pedido pedido = getPedidoId(adicionarProdutoDTO.getPedidoId());
        if (!pedido.getStatusPedido().equals(StatusPedido.EM_ATENDIMENTO)) {
            throw new EcommerceExceptions("O Status do pedido não está em atendimento!", HttpStatus.CONFLICT);
        }
        Produto produto = produtoService.getProduto(adicionarProdutoDTO.getProdutoId());
        int quantidadeProduto = adicionarProdutoDTO.getQuantidadeProduto();
        produtoService.validarEstoqueProduto(quantidadeProduto, produto);
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidadeProduto);
        itemPedido.setPedido(pedido);
        itemPedido.setPrecoUnitario(produto.getPreco());
        pedido.getItemPedidoList().add(itemPedido);
        pedido.setValorTotal(pedido.getValorTotal() + (produto.getPreco() + quantidadeProduto));
        pedidoRepository.save(pedido);
        produtoService.consumirEstoque(produto, quantidadeProduto);
        return "Produto adicionado ao pedido com sucesso!";
    }
}
