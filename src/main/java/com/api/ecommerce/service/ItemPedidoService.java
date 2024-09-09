package com.api.ecommerce.service;

import com.api.ecommerce.model.ItemPedido;
import com.api.ecommerce.repositories.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPedidoService {
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido getItemPedido(Long produtoId){
        ItemPedido itemPedido = itemPedidoRepository.findByProdutoId(produtoId);
        if (itemPedido != null) {
            return itemPedido;
        }
        return null;
    }

    public void removerItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
