package com.api.ecommerce.repositories;

import com.api.ecommerce.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    ItemPedido findByProdutoId(Long produtoId);
}
