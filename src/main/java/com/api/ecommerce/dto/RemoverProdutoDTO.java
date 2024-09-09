package com.api.ecommerce.dto;

import lombok.Data;

@Data
public class RemoverProdutoDTO {
    private Long pedidoId;
    private Long itemPedidoId;
    private Long produtoId;
    private int quantidadeProduto;
}
